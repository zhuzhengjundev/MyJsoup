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

public class Meishi2Adapter extends ArrayAdapter<Meishi2> {

    private int resourceId;
    private Context mContext;

    public Meishi2Adapter(Context context, int resource, List<Meishi2> objects) {
        super(context, resource, objects);
        resourceId = resource;
        mContext = context;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        Meishi2 meishi2 = getItem(position);
        View view;
        final ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = view.findViewById(R.id.fragment_2_gridView_iamge);
            viewHolder.textView_1 = view.findViewById(R.id.fragment_2_gridView_caiming);
            viewHolder.textView_2 = view.findViewById(R.id.fragment_2_gridView_name);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        Glide.with(mContext)// 为当前Activity 加载图片
                .load(meishi2.getImg())// 从URL 中加载
                .transition(withCrossFade())
                .into(viewHolder.imageView);// 用ImageView 显示

        viewHolder.textView_1.setText(meishi2.getCaiming());
        viewHolder.textView_2.setText(meishi2.getName());
        return view;
    }


    private class ViewHolder{
        ImageView imageView;
        TextView textView_1;
        TextView textView_2;
    }
}
