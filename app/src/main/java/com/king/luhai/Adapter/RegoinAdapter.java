package com.king.luhai.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.king.luhai.Product.GridviewList;
import com.king.luhai.Product.RegoinList;
import com.king.luhai.R;


import java.util.List;

/**
 * Created by Administrator on 2016/8/29.
 */
public class RegoinAdapter extends BaseAdapter {

    Context mContext;
    List<RegoinList> myList;

    public RegoinAdapter(Context mContext) {
        super();
        this.mContext = mContext;

    }

    /**
     * 设置数据源
     *
     * @param lists
     */
    public void setData(List<RegoinList> lists) {
        this.myList = lists;
        notifyDataSetInvalidated();
    }

    /**
     * 获取总数
     */
    @Override
    public int getCount() {
        return myList == null ? 0 : myList.size();
    }

    @Override
    public Object getItem(int position) {
        if (myList != null && position < myList.size()) {
            return myList.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(final int position, View convertView, ViewGroup arg2) {

        ViewHolder viewHolder = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.it_goin, null);
            viewHolder = new ViewHolder();
            viewHolder.onetext = (TextView) convertView.findViewById(R.id.name);

            convertView.setTag(viewHolder);//标签记住
        } else {
            viewHolder = (ViewHolder) convertView.getTag();//获得标签
        }
        viewHolder.onetext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i= 0 ;i<myList.size();i++){
                    myList.get(i).ischeck=false;
                }
                myList.get(position).ischeck=true;
                notifyDataSetChanged();
            }
        });
        // 填充数据


        if(myList.get(position).ischeck) {
            viewHolder.onetext.setBackgroundResource(R.color.huise);



        }else {
            viewHolder.onetext.setBackgroundResource(R.color.white);
        }
        viewHolder.onetext.setText(myList.get(position).name);





        return convertView;
    }

    class ViewHolder {
        TextView onetext;

    }
}
