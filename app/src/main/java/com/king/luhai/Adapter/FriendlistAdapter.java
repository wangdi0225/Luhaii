package com.king.luhai.adapter;

import android.app.Activity;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.king.luhai.product.Friendlist;
import com.king.luhai.product.MyGridView;
import com.king.luhai.product.SysUtils;
import com.king.luhai.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adminaistrator on 2016/8/30.
 */
public class FriendlistAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private Activity context;
    private List<Friendlist> list;
    private FinalBitmap finalImageLoader;
    private FriendGridViewAdapter nearByInfoImgsAdapter;
    private int wh;

    public FriendlistAdapter(Activity context, List<Friendlist> list) {
        super();
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.wh = (SysUtils.getScreenWidth(context) - SysUtils.Dp2Px(context, 99)) / 3;
        this.list = list;
        this.finalImageLoader = FinalBitmap.create(context);
        this.finalImageLoader.configLoadingImage(R.mipmap.ic_launcher);
    }

    public List<Friendlist> getList() {
        return list;
    }

    public void setList(List<Friendlist> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int arg0) {
        return list == null ? null : list.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return list == null ? null : arg0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (list.size() == 0) {
            return null;
        }
        final ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_dongtailist, null);
            holder = new ViewHolder();
            holder.headphoto = (ImageView) convertView.findViewById(R.id.title);//头像
            holder.dianzhan = (TextView) convertView.findViewById(R.id.dianzhan);//点赞
            holder.pinglun = (TextView) convertView.findViewById(R.id.pinglun);//评论
            holder.zhuanfa = (TextView) convertView.findViewById(R.id.zhuanfa);//转发
            holder.disName = (TextView) convertView.findViewById(R.id.name);//昵称
            holder.time = (TextView) convertView.findViewById(R.id.time);//时间
            holder.content = (TextView) convertView.findViewById(R.id.content);//发布内容
            holder.rl4 = (RelativeLayout) convertView.findViewById(R.id.rl4);//图片布局
            holder.gv_images = (MyGridView) convertView.findViewById(R.id.gv_images);//图片
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final Friendlist bean = list.get(position);

        String name = null, time = null, content = null, contentimage = null;
        int headpath = 0;

        holder.dianzhan.setOnClickListener(new View.OnClickListener() {
            boolean ischeck = true;

            @Override
            public void onClick(View view) {
                if (ischeck) {
                    holder.dianzhan.setText("2");
                    holder.dianzhan.setBackgroundResource(R.color.tubiaose1);
                    ischeck = false;
                } else {
                    holder.dianzhan.setText("1");
                    holder.dianzhan.setBackgroundResource(R.color.white);
                    ischeck = true;

                }
            }
        });


        if (bean != null) {
            name = bean.getUsername();
            time = bean.getTime();
            content = bean.getContent();
            headpath = bean.getHeadphoto();
            contentimage = bean.getImages();
        }
        //昵称
        if (name != null && !name.equals("")) {
            holder.disName.setText(name);
        }
        //是否含有图片
        if (contentimage != null && !contentimage.equals("")) {
            holder.rl4.setVisibility(View.VISIBLE);
            initInfoImages(holder.gv_images, contentimage);
        } else {
            holder.rl4.setVisibility(View.GONE);
        }
        //发布时间
        if (time != null && !time.equals("")) {
            holder.time.setText(time);
        }
        //内容
        if (content != null && !content.equals("")) {
            holder.content.setText(content);
            Linkify.addLinks(holder.content, Linkify.WEB_URLS);
        }
        //头像
        if (headpath != 0) {
            holder.headphoto.setImageResource(headpath);
        } else {
            holder.headphoto.setImageResource(R.mipmap.ic_launcher);
        }
        holder.headphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(context, "点击了头像", Toast.LENGTH_LONG).show();
            }
        });
        return convertView;
    }

    static class ViewHolder {
        ImageView headphoto;
        TextView disName;
        TextView time;
        TextView content;
        MyGridView gv_images;
        RelativeLayout rl4;
        TextView dianzhan;
        TextView pinglun;
        TextView zhuanfa;

    }


    /**
     * 加载信息中包含的图片内容
     *
     * @param imgspath
     */

    public void initInfoImages(MyGridView gv_images, final String imgspath) {
        if (imgspath != null && !imgspath.equals("")) {
            String[] imgs = imgspath.split("#");
            ArrayList<String> list = new ArrayList<String>();
            for (int i = 0; i < imgs.length; i++) {
                list.add(imgs[i]);
            }
            int w = 0;
            switch (imgs.length) {
                case 1:
                    w = wh;
                    gv_images.setNumColumns(1);
                    break;
                case 2:
                case 4:
                    w = 2 * wh + SysUtils.Dp2Px(context, 2);
                    gv_images.setNumColumns(2);
                    break;
                case 3:
                case 5:
                case 6:
                    w = wh * 3 + SysUtils.Dp2Px(context, 2) * 2;
                    gv_images.setNumColumns(3);
                    break;
            }
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(w, RelativeLayout.LayoutParams.WRAP_CONTENT);
            gv_images.setLayoutParams(lp);
            nearByInfoImgsAdapter = new FriendGridViewAdapter(context, list);
            gv_images.setAdapter(nearByInfoImgsAdapter);

        }

    }


}
