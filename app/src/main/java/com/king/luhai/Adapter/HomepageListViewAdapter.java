package com.king.luhai.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.king.luhai.Product.HomepageListview;
import com.king.luhai.R;

import java.util.List;

/**
 * Created by Administrator on 2016/8/25.
 */
public class HomepageListViewAdapter extends BaseAdapter {
    Context mContext;
    List<HomepageListview> myList;

    public HomepageListViewAdapter(Context mContext) {
        super();
        this.mContext = mContext;

    }

    /**
     * 设置数据源
     *
     * @param lists
     */
    public void setData(List<HomepageListview> lists) {
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_homepagelistview, null);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.time = (TextView) convertView.findViewById(R.id.time);
            viewHolder.content = (TextView) convertView.findViewById(R.id.content);
            viewHolder.daqu = (TextView) convertView.findViewById(R.id.daqu);
            viewHolder.level = (TextView) convertView.findViewById(R.id.level);
            viewHolder.pinglun = (TextView) convertView.findViewById(R.id.pinglun);
            viewHolder.dianzhan = (TextView) convertView.findViewById(R.id.dianzhan);
            viewHolder.jiaru = (TextView) convertView.findViewById(R.id.jiaren);

            viewHolder.icon = (ImageView) convertView.findViewById(R.id.icon);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.image);
            viewHolder.join = (ImageView) convertView.findViewById(R.id.join);
            convertView.setTag(viewHolder);//标签记住
        } else {
            viewHolder = (ViewHolder) convertView.getTag();//获得标签
        }
        // 填充数据
        viewHolder.name.setText(myList.get(position).name);
        viewHolder.time.setText(myList.get(position).time);
        viewHolder.daqu.setText(myList.get(position).daqu);
        viewHolder.level.setText(myList.get(position).level);
        viewHolder.content.setText(myList.get(position).content);
        viewHolder.jiaru.setText(myList.get(position).jiaru);
        viewHolder.pinglun.setText(myList.get(position).pinglun);
        viewHolder.dianzhan.setText(myList.get(position).dianzhan);

        viewHolder.icon.setImageResource(myList.get(position).icon);
        viewHolder.image.setImageResource(myList.get(position).image);


        return convertView;
    }

    class ViewHolder {

        ImageView image;
        TextView content;
        TextView daqu;
        TextView level;
        TextView jiaru;
        TextView pinglun;
        TextView dianzhan;
        TextView name;
        TextView time;
        ImageView icon;
        ImageView join;
    }
}