package com.king.luhai.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.king.luhai.product.SysUtils;
import com.king.luhai.R;


import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/30.
 */
public class FriendGridViewAdapter extends BaseAdapter {
    Activity context;
    ArrayList<String> list;
    public Bitmap bitmaps[];
    private FinalBitmap finalImageLoader;
    private int wh;

    public FriendGridViewAdapter(Activity context,ArrayList<String> data) {
        this.context=context;
        this.wh=(SysUtils.getScreenWidth(context)-SysUtils.Dp2Px(context, 99))/3;
        this.list=data;
        this.finalImageLoader=FinalBitmap.create(context);
        this.finalImageLoader.configLoadingImage(R.mipmap.ic_launcher);//图片加载完成前显示的图片
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int arg0) {
        return list.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }


    @Override
    public View getView(final int position, View view, ViewGroup arg2) {
        Holder holder;
        if (view==null) {
            view= LayoutInflater.from(context).inflate(R.layout.it_gridview, null);
            holder=new Holder();
            holder.imageView=(ImageView) view.findViewById(R.id.dongtai_icon);
            view.setTag(holder);
        }else {
            holder= (Holder) view.getTag();
        }
        finalImageLoader.display(holder.imageView, list.get(position));
        AbsListView.LayoutParams param = new AbsListView.LayoutParams(wh,wh);
        view.setLayoutParams(param);
        return view;
    }

    class Holder{
        ImageView imageView;
    }


}