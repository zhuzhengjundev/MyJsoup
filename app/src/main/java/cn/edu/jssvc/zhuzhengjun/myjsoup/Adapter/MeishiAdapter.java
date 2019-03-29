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

public class MeishiAdapter extends ArrayAdapter<Meishi> {

    private int resourceId;
    private List<Meishi> meishiListId;
    private Context mContext;

    public MeishiAdapter(Context context, int resource, List<Meishi> meishiList) {
        super(context, resource, meishiList);
        resourceId = resource;
        meishiListId = meishiList;
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Meishi meishi = getItem(position);
        View view;
        final ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = view.findViewById(R.id.fragment_1_listView_iamge);
            viewHolder.textView_1 = view.findViewById(R.id.fragment_1_listView_title);
            viewHolder.textView_2 = view.findViewById(R.id.fragment_1_listView_zuozhe);
            viewHolder.textView_3 = view.findViewById(R.id.fragment_1_listView_yuanliao);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        Glide.with(mContext)// 为当前Activity 加载图片
                .load(meishi.getImage())// 从URL 中加载
                .transition(withCrossFade())
                .into(viewHolder.imageView);// 用ImageView 显示

        viewHolder.textView_1.setText(meishi.getTitle());
        viewHolder.textView_2.setText(meishi.getAuthor());
        viewHolder.textView_3.setText(meishi.getMaterial());

        return view;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView textView_1;
        TextView textView_2;
        TextView textView_3;
    }

    public int getCount() {
        return meishiListId.size();
    }
}
