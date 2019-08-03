package cn.edu.jssvc.zhuzhengjun.myjsoup;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import cn.edu.jssvc.zhuzhengjun.myjsoup.Adapter.Love;
import cn.edu.jssvc.zhuzhengjun.myjsoup.Adapter.LoveAdapter;

public class Love_Activity extends AppCompatActivity {
    private String isLove;
    private LinearLayout linearLayout_back;

    private MySQLiteOpenHelper mySQLiteOpenHelper;
    private SQLiteDatabase db;

    private TextView textView_title;
    private ListView listView;
    private Love love;
    private List<Love> loveList = new ArrayList<>();
    private LoveAdapter loveAdapter;

    private List<String> linksList = new ArrayList<>();    //链接
    private List<String> imagesList = new ArrayList<>();   //图片
    private List<String> titlesList = new ArrayList<>();    //标题
    private List<String> zuozhesList = new ArrayList<>();   //作者

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love_layout);
        mySQLiteOpenHelper = new MySQLiteOpenHelper(Love_Activity.this, MySQLiteOpenHelper.DBNAME, null, 1);
        db = mySQLiteOpenHelper.getWritableDatabase();
        init();
        final Intent intent = getIntent();
        isLove = intent.getStringExtra("isLOVE");
        if (isLove.equals("收藏")) {
            textView_title.setText("收藏");
            listView = findViewById(R.id.mainLove_listView);
            loveAdapter = new LoveAdapter(Love_Activity.this,R.layout.love_listview_item_listview, loveList);
            listView.setAdapter(loveAdapter);
            loveData();
        }else {
            textView_title.setText("历史");
            listView = findViewById(R.id.mainLove_listView);
            loveAdapter = new LoveAdapter(Love_Activity.this,R.layout.love_listview_item_listview,loveList);
            listView.setAdapter(loveAdapter);
            lishiData();
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1 = new Intent(Love_Activity.this, Main2Activity.class);
                intent1.putExtra("data", linksList.get(position));
                intent1.putExtra("image", imagesList.get(position));
                intent1.putExtra("title", titlesList.get(position));
                intent1.putExtra("zuozhe", zuozhesList.get(position));
                intent1.putExtra("time", new SimpleDateFormat("MM-dd HH:mm").format(new Date(System.currentTimeMillis())));
                if (isLove.equals("收藏")) {
                    intent1.putExtra("isLishi", "yes");
                }else {
                    intent1.putExtra("isLishi", "no");
                }
                startActivity(intent1);
            }
        });
    }
    private void init() {
        textView_title = findViewById(R.id.title);
        linearLayout_back = findViewById(R.id.mainLove_back);
        linearLayout_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void loveData() {
        loveList.clear();
        linksList.clear();
        imagesList.clear();
        titlesList.clear();
        zuozhesList.clear();
        Cursor cursor = db.rawQuery("select * from love", null);
        if (cursor.moveToFirst()) {
            do {
                love = new Love(cursor.getString(cursor.getColumnIndex("image")), cursor.getString(cursor.getColumnIndex("title")), cursor.getString(cursor.getColumnIndex("zuozhe")), cursor.getString(cursor.getColumnIndex("time")));
                loveList.add(love);
                loveAdapter.notifyDataSetChanged();
                linksList.add(cursor.getString(cursor.getColumnIndex("link")));
                imagesList.add(cursor.getString(cursor.getColumnIndex("image")));
                titlesList.add(cursor.getString(cursor.getColumnIndex("title")));
                zuozhesList.add(cursor.getString(cursor.getColumnIndex("zuozhe")));
            } while (cursor.moveToNext());
        }
        Collections.reverse(loveList);
        Collections.reverse(linksList);
        Collections.reverse(imagesList);
        Collections.reverse(titlesList);
        Collections.reverse(zuozhesList);
    }

    private void lishiData() {
        loveList.clear();
        linksList.clear();
        imagesList.clear();
        titlesList.clear();
        zuozhesList.clear();
        Cursor cursor = db.rawQuery("select * from lishi", null);
        if (cursor.moveToFirst()) {
            do {
                love = new Love(cursor.getString(cursor.getColumnIndex("image")), cursor.getString(cursor.getColumnIndex("title")), cursor.getString(cursor.getColumnIndex("zuozhe")), cursor.getString(cursor.getColumnIndex("time")));
                loveList.add(love);
                loveAdapter.notifyDataSetChanged();
                linksList.add(cursor.getString(cursor.getColumnIndex("link")));
                imagesList.add(cursor.getString(cursor.getColumnIndex("image")));
                titlesList.add(cursor.getString(cursor.getColumnIndex("title")));
                zuozhesList.add(cursor.getString(cursor.getColumnIndex("zuozhe")));
            } while (cursor.moveToNext());
        }
        Collections.reverse(loveList);
        Collections.reverse(linksList);
        Collections.reverse(imagesList);
        Collections.reverse(titlesList);
        Collections.reverse(zuozhesList);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (isLove.equals("收藏")) {
            listView = findViewById(R.id.mainLove_listView);
            loveAdapter = new LoveAdapter(Love_Activity.this,R.layout.love_listview_item_listview, loveList);
            listView.setAdapter(loveAdapter);
            loveData();
        }else {
            listView = findViewById(R.id.mainLove_listView);
            loveAdapter = new LoveAdapter(Love_Activity.this,R.layout.love_listview_item_listview,loveList);
            listView.setAdapter(loveAdapter);
            lishiData();
        }
    }
}
