package cn.edu.jssvc.zhuzhengjun.myjsoup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.edu.jssvc.zhuzhengjun.myjsoup.Adapter.Meishi3;
import cn.edu.jssvc.zhuzhengjun.myjsoup.Adapter.Meishi3Adapter;
import cn.edu.jssvc.zhuzhengjun.myjsoup.function.HttpRequest;
import cn.edu.jssvc.zhuzhengjun.myjsoup.function.MyApplication;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class Main3Activity extends AppCompatActivity {

    private String jieshou_link,jieshou_links;                                                     //收到的链接
    private LinearLayout linearLayout_background,linearLayout_back;               //背景图和返回
    private SwipeRefreshLayout swipeRefreshLayout;                                   //刷新界面
    private ImageView imageView_touxiang,imageView_xingbie;                       //头像和性别
    private TextView textView_name,textView_time,textView_caipu_title;           //网名和加入时间和菜谱Title
    private TextView textView_fensi,textView_guanzhu,textView_fangwen;           //粉丝、关注、访问

    private ListView listView;        //自定义ListView
    private Meishi3 meishi3;
    private List<Meishi3> meishi3List = new ArrayList<>();
    private Meishi3Adapter meishi3Adapter;

    private List<String> linksLists = new ArrayList<>();    //链接
    private List<String> imagesList = new ArrayList<>();   //图片
    private List<String> titlesList = new ArrayList<>();    //标题
    private String zuozhe = "";   //作者

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent = getIntent();
        jieshou_links = intent.getStringExtra("data2").substring(0, intent.getStringExtra("data2").length() - 5);
        jieshou_link = intent.getStringExtra("data2").substring(0, intent.getStringExtra("data2").length() - 5) + "-do-recipe.html";
        init();
        getData();
    }

    private void getData() {
        linksLists.clear();
        imagesList.clear();
        titlesList.clear();
        meishi3List.clear();
        HttpRequest.get2(jieshou_link, new Response.Listener<String>() {
            @Override
            public void onResponse(String str) {
                Document document = Jsoup.parse(str);
                Elements links = document.select("div.space_wrap");
                Log.d("link_头像", links.select("div.space_info div.mod div.pic a img.imgLoad").attr("data-src"));
                Log.d("link_网名", links.select("div.space_info div.mod div.detail div.subname em a").text());
                Log.d("link_性别", links.select("div.space_info div.mod div.detail div.subname i").get(0).attr("class"));
                Log.d("link_加入时间", links.select("div.space_info div.mod div.detail div.subname i").get(1).text());
                Log.d("link_粉丝", links.select("div.space_info div.mod div.detail div.subtools div.right ul.substatus li").get(0).select("a b").text());
                Log.d("link_关注", links.select("div.space_info div.mod div.detail div.subtools div.right ul.substatus li").get(1).select("a b").text());
                Log.d("link_访问", links.select("div.space_info div.mod div.detail div.subtools div.right ul.substatus li").get(2).select("a b").text());
                linearLayout_background.setBackgroundDrawable(getResources().getDrawable(R.drawable.geren_background));
                RequestOptions circleCrop = new RequestOptions().circleCrop();
                Glide.with(Main3Activity.this)// 为当前Activity 加载图片
                        .load(links.select("div.space_info div.mod div.pic a img.imgLoad").attr("data-src"))// 从URL 中加载
                        .apply(circleCrop)// 应用请求选项
                        .transition(withCrossFade())
                        .into(imageView_touxiang);// 用ImageView 显示
                textView_name.setText(links.select("div.space_info div.mod div.detail div.subname em a").text());
                zuozhe = links.select("div.space_info div.mod div.detail div.subname em a").text();
                String sex = links.select("div.space_info div.mod div.detail div.subname i").get(0).attr("class");
                if (sex.indexOf("wo") == -1) {
                    Log.d("link_性别", "男");
                    imageView_xingbie.setImageResource(R.drawable.nan);
                }else {
                    Log.d("link_性别", "女");
                    imageView_xingbie.setImageResource(R.drawable.nv);
                }
                textView_time.setText(links.select("div.space_info div.mod div.detail div.subname i").get(1).text());
                textView_fensi.setText("粉丝：" + links.select("div.space_info div.mod div.detail div.subtools div.right ul.substatus li").get(0).select("a b").text());
                textView_guanzhu.setText("关注：" + links.select("div.space_info div.mod div.detail div.subtools div.right ul.substatus li").get(1).select("a b").text());
                textView_fangwen.setText("访问：" + links.select("div.space_info div.mod div.detail div.subtools div.right ul.substatus li").get(2).select("a b").text());

                Elements links_2 = document.select("div.wrap div.clear");
                Log.d("link_菜谱归属", links_2.select("div.ui_title div.ui_title_wrap h3.on").get(0).text());
                textView_caipu_title.setText(links_2.select("div.ui_title div.ui_title_wrap h3.on").get(0).text());
                Elements links_2_1ist = links_2.select("div.ui_newlist_1 ul li");
                for (Element link : links_2_1ist) {
                    Log.d("link—listView—链接",link.select("div.pic a").attr("href"));
                    Log.d("link—listView—图片",link.select("div.pic a img").attr("data-src"));
                    Log.d("link—listView—名字",link.select("div.pic a").attr("title"));
                    Log.d("link—listView—时间",link.select("div.detail p.subline").text());
                    Log.d("link—listView—配料",link.select("div.detail p.subcontent").text());
                    Log.d("link—listView—浏览总数",link.select("div.detail div.substatus span.get_nums").removeAttr("style").text());

                    linksLists.add(link.select("div.pic a").attr("href"));
                    imagesList.add(link.select("div.pic a img").attr("data-src"));
                    titlesList.add(link.select("div.pic a").attr("title"));

                    meishi3 = new Meishi3(link.select("div.pic a img").attr("data-src"), link.select("div.pic a").attr("title"), link.select("div.detail p.subline").text(), link.select("div.detail p.subcontent").text(),"");
                    meishi3List.add(meishi3);
                    meishi3Adapter.notifyDataSetChanged();
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
        linearLayout_back = findViewById(R.id.main3_back);
        linearLayout_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        swipeRefreshLayout = findViewById(R.id.main3_activitySwipeRefreshLayout);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });
        swipeRefreshLayout.setRefreshing(true);
        linearLayout_background = findViewById(R.id.main3_activity_background);
        imageView_touxiang = findViewById(R.id.main3_activity_touxiang);
        imageView_xingbie = findViewById(R.id.main3_activity_xingbie);
        textView_name = findViewById(R.id.main3_activity_name);
        textView_time = findViewById(R.id.main3_activity_time);
        textView_fensi = findViewById(R.id.main3_activity_fensi);
        textView_guanzhu = findViewById(R.id.main3_activity_guanzhu);
        textView_fangwen = findViewById(R.id.main3_activity_fangwen);
        textView_caipu_title = findViewById(R.id.main3_activity_caipu);
        listView = findViewById(R.id.main3_activity_ListView);
        meishi3Adapter = new Meishi3Adapter(Main3Activity.this, R.layout.main3_activity_listview_item, meishi3List);
        listView.setAdapter(meishi3Adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Main3Activity.this, TopActivity.class);
                intent.putExtra("data", linksLists.get(position));
                intent.putExtra("image", imagesList.get(position));
                intent.putExtra("title", titlesList.get(position));
                intent.putExtra("zuozhe", zuozhe);
                intent.putExtra("time", new SimpleDateFormat("MM-dd HH:mm").format(new Date(System.currentTimeMillis())));
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
            HttpRequest.get2(jieshou_links + "-do-recipe-page-"+i+".html", new Response.Listener<String>() {
                @Override
                public void onResponse(String str) {
                    Document document = Jsoup.parse(str);
                    document.select("*[style=display:none]").remove();
                    Elements links_2 = document.select("div.wrap div.clear");
                    Elements links_2_1ist = links_2.select("div.ui_newlist_1 ul li");
                    for (Element link : links_2_1ist) {
                        Log.d("link—listView—链接",link.select("div.pic a").attr("href"));
                        Log.d("link—listView—图片",link.select("div.pic a img").attr("data-src"));
                        Log.d("link—listView—名字",link.select("div.pic a").attr("title"));
                        Log.d("link—listView—时间",link.select("div.detail p.subline").text());
                        Log.d("link—listView—配料",link.select("div.detail p.subcontent").text());
                        Log.d("link—listView—浏览总数",link.select("div.detail div.substatus span.get_nums").text());

                        linksLists.add(link.select("div.pic a").attr("href"));
                        imagesList.add(link.select("div.pic a img").attr("data-src"));
                        titlesList.add(link.select("div.pic a").attr("title"));

                        meishi3 = new Meishi3(link.select("div.pic a img").attr("data-src"), link.select("div.pic a").attr("title"), link.select("div.detail p.subline").text(), link.select("div.detail p.subcontent").text(),"");
                        meishi3List.add(meishi3);
                        meishi3Adapter.notifyDataSetChanged();
                    }
                }
            },null );
//        }
    }
}
