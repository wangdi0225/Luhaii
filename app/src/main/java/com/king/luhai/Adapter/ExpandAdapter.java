package com.king.luhai.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.king.luhai.R;
import com.king.luhai.product.MyExpanchildlist;
import com.king.luhai.product.MyExpandlist;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/5.
 */
public class ExpandAdapter extends BaseExpandableListAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private List<MyExpandlist> myList;
    private List<List<MyExpanchildlist>> childlist;
    public ExpandAdapter(Context mContext) {
        super();
        this.mContext=mContext;
        inflater = ((Activity)mContext).getLayoutInflater();
    }
    public void setData(List<MyExpandlist> list, List<List<MyExpanchildlist>> chlidlist) {
        this.myList=list;
        this.childlist=chlidlist;
        notifyDataSetInvalidated();
    }
    public int getGroupCount() {
        // TODO Auto-generated method stub
        return myList.size();
    }
    public int getChildrenCount(int groupPosition) {
        // TODO Auto-generated method stub
        return childlist.get(groupPosition).size();
    }
    public Object getGroup(int groupPosition) {
        // TODO Auto-generated method stub
        return myList.get(groupPosition);
    }
    public Object getChild(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return childlist.get(groupPosition).get(childPosition);
    }

    public long getGroupId(int groupPosition) {
        // TODO Auto-generated method stub
        return groupPosition;
    }

    public long getChildId(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return childPosition;
    }

    public boolean hasStableIds() {
        // TODO Auto-generated method stub
        return false;
    }


    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        GroupViewHolder holder=null;

        if (convertView == null) {
            holder=new GroupViewHolder();
            convertView = inflater.inflate(R.layout.item_messagefather, null);
            holder.youxidaqu=(TextView)convertView.findViewById(R.id.youxidaqu);
            holder.youxihaoyou=(TextView)convertView.findViewById(R.id.youxihaoyou);
            convertView.setTag(holder);
        }else {
            holder = (GroupViewHolder) convertView.getTag();
        }
         holder.youxihaoyou.setText(myList.get(groupPosition).haoyou);
         holder.youxidaqu.setText(myList.get(groupPosition).youxidaqu);
        return convertView;
    }
    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        // TODO Auto-generated method
        ChildViewHolder holder=null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_messagechild, null);
            holder = new ChildViewHolder();
            holder.mIcon=(ImageView)convertView.findViewById(R.id.icon);
            holder.mChildName=(TextView)convertView.findViewById(R.id.name);
            holder.mDetail=(TextView)convertView.findViewById(R.id.text);
            holder.state=(TextView)convertView.findViewById(R.id.state);
            convertView.setTag(holder);
        }else {
            holder = (ChildViewHolder) convertView.getTag();
        }
        ColorStateList colors = mContext.getResources().getColorStateList(R.color.red);
        holder.mIcon.setImageResource(childlist.get(groupPosition).get(childPosition).icon);
        holder.mChildName.setText(childlist.get(groupPosition).get(childPosition).name);
        holder.mDetail.setText(childlist.get(groupPosition).get(childPosition).content);
        holder.state.setText(childlist.get(groupPosition).get(childPosition).state);
        if(groupPosition==0&&childPosition==1){
            holder.state.setTextColor(colors);
        }
        else if(groupPosition==1){
            holder.state.setTextColor(colors);
        }

        return convertView;
    }
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        /*很重要：实现ChildView点击事件，必须返回true*/
        return true;
    }
    private class ChildViewHolder {
        ImageView mIcon;
        TextView mChildName;
        TextView mDetail;
        TextView state;
    }
    private class GroupViewHolder {
        TextView youxihaoyou;
        TextView youxidaqu;
    }
}




