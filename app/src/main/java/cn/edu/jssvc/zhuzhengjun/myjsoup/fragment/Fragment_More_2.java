package cn.edu.jssvc.zhuzhengjun.myjsoup.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.jssvc.zhuzhengjun.myjsoup.R;
import cn.edu.jssvc.zhuzhengjun.myjsoup.fragment_more_2.Fragment_more_2_1;
import cn.edu.jssvc.zhuzhengjun.myjsoup.fragment_more_2.Fragment_more_2_10;
import cn.edu.jssvc.zhuzhengjun.myjsoup.fragment_more_2.Fragment_more_2_2;
import cn.edu.jssvc.zhuzhengjun.myjsoup.fragment_more_2.Fragment_more_2_3;
import cn.edu.jssvc.zhuzhengjun.myjsoup.fragment_more_2.Fragment_more_2_4;
import cn.edu.jssvc.zhuzhengjun.myjsoup.fragment_more_2.Fragment_more_2_5;
import cn.edu.jssvc.zhuzhengjun.myjsoup.fragment_more_2.Fragment_more_2_6;
import cn.edu.jssvc.zhuzhengjun.myjsoup.fragment_more_2.Fragment_more_2_7;
import cn.edu.jssvc.zhuzhengjun.myjsoup.fragment_more_2.Fragment_more_2_8;
import cn.edu.jssvc.zhuzhengjun.myjsoup.fragment_more_2.Fragment_more_2_9;

public class Fragment_More_2 extends Fragment implements View.OnClickListener {

    private TextView textView_1,textView_2,textView_3,textView_4,textView_5,
                    textView_6,textView_7,textView_8,textView_9,textView_10;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout_more_2, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.myFragment_2_fragmentView_textView_1:
                loadFragment(0);
                textView_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_click));
                textView_1.setTextColor(Color.WHITE);
                textView_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_5.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_6.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_7.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_8.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_9.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_10.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_2.setTextColor(Color.BLACK);
                textView_3.setTextColor(Color.BLACK);
                textView_4.setTextColor(Color.BLACK);
                textView_5.setTextColor(Color.BLACK);
                textView_6.setTextColor(Color.BLACK);
                textView_7.setTextColor(Color.BLACK);
                textView_8.setTextColor(Color.BLACK);
                textView_9.setTextColor(Color.BLACK);
                textView_10.setTextColor(Color.BLACK);
                break;
            case R.id.myFragment_2_fragmentView_textView_2:
                loadFragment(1);
                textView_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_click));
                textView_2.setTextColor(Color.WHITE);
                textView_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_5.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_6.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_7.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_8.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_9.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_10.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_1.setTextColor(Color.BLACK);
                textView_3.setTextColor(Color.BLACK);
                textView_4.setTextColor(Color.BLACK);
                textView_5.setTextColor(Color.BLACK);
                textView_6.setTextColor(Color.BLACK);
                textView_7.setTextColor(Color.BLACK);
                textView_8.setTextColor(Color.BLACK);
                textView_9.setTextColor(Color.BLACK);
                textView_10.setTextColor(Color.BLACK);
                break;
            case R.id.myFragment_2_fragmentView_textView_3:
                loadFragment(2);
                textView_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_click));
                textView_3.setTextColor(Color.WHITE);
                textView_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_5.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_6.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_7.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_8.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_9.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_10.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_1.setTextColor(Color.BLACK);
                textView_2.setTextColor(Color.BLACK);
                textView_4.setTextColor(Color.BLACK);
                textView_5.setTextColor(Color.BLACK);
                textView_6.setTextColor(Color.BLACK);
                textView_7.setTextColor(Color.BLACK);
                textView_8.setTextColor(Color.BLACK);
                textView_9.setTextColor(Color.BLACK);
                textView_10.setTextColor(Color.BLACK);
                break;
            case R.id.myFragment_2_fragmentView_textView_4:
                loadFragment(3);
                textView_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_click));
                textView_4.setTextColor(Color.WHITE);
                textView_5.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_6.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_7.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_8.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_9.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_10.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_1.setTextColor(Color.BLACK);
                textView_2.setTextColor(Color.BLACK);
                textView_3.setTextColor(Color.BLACK);
                textView_5.setTextColor(Color.BLACK);
                textView_6.setTextColor(Color.BLACK);
                textView_7.setTextColor(Color.BLACK);
                textView_8.setTextColor(Color.BLACK);
                textView_9.setTextColor(Color.BLACK);
                textView_10.setTextColor(Color.BLACK);
                break;
            case R.id.myFragment_2_fragmentView_textView_5:
                loadFragment(4);
                textView_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_5.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_click));
                textView_5.setTextColor(Color.WHITE);
                textView_6.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_7.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_8.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_9.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_10.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_1.setTextColor(Color.BLACK);
                textView_2.setTextColor(Color.BLACK);
                textView_3.setTextColor(Color.BLACK);
                textView_4.setTextColor(Color.BLACK);
                textView_6.setTextColor(Color.BLACK);
                textView_7.setTextColor(Color.BLACK);
                textView_8.setTextColor(Color.BLACK);
                textView_9.setTextColor(Color.BLACK);
                textView_10.setTextColor(Color.BLACK);
                break;
            case R.id.myFragment_2_fragmentView_textView_6:
                loadFragment(5);
                textView_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_5.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_6.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_click));
                textView_6.setTextColor(Color.WHITE);
                textView_7.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_8.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_9.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_10.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_1.setTextColor(Color.BLACK);
                textView_2.setTextColor(Color.BLACK);
                textView_3.setTextColor(Color.BLACK);
                textView_4.setTextColor(Color.BLACK);
                textView_5.setTextColor(Color.BLACK);
                textView_7.setTextColor(Color.BLACK);
                textView_8.setTextColor(Color.BLACK);
                textView_9.setTextColor(Color.BLACK);
                textView_10.setTextColor(Color.BLACK);
                break;
            case R.id.myFragment_2_fragmentView_textView_7:
                loadFragment(6);
                textView_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_5.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_6.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_7.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_click));
                textView_7.setTextColor(Color.WHITE);
                textView_8.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_9.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_10.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_1.setTextColor(Color.BLACK);
                textView_2.setTextColor(Color.BLACK);
                textView_3.setTextColor(Color.BLACK);
                textView_4.setTextColor(Color.BLACK);
                textView_5.setTextColor(Color.BLACK);
                textView_6.setTextColor(Color.BLACK);
                textView_8.setTextColor(Color.BLACK);
                textView_9.setTextColor(Color.BLACK);
                textView_10.setTextColor(Color.BLACK);
                break;
            case R.id.myFragment_2_fragmentView_textView_8:
                loadFragment(7);
                textView_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_5.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_6.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_7.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_8.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_click));
                textView_8.setTextColor(Color.WHITE);
                textView_9.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_10.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_1.setTextColor(Color.BLACK);
                textView_2.setTextColor(Color.BLACK);
                textView_3.setTextColor(Color.BLACK);
                textView_4.setTextColor(Color.BLACK);
                textView_5.setTextColor(Color.BLACK);
                textView_6.setTextColor(Color.BLACK);
                textView_7.setTextColor(Color.BLACK);
                textView_9.setTextColor(Color.BLACK);
                textView_10.setTextColor(Color.BLACK);
                break;
            case R.id.myFragment_2_fragmentView_textView_9:
                loadFragment(8);
                textView_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_5.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_6.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_7.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_8.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_9.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_click));
                textView_9.setTextColor(Color.WHITE);
                textView_10.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_1.setTextColor(Color.BLACK);
                textView_2.setTextColor(Color.BLACK);
                textView_3.setTextColor(Color.BLACK);
                textView_4.setTextColor(Color.BLACK);
                textView_5.setTextColor(Color.BLACK);
                textView_6.setTextColor(Color.BLACK);
                textView_7.setTextColor(Color.BLACK);
                textView_8.setTextColor(Color.BLACK);
                textView_10.setTextColor(Color.BLACK);
                break;
            case R.id.myFragment_2_fragmentView_textView_10:
                loadFragment(9);
                textView_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_5.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_6.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_7.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_8.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_9.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                textView_10.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_click));
                textView_1.setTextColor(Color.BLACK);
                textView_2.setTextColor(Color.BLACK);
                textView_3.setTextColor(Color.BLACK);
                textView_4.setTextColor(Color.BLACK);
                textView_5.setTextColor(Color.BLACK);
                textView_6.setTextColor(Color.BLACK);
                textView_7.setTextColor(Color.BLACK);
                textView_8.setTextColor(Color.BLACK);
                textView_9.setTextColor(Color.BLACK);
                textView_10.setTextColor(Color.WHITE);
                break;
            default:
                break;
        }
    }

    private void init() {
        textView_1 = getActivity().findViewById(R.id.myFragment_2_fragmentView_textView_1);
        textView_2 = getActivity().findViewById(R.id.myFragment_2_fragmentView_textView_2);
        textView_3 = getActivity().findViewById(R.id.myFragment_2_fragmentView_textView_3);
        textView_4 = getActivity().findViewById(R.id.myFragment_2_fragmentView_textView_4);
        textView_5 = getActivity().findViewById(R.id.myFragment_2_fragmentView_textView_5);
        textView_6 = getActivity().findViewById(R.id.myFragment_2_fragmentView_textView_6);
        textView_7 = getActivity().findViewById(R.id.myFragment_2_fragmentView_textView_7);
        textView_8 = getActivity().findViewById(R.id.myFragment_2_fragmentView_textView_8);
        textView_9 = getActivity().findViewById(R.id.myFragment_2_fragmentView_textView_9);
        textView_10 = getActivity().findViewById(R.id.myFragment_2_fragmentView_textView_10);
        textView_1.setOnClickListener(this);
        textView_2.setOnClickListener(this);
        textView_3.setOnClickListener(this);
        textView_4.setOnClickListener(this);
        textView_5.setOnClickListener(this);
        textView_6.setOnClickListener(this);
        textView_7.setOnClickListener(this);
        textView_8.setOnClickListener(this);
        textView_9.setOnClickListener(this);
        textView_10.setOnClickListener(this);
        fragmentList.add(new Fragment_more_2_1());
        fragmentList.add(new Fragment_more_2_2());
        fragmentList.add(new Fragment_more_2_3());
        fragmentList.add(new Fragment_more_2_4());
        fragmentList.add(new Fragment_more_2_5());
        fragmentList.add(new Fragment_more_2_6());
        fragmentList.add(new Fragment_more_2_7());
        fragmentList.add(new Fragment_more_2_8());
        fragmentList.add(new Fragment_more_2_9());
        fragmentList.add(new Fragment_more_2_10());
        loadFragment(0);
    }

    private Fragment mFrag;
    private List<Fragment> fragmentList = new ArrayList<>();
    private void loadFragment(int position) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = fragmentList.get(position);
        if(mFrag != null) {
            transaction.hide(mFrag);
        }
        if(!fragment.isAdded()) {
            transaction.add(R.id.myFragment_2_fragmentView, fragment);
        } else {
            transaction.show(fragment);
        }
        mFrag = fragment;
        transaction.commit();
    }


}
