package cn.edu.jssvc.zhuzhengjun.myjsoup.fragment_homepage_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
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

import cn.edu.jssvc.zhuzhengjun.myjsoup.Adapter.Meishi;
import cn.edu.jssvc.zhuzhengjun.myjsoup.Adapter.MeishiAdapter;
import cn.edu.jssvc.zhuzhengjun.myjsoup.Main2Activity;
import cn.edu.jssvc.zhuzhengjun.myjsoup.R;
import cn.edu.jssvc.zhuzhengjun.myjsoup.function.HttpRequest;
import cn.edu.jssvc.zhuzhengjun.myjsoup.function.MyApplication;

public class Fragment_homePage_1_2 extends Fragment {

    private SwipeRefreshLayout myXiala;

    private ListView listView;
    private Meishi meishi;
    private List<Meishi> meishiList = new ArrayList<>();
    private MeishiAdapter meishiAdapter;

    private List<String> linksList = new ArrayList<>();    //链接
    private List<String> imagesList = new ArrayList<>();   //图片
    private List<String> titlesList = new ArrayList<>();    //标题
    private List<String> zuozhesList = new ArrayList<>();   //作者

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout_home_page_1_2, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        myXiala.setRefreshing(true);
        getData();
    }

    private void getData() {
        zuozhesList.clear();
        titlesList.clear();
        imagesList.clear();
        linksList.clear();
        meishiList.clear();
        HttpRequest.get("https://home.meishichina.com/show-top-type-recipe-order-quarter.html", new Response.Listener<String>() {
            @Override
            public void onResponse(String str) {
                Document document = Jsoup.parse(str);
                Elements links = document.select("div.ui_newlist_1 ul li");
                for (Element link : links) {
                    Log.d("item链接", link.select(".pic a:lt(13)").attr("href"));
                    Log.d("图片链接", link.select(".pic img:lt(13)").attr("data-src"));
                    Log.d("标题链接", link.select(".detail h2:lt(13)").text());
                    Log.d("作者链接", link.select(".detail p.subline a:lt(13)").text());
                    Log.d("配料链接", link.select(".detail p.subcontent:lt(13)").text());

                    linksList.add(link.select(".pic a:lt(13)").attr("href"));
                    imagesList.add(link.select(".pic img:lt(13)").attr("data-src"));
                    titlesList.add(link.select(".detail h2:lt(13)").text());
                    zuozhesList.add(link.select(".detail p.subline a:lt(13)").text());

                    meishi = new Meishi();
                    meishi.setImage(link.select(".pic img:lt(13)").attr("data-src"));
                    meishi.setTitle(link.select(".detail h2 a:lt(13)").text());
                    meishi.setAuthor(link.select(".detail p.subline a:lt(13)").text());
                    meishi.setMaterial(link.select(".detail p.subcontent:lt(13)").text());
                    meishiList.add(meishi);
                    meishiAdapter.notifyDataSetChanged();
                    myXiala.setRefreshing(false);
                }
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(MyApplication.mContext.getApplicationContext(),"网络连接超时",Toast.LENGTH_SHORT).show();
                myXiala.setRefreshing(false);
            }
        });
    }

    private void init() {
        listView = getActivity().findViewById(R.id.myFragment_1_2_listView);
        meishiAdapter = new MeishiAdapter(getContext(), R.layout.fragment_1_listview_item, meishiList);
        listView.setAdapter(meishiAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), Main2Activity.class);
                intent.putExtra("data", linksList.get(position));
                intent.putExtra("image", imagesList.get(position));
                intent.putExtra("title", titlesList.get(position));
                intent.putExtra("zuozhe", zuozhesList.get(position));
                intent.putExtra("time", new SimpleDateFormat("MM-dd HH:mm").format(new Date(System.currentTimeMillis())));
                intent.putExtra("isLishi", "yes");
                startActivity(intent);
            }
        });
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                switch (i) {
                    case SCROLL_STATE_IDLE:
                        if (isListViewReachBottomEdge(absListView)) {
                            update();
                        }
                        break;
                    default:
                        break;
                }
            }
            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {}
        });
        myXiala = getActivity().findViewById(R.id.myXialashuaxin_SwipeRefreshLayout_2);
        myXiala.setColorSchemeResources(R.color.colorAccent);
        myXiala.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });
    }

    private boolean isListViewReachBottomEdge(AbsListView listView) {
        boolean result = false;
        if (listView.getLastVisiblePosition() == (listView.getCount() - 1)) {
            final View bottomChildView = listView.getChildAt(listView.getLastVisiblePosition() - listView.getFirstVisiblePosition());
            result = (listView.getHeight() >= bottomChildView.getBottom());
        };
        return result;
    }

    private int i = 1;
    private void update() {
        i ++;
//        if (i <= 5) {
            HttpRequest.get("https://home.meishichina.com/show-top-type-recipe-order-quarter-page-" + i + ".html", new Response.Listener<String>() {
                @Override
                public void onResponse(String str) {
                    Document document = Jsoup.parse(str);
                    Elements links = document.select("div.ui_newlist_1 ul li");
                    for (Element link : links) {
                        Log.d("item链接", link.select(".pic a:lt(13)").attr("href"));
                        Log.d("图片链接", link.select(".pic img:lt(13)").attr("data-src"));
                        Log.d("标题链接", link.select(".detail h2:lt(13)").text());
                        Log.d("作者链接", link.select(".detail p.subline a:lt(13)").text());
                        Log.d("配料链接", link.select(".detail p.subcontent:lt(13)").text());

                        linksList.add(link.select(".pic a:lt(13)").attr("href"));
                        imagesList.add(link.select(".pic img:lt(13)").attr("data-src"));
                        titlesList.add(link.select(".detail h2:lt(13)").text());
                        zuozhesList.add(link.select(".detail p.subline a:lt(13)").text());

                        meishi = new Meishi();
                        meishi.setImage(link.select(".pic img:lt(13)").attr("data-src"));
                        meishi.setTitle(link.select(".detail h2 a:lt(13)").text());
                        meishi.setAuthor(link.select(".detail p.subline a:lt(13)").text());
                        meishi.setMaterial(link.select(".detail p.subcontent:lt(13)").text());
                        meishiList.add(meishi);
                        myXiala.setRefreshing(false);
                    }
                    meishiAdapter.notifyDataSetChanged();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    Toast.makeText(MyApplication.mContext.getApplicationContext(), "到底了...", Toast.LENGTH_SHORT).show();
                    myXiala.setRefreshing(false);
                }
            });
//        }
    }
}
