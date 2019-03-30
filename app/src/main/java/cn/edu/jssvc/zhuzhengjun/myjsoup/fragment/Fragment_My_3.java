package cn.edu.jssvc.zhuzhengjun.myjsoup.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leon.lib.settingview.LSettingItem;

import cn.edu.jssvc.zhuzhengjun.myjsoup.Love_Activity;
import cn.edu.jssvc.zhuzhengjun.myjsoup.R;

public class Fragment_My_3 extends Fragment {

    private LSettingItem item_love,item_lishi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout_my_3, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init() {
        item_love = getActivity().findViewById(R.id.item_love);
        item_lishi = getActivity().findViewById(R.id.item_lishi);
        item_love.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click(boolean isChecked) {
                Intent intent = new Intent(getContext(), Love_Activity.class);
                intent.putExtra("isLOVE", "收藏");
                startActivity(intent);
            }
        });
        item_lishi.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click(boolean isChecked) {
                Intent intent = new Intent(getContext(), Love_Activity.class);
                intent.putExtra("isLOVE", "历史");
                startActivity(intent);
            }
        });
    }
}
