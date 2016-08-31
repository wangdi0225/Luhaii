package com.king.luhai.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.king.luhai.product.GridviewList;
import com.king.luhai.R;

import java.util.List;

/**
 * Created by Administrator on 2016/8/24.
 */
public class HomepageGridviewAdapter extends BaseAdapter {
    Context mContext;
    List<GridviewList> myList;

    public HomepageGridviewAdapter(Context mContext) {
        super();
        this.mContext = mContext;

    }

    /**
     * 设置数据源
     *
     * @param lists
     */
    public void setData(List<GridviewList> lists) {
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_homepagegridview, null);
            viewHolder = new ViewHolder();
            viewHolder.onetext = (TextView) convertView.findViewById(R.id.title);
            viewHolder.twotext = (TextView) convertView.findViewById(R.id.titletwo);

            viewHolder.icon=(ImageView) convertView.findViewById(R.id.icon);
            convertView.setTag(viewHolder);//标签记住
        } else {
            viewHolder = (ViewHolder) convertView.getTag();//获得标签
        }

        // 填充数据
        if(position==0){
             viewHolder.onetext.setTextColor(Color.parseColor("#A1B3FD"));
        }else if (position==1){
            viewHolder.onetext.setTextColor(Color.parseColor("#D6AF69"));
        }else if(position==2){
            viewHolder.onetext.setTextColor(Color.parseColor("#61A286"));
        }else if (position==3){
            viewHolder.onetext.setTextColor(Color.parseColor("#2182A5"));
        }
        viewHolder.onetext.setText(myList.get(position).titleone);
        viewHolder.twotext.setText(myList.get(position).titletwo);
        viewHolder.icon.setImageResource(myList.get(position).icon);




        return convertView;
    }

    class ViewHolder {
        TextView onetext;
        TextView twotext;
        ImageView icon;
    }
}