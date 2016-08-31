package com.king.luhai.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import com.king.luhai.product.ChartMessage;
import com.king.luhai.R;

import java.util.List;


public class CharttingAdapter extends Adapter {
    protected static final String TAG = "ChattingAdapter";
    private Context context;
    private List<ChartMessage> chartMessages;

    public ChattingAdapter(Context context, List<ChartMessage> messages) {
        super();
        this.context = context;
        this.chartMessages = messages;
    }

    public int getCount() {
        return chartMessages.size();
    }
    public Object getItem(int position) {
        return chartMessages.get(position);
    }
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        ChartMessage message = chartMessages.get(position);
        if (convertView == null || (holder = (ViewHolder) convertView.getTag()).flag != message.getDirection()) {
            holder = new ViewHolder();
            if (message.getDirection() == ChartMessage.MESSAGE_FROM) {
                holder.flag = ChartMessage.MESSAGE_FROM;
                convertView = LayoutInflater.from(context).inflate(R.layout.chartting_item_from, null);
            } else {
                holder.flag = ChartMessage.MESSAGE_TO;
                convertView = LayoutInflater.from(context).inflate(R.layout.chartting_item_to, null);
            }
        //    holder.text = (TextView) convertView.findViewById(R.id.chatting_content_itv);
            convertView.setTag(holder);
        }
        holder.text.setText(message.getContent());
        return convertView;
    }
    //优化listview的Adapter
    static class ViewHolder {
        TextView text;
        int flag;
    }
}


