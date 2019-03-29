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

public class Meishi3Adapter extends ArrayAdapter<Meishi3> {

    private int resourceId;
    private Context mContext;

    public Meishi3Adapter(Context context, int resource, List<Meishi3> objects) {
        super(context, resource, objects);
        resourceId = resource;
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Meishi3 meishi3 = getItem(position);
        View view;
        final ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = view.findViewById(R.id.main3_activity_listView_Item_iamge);
            viewHolder.textView_1 = view.findViewById(R.id.main3_activity_listView_Item_caiming);
            viewHolder.textView_2 = view.findViewById(R.id.main3_activity_listView_Item_time);
            viewHolder.textView_3 = view.findViewById(R.id.main3_activity_listView_Item_peiliao);
            viewHolder.textView_4 = view.findViewById(R.id.main3_activity_listView_Item_yuedu);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        Glide.with(mContext)// 为当前Activity 加载图片
                .load(meishi3.getImage())// 从URL 中加载
                .transition(withCrossFade())
                .into(viewHolder.imageView);// 用ImageView 显示

        viewHolder.textView_1.setText(meishi3.getName());
        viewHolder.textView_2.setText(meishi3.getTime());
        viewHolder.textView_3.setText(meishi3.getPeiliao());
        viewHolder.textView_4.setText(meishi3.getLiulan());
        return view;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView textView_1;
        TextView textView_2;
        TextView textView_3;
        TextView textView_4;
    }

}
