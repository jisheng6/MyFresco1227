package com.bwei.myfresco1227.adpater;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwei.myfresco1227.R;
import com.bwei.myfresco1227.bean.Bean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * 此类的作用：
 *
 * @author: forever
 * @date: 2017/12/27 9:19
 */
public class ListAdapter extends BaseAdapter{
    Context context;
    List<Bean.DataBean> listImage;
    public ListAdapter(Context context, List<Bean.DataBean> listImage) {
        this.listImage = listImage;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listImage.size();
    }

    @Override
    public Object getItem(int i) {
        return listImage.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            view = View.inflate(context, R.layout.list_item,null);

            holder = new ViewHolder();

            holder.imageView = view.findViewById(R.id.list_image);
            holder.textView01 = view.findViewById(R.id.list_text);
            holder.textView02 = view.findViewById(R.id.list_time);

            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        String[] split = listImage.get(i).getImages().split("\\|");

        Uri uri= Uri.parse(split[0]);
        // GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder();
        //  RoundingParams params = RoundingParams.asCircle();

        holder.imageView.setImageURI(uri);
        holder.textView01.setText(listImage.get(i).getTitle());
        holder.textView02.setText(listImage.get(i).getCreatetime());
        return view;
    }

    class ViewHolder{
        SimpleDraweeView imageView;
        TextView textView01;
        TextView textView02;
    }
}

