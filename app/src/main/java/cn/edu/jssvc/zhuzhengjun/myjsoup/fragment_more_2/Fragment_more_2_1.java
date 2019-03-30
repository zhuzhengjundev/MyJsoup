package cn.edu.jssvc.zhuzhengjun.myjsoup.fragment_more_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.edu.jssvc.zhuzhengjun.myjsoup.Adapter.Meishi2;
import cn.edu.jssvc.zhuzhengjun.myjsoup.Adapter.Meishi2Adapter;
import cn.edu.jssvc.zhuzhengjun.myjsoup.Main2Activity;
import cn.edu.jssvc.zhuzhengjun.myjsoup.R;
import cn.edu.jssvc.zhuzhengjun.myjsoup.function.HttpRequest;
import cn.edu.jssvc.zhuzhengjun.myjsoup.function.MyApplication;

public class Fragment_more_2_1 extends Fragment {

    private SwipeRefreshLayout swipeRefreshLayout;

    private GridView gridView;
    private Meishi2 meishi2;
    private List<Meishi2> meishi2List = new ArrayList<>();
    private Meishi2Adapter meishi2Adapter;

    private List<String> linksList = new ArrayList<>();    //链接
    private List<String> imagesList = new ArrayList<>();   //图片
    private List<String> titlesList = new ArrayList<>();    //标题
    private List<String> zuozhesList = new ArrayList<>();   //作者

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout_more_2_1, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        swipeRefreshLayout.setRefreshing(true);
        getData();
    }

    private void getData() {
        meishi2List.clear();
        linksList.clear();
        imagesList.clear();
        titlesList.clear();
        zuozhesList.clear();
        HttpRequest.get("https://home.meishichina.com/recipe.html", new Response.Listener<String>() {
            @Override
            public void onResponse(String str) {
                Document document = Jsoup.parse(str);
                Elements links = document.select("div.wrap div.clear div.big4_list ul");
                Elements links_1 = links.get(0).select("li");
                for (Element link : links_1) {
                    Log.d("link_图片", link.select("a").get(0).select("i img.imgLoad").attr("data-src"));
                    Log.d("link_菜名", link.select("a").get(0).select("p").text());
                    Log.d("link_人名", link.select("a").get(1).text());
                    Log.d("link_链接", link.select("a").get(0).attr("href"));
                    meishi2 = new Meishi2(link.select("a").get(0).select("i img.imgLoad").attr("data-src"), link.select("a").get(0).select("p").text(), link.select("a").get(1).text());
                    meishi2List.add(meishi2);

                    linksList.add(link.select("a").get(0).attr("href"));
                    imagesList.add(link.select("a").get(0).select("i img.imgLoad").attr("data-src"));
                    titlesList.add(link.select("a").get(0).select("p").text());
                    zuozhesList.add(link.select("a").get(1).text());

                    meishi2Adapter.notifyDataSetChanged();
                }
                swipeRefreshLayout.setRefreshing(false);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(MyApplication.mContext.getApplicationContext(),"网络连接超时",Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void init() {
        swipeRefreshLayout = getActivity().findViewById(R.id.myXialashuaxin_SRfLayout_1);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });
        gridView = getActivity().findViewById(R.id.myFragment_2_1_gridView);
        meishi2Adapter = new Meishi2Adapter(getContext(), R.layout.fragment_2_gridview_item, meishi2List);
        gridView.setAdapter(meishi2Adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), Main2Activity.class);
                intent.putExtra("data", linksList.get(position));
                intent.putExtra("image", imagesList.get(position));
                intent.putExtra("title", titlesList.get(position));
                intent.putExtra("zuozhe", zuozhesList.get(position));
                intent.putExtra("time", new SimpleDateFormat("MM-dd HH:mm").format(new Date(System.currentTimeMillis())));
                startActivity(intent);
            }
        });
    }
}
