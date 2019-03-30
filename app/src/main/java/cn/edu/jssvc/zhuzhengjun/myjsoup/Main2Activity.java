package cn.edu.jssvc.zhuzhengjun.myjsoup;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

import cn.edu.jssvc.zhuzhengjun.myjsoup.Adapter.Buzhou;
import cn.edu.jssvc.zhuzhengjun.myjsoup.Adapter.BuzhouAdapter;
import cn.edu.jssvc.zhuzhengjun.myjsoup.function.HttpRequest;
import cn.edu.jssvc.zhuzhengjun.myjsoup.function.MyApplication;
import cn.edu.jssvc.zhuzhengjun.myjsoup.function.MyListView;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class Main2Activity extends AppCompatActivity implements View.OnTouchListener {

    private MySQLiteOpenHelper mySQLiteOpenHelper;
    private SQLiteDatabase db;

    private LinearLayout linearLayout_back;
    private ImageView imageView_love;          //收藏

    private SwipeRefreshLayout mySwipeRefreshLayout;

    private LinearLayout linearLayout_huadong;

    private String intent_link;                 //接收的链接
    private String intent_image;                //接收的图片
    private String intent_title;                //接收的标题
    private String intent_zuozhe;               //接收的作者
    private String intent_time;                 //接收的时间

    private TextView textView_title,   //标题
            textView_name,              //网名
            textView_main_text,        //正文
            textView_buzhou_title,     //步骤名字
            textView_cailiao_title,    //材料标题
            textView_cailiao_content;  //材料内容

    private ImageView imageView_touxiang,     //头像
            imageView_meishiImage;    //美食的图片

    private MyListView myListView;
    private Buzhou buzhou;
    private List<Buzhou> buzhouList = new ArrayList<>();
    private BuzhouAdapter buzhouAdapter;

    private String renwu_links = "";     //人物主页链接

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mySQLiteOpenHelper = new MySQLiteOpenHelper(Main2Activity.this, MySQLiteOpenHelper.DBNAME, null, 1);
        db = mySQLiteOpenHelper.getWritableDatabase();
        Intent intent = getIntent();
        intent_link = intent.getStringExtra("data");
        intent_image = intent.getStringExtra("image");
        intent_title = intent.getStringExtra("title");
        intent_zuozhe = intent.getStringExtra("zuozhe");
        intent_time = intent.getStringExtra("time");
        Log.d("收到链接", intent_link + "     收到图片" + intent_image + "     收到标题：" + intent_title + "    收到作者：" + intent_zuozhe + "    收到时间：" + intent_time);
        init();
        getData();
        addDB_1();
        SharedPreferences sharedPreferences = getSharedPreferences("isFirst",MODE_PRIVATE);
        if (!sharedPreferences.getBoolean("key", false)) {
            Toast.makeText(Main2Activity.this,"点击右上角可查看作者往期作品",Toast.LENGTH_SHORT).show();
            SharedPreferences.Editor editor = getSharedPreferences("isFirst",MODE_PRIVATE).edit();
            editor.putBoolean("key", true);
            editor.apply();
        }
    }

    private void addDB_1() {       //保存到历史记录的sqlite
        ContentValues values = new ContentValues();
        values.put("link", intent_link);
        values.put("image", intent_image);
        values.put("title", intent_title);
        values.put("zuozhe", intent_zuozhe);
        values.put("time", intent_time);
        db.insert("lishi", null, values);
    }

    private void addDB_2(Boolean is,String time) {
        if (is) {
            ContentValues values = new ContentValues();
            values.put("link", intent_link);
            values.put("image", intent_image);
            values.put("title", intent_title);
            values.put("zuozhe", intent_zuozhe);
            values.put("time", time);
            db.insert("love", null, values);
            Log.d("收藏", "成功");
        }else {
            db.delete("love", "title = ?", new String[]{intent_title});
            Log.d("收藏", "失败");
        }
    }

    private void getData() {
        HttpRequest.get2(intent_link, new Response.Listener<String>() {
            @Override
            public void onResponse(String str) {
                mySwipeRefreshLayout.setRefreshing(false);
                Document document = Jsoup.parse(str);
                Elements links = document.select("div.space_left");
                Log.d("context_标题", links.select("div.userTop h1.recipe_De_title a").text());
                Log.d("context_头像", links.select("div.userTop a img").attr("src"));
                Log.d("context_网名", links.select("div.userTop a span").text());
                Log.d("context_美食图片", links.select("div.space_box_home div.recipDetail div.recipe_De_imgBox a.J_photo img").attr("src"));
                Log.d("context_美食首段", links.select("div.space_box_home div.recipDetail blockquote.block_txt div#block_txt1").text());
                Log.d("context_美食材料标题", links.select("div.space_box_home div.recipDetail div.mo h3").text().substring(0, 4));
                Log.d("context_美食步骤标题", links.select("div.space_box_home div.recipDetail div.mo h3").text().substring(4).replace("小窍门", ""));
                textView_buzhou_title.setText(links.select("div.space_box_home div.recipDetail div.mo h3").text().substring(4).replace("小窍门", ""));
                Elements links_2 = links.select("div.space_box_home div.recipDetail div.recipeStep ul li");       //获取到  ul li 项
                for (Element link : links_2) {
                    Log.d("context_ListView_图片", link.select("div.recipeStep_img img").attr("src"));
                    Log.d("context_ListView_序号", link.select("div.recipeStep_word div.recipeStep_num").text());
                    Log.d("context_ListView_内容", link.select("div.recipeStep_word").text().substring(1));
                    buzhou = new Buzhou(link.select("div.recipeStep_img img").attr("src"), link.select("div.recipeStep_word div.recipeStep_num").text(), link.select("div.recipeStep_word").text().substring(1));
                    buzhouList.add(buzhou);
                    buzhouAdapter.notifyDataSetChanged();
                }
                textView_title.setText(links.select("div.userTop h1.recipe_De_title a").text());
                RequestOptions circleCrop = new RequestOptions().circleCrop();
                Glide.with(Main2Activity.this)// 为当前Activity 加载图片
                        .load(links.select("div.userTop a img").attr("src"))// 从URL 中加载
                        .apply(circleCrop)// 应用请求选项
                        .transition(withCrossFade())
                        .into(imageView_touxiang);// 用ImageView 显示
                textView_name.setText(links.select("div.userTop a span").text());
                Glide.with(Main2Activity.this)// 为当前Activity 加载图片
                        .load(links.select("div.space_box_home div.recipDetail div.recipe_De_imgBox a.J_photo img").attr("src"))// 从URL 中加载
                        .transition(withCrossFade())
                        .into(imageView_meishiImage);// 用ImageView 显示
                textView_main_text.setText(links.select("div.space_box_home div.recipDetail blockquote.block_txt div#block_txt1").text());
                Elements links_1 = links.select("div.space_box_home div.recipDetail fieldset.particulars");
                StringBuilder builder = new StringBuilder();
                for (Element link : links_1) {
                    Log.d("context_美食材料内容", link.text().substring(0,2) + "：" + link.text().substring(2));
                    builder.append("     " + link.text().substring(0,2) + "：" + link.text().substring(2) + "\n\n");
                }
                textView_cailiao_title.setText(links.select("div.space_box_home div.recipDetail div.mo h3").text().substring(0, 4));
                textView_cailiao_content.setText(builder);
                Log.d("context_ListView_人物资料链接", links.select("div.userTop a").get(1).attr("href"));
                renwu_links = links.select("div.userTop a").get(1).attr("href");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(MyApplication.mContext.getApplicationContext(),"网络连接超时",Toast.LENGTH_SHORT).show();
                mySwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private Boolean love = false;
    private void init() {
        linearLayout_back = findViewById(R.id.main2_back);
        linearLayout_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        imageView_love = findViewById(R.id.main2_love_imageView);
        imageView_love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (love == false){
                    imageView_love.setImageResource(R.drawable.shoucang_ic_click);
                    love = true;
                    addDB_2(true,new SimpleDateFormat("MM-dd HH:mm").format(new Date(System.currentTimeMillis())));
                }else{
                    imageView_love.setImageResource(R.drawable.shoucang_ic);
                    love = false;
                    addDB_2(false,"");
                }
            }
        });
        Cursor cursor = db.rawQuery("select * from love", null);
        if (cursor.moveToFirst()) {
            do {
                if (intent_title.equals(cursor.getString(cursor.getColumnIndex("title")))) {
                    love = true;
                    imageView_love.setImageResource(R.drawable.shoucang_ic_click);
                }
            } while (cursor.moveToNext());
        }
        mySwipeRefreshLayout = findViewById(R.id.main2_activitySwipeRefreshLayout);
        mySwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        mySwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });
        mySwipeRefreshLayout.setRefreshing(true);
        linearLayout_huadong = findViewById(R.id.main2_activityLinearLayout);
        textView_title = findViewById(R.id.main2_activity_title);
        textView_name = findViewById(R.id.main2_activity_name);
        textView_main_text = findViewById(R.id.main2_activity_meishi_text_main);
        imageView_touxiang = findViewById(R.id.main2_activity_touxiang);
        imageView_touxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!renwu_links.equals("")) {
                    Log.d("链接传送",renwu_links);
                    Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                    intent.putExtra("data2", renwu_links);
                    startActivity(intent);
                }
            }
        });
        imageView_meishiImage = findViewById(R.id.main2_activity_meishi_image_main);
        linearLayout_huadong.setOnTouchListener(this);
        textView_cailiao_title = findViewById(R.id.main2_activity_meishi_cailiao_title);
        textView_cailiao_content = findViewById(R.id.main2_activity_meishi_cailiao_content);
        textView_buzhou_title = findViewById(R.id.main2_activity_meishi_buzhou_title);
        myListView = findViewById(R.id.main2_activity_MyListView);
        buzhouAdapter = new BuzhouAdapter(Main2Activity.this, R.layout.main2_activity_listview_item, buzhouList);
        myListView.setAdapter(buzhouAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                buzhouAdapter.isEnabled(position);
            }
        });
    }

    private float d_X,m_X;
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                d_X = event.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                m_X = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                if (d_X - m_X < 50 && d_X < 100 && m_X > 0) {
                    finish();
                    d_X = 0;
                    m_X = 0;
                }
                break;
            default:
                break;
        }
        return true;
    }
}
