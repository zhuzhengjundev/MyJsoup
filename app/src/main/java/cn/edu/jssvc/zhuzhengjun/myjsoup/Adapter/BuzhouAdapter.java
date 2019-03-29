package cn.edu.jssvc.zhuzhengjun.myjsoup.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cn.edu.jssvc.zhuzhengjun.myjsoup.R;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class BuzhouAdapter extends ArrayAdapter<Buzhou> {

    private int resourceId;
    private Context mContext;

    public BuzhouAdapter(Context context, int resource, List<Buzhou> objects) {
        super(context, resource, objects);
        resourceId = resource;
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Buzhou buzhou = getItem(position);
        View view;
        final ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = view.findViewById(R.id.main2_activity_listView_Item_iamge);
            viewHolder.textView_1 = view.findViewById(R.id.main2_activity_listView_Item_id);
            viewHolder.textView_2 = view.findViewById(R.id.main2_activity_listView_Item_content);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        Glide.with(mContext)// 为当前Activity 加载图片
                .load(buzhou.getImage())// 从URL 中加载
                .transition(withCrossFade())
                .into(viewHolder.imageView);// 用ImageView 显示

        viewHolder.textView_1.setText(buzhou.getId());
        viewHolder.textView_2.setText(buzhou.getContent());
        return view;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView textView_1;
        TextView textView_2;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }
}
