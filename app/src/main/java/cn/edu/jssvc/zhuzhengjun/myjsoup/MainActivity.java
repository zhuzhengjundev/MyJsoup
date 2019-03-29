package cn.edu.jssvc.zhuzhengjun.myjsoup;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;
import java.util.List;

import cn.edu.jssvc.zhuzhengjun.myjsoup.fragment.Fragment_More_2;
import cn.edu.jssvc.zhuzhengjun.myjsoup.fragment.Fragment_My_3;
import cn.edu.jssvc.zhuzhengjun.myjsoup.fragment.Fragment_homePage_1;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationBar bottomNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        bottomNavigationBar = findViewById(R.id.myNavigation_bar);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.shouye, "首页"))
                .addItem(new BottomNavigationItem(R.drawable.gengduo, "更多"))
                .addItem(new BottomNavigationItem(R.drawable.wode, "我的"))
                .initialise();//所有的设置需在调用该方法前完成
        bottomNavigationBar
                .setActiveColor("#0000ff")
                .setInActiveColor("#FFFFFF")
                .setBarBackgroundColor("#ECECEC");
        bottomNavigationBar.setTabSelectedListener(tabSelectedListener);
        fragmentList.add(new Fragment_homePage_1());
        fragmentList.add(new Fragment_More_2());
        fragmentList.add(new Fragment_My_3());
        loadFragment(0);
    }

    private BottomNavigationBar.OnTabSelectedListener tabSelectedListener = new BottomNavigationBar.OnTabSelectedListener() {
        @Override
        public void onTabSelected(int position) {        //未选中 -> 选中
            if (position == 0) {
                loadFragment(0);
            } else if (position == 1) {
                loadFragment(1);
            }else if (position == 2){
                loadFragment(2);
            }
        }
        @Override
        public void onTabUnselected(int position) {}
        @Override
        public void onTabReselected(int position) {}
    };

    private Fragment mFrag;
    private List<Fragment> fragmentList = new ArrayList<>();
    private void loadFragment(int position) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = fragmentList.get(position);
        if(mFrag != null) {
            transaction.hide(mFrag);
        }
        if(!fragment.isAdded()) {
            transaction.add(R.id.myMainFragment, fragment);
        } else {
            transaction.show(fragment);
        }
        mFrag = fragment;
        transaction.commit();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("提示：");
            builder.setMessage("您确定退出？");

            //设置确定按钮
            builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            //设置取消按钮
            builder.setPositiveButton("容我再想想",null);
            //显示提示框
            builder.show();
        }
        return super.onKeyDown(keyCode, event);
    }
}