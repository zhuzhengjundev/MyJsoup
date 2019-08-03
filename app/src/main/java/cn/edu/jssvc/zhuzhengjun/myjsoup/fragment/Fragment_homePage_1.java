package cn.edu.jssvc.zhuzhengjun.myjsoup.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.jssvc.zhuzhengjun.myjsoup.R;
import cn.edu.jssvc.zhuzhengjun.myjsoup.fragment_homepage_1.Fragment_homePage_1_1;
import cn.edu.jssvc.zhuzhengjun.myjsoup.fragment_homepage_1.Fragment_homePage_1_2;
import cn.edu.jssvc.zhuzhengjun.myjsoup.fragment_homepage_1.Fragment_homePage_1_3;
import cn.edu.jssvc.zhuzhengjun.myjsoup.fragment_homepage_1.Fragment_homePage_1_4;
import cn.edu.jssvc.zhuzhengjun.myjsoup.fragment_homepage_1.Fragment_homePage_1_5;

public class Fragment_homePage_1 extends Fragment implements View.OnClickListener {

    private TextView textView_title_1,textView_title_2,textView_title_3,textView_title_4,textView_title_5;
    private ViewPager myViewPager;

    private List<Fragment> fragmentList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout_home_page_1, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.myFragment_1_fragmentView_textView_1:
                myViewPager.setCurrentItem(0);
                textView_title_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_click));
                textView_title_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_title_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_title_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_title_5.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                break;
            case R.id.myFragment_1_fragmentView_textView_2:
                myViewPager.setCurrentItem(1);
                textView_title_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_title_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_click));
                textView_title_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_title_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_title_5.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                break;
            case R.id.myFragment_1_fragmentView_textView_3:
                myViewPager.setCurrentItem(2);
                textView_title_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_title_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_title_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_click));
                textView_title_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_title_5.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                break;
            case R.id.myFragment_1_fragmentView_textView_4:
                myViewPager.setCurrentItem(3);
                textView_title_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_title_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_title_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_title_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_click));
                textView_title_5.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                break;
            case R.id.myFragment_1_fragmentView_textView_5:
                myViewPager.setCurrentItem(4);
                textView_title_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_title_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_title_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_title_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_title_5.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_click));
                break;
            default:
                break;
        }
    }

    private void init() {
        textView_title_1 = getActivity().findViewById(R.id.myFragment_1_fragmentView_textView_1);
        textView_title_2 = getActivity().findViewById(R.id.myFragment_1_fragmentView_textView_2);
        textView_title_3 = getActivity().findViewById(R.id.myFragment_1_fragmentView_textView_3);
        textView_title_4 = getActivity().findViewById(R.id.myFragment_1_fragmentView_textView_4);
        textView_title_5 = getActivity().findViewById(R.id.myFragment_1_fragmentView_textView_5);
        textView_title_1.setOnClickListener(this);
        textView_title_2.setOnClickListener(this);
        textView_title_3.setOnClickListener(this);
        textView_title_4.setOnClickListener(this);
        textView_title_5.setOnClickListener(this);
        fragmentList = new ArrayList<>();
        fragmentList.add(new Fragment_homePage_1_1());
        fragmentList.add(new Fragment_homePage_1_2());
        fragmentList.add(new Fragment_homePage_1_3());
        fragmentList.add(new Fragment_homePage_1_4());
        fragmentList.add(new Fragment_homePage_1_5());
        FragmentManager fragmentManager = getFragmentManager();
        myViewPager = getActivity().findViewById(R.id.myFragment_1_ViewPager);
        myViewPager.setAdapter(new Fragment_1_ViewPager(fragmentManager, fragmentList));
        myViewPager.setOnPageChangeListener(listener);
        myViewPager.setCurrentItem(0);

    }

    private ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            fragmentList.get(i);
            tilte(i);
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    private void tilte(int i) {
        if (i == 0) {
            textView_title_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_click));
            textView_title_1.setTextColor(Color.WHITE);
            textView_title_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
            textView_title_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
            textView_title_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
            textView_title_5.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
            textView_title_2.setTextColor(Color.BLACK);
            textView_title_3.setTextColor(Color.BLACK);
            textView_title_4.setTextColor(Color.BLACK);
            textView_title_5.setTextColor(Color.BLACK);
        } else if (i == 1) {
            textView_title_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
            textView_title_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_click));
            textView_title_2.setTextColor(Color.WHITE);
            textView_title_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
            textView_title_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
            textView_title_5.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
            textView_title_1.setTextColor(Color.BLACK);
            textView_title_3.setTextColor(Color.BLACK);
            textView_title_4.setTextColor(Color.BLACK);
            textView_title_5.setTextColor(Color.BLACK);
        } else if (i == 2) {
            textView_title_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
            textView_title_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
            textView_title_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_click));
            textView_title_3.setTextColor(Color.WHITE);
            textView_title_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
            textView_title_5.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
            textView_title_1.setTextColor(Color.BLACK);
            textView_title_2.setTextColor(Color.BLACK);
            textView_title_4.setTextColor(Color.BLACK);
            textView_title_5.setTextColor(Color.BLACK);
        } else if (i == 3) {
            textView_title_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
            textView_title_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
            textView_title_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
            textView_title_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_click));
            textView_title_4.setTextColor(Color.WHITE);
            textView_title_5.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
            textView_title_1.setTextColor(Color.BLACK);
            textView_title_2.setTextColor(Color.BLACK);
            textView_title_3.setTextColor(Color.BLACK);
            textView_title_5.setTextColor(Color.BLACK);
        } else if (i == 4) {
            textView_title_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
            textView_title_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
            textView_title_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
            textView_title_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
            textView_title_5.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_click));
            textView_title_1.setTextColor(Color.BLACK);
            textView_title_2.setTextColor(Color.BLACK);
            textView_title_3.setTextColor(Color.BLACK);
            textView_title_4.setTextColor(Color.BLACK);
            textView_title_5.setTextColor(Color.WHITE);
        }
    }
}
