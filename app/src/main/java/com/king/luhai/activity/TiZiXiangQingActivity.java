package com.king.luhai.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.king.luhai.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TiZiXiangQingActivity extends Activity {
    ListView tiezixiangqing_list;
    ImageView xiangqing_back,xiangqing_xiaolian;
    SimpleAdapter simpleAdapter;
    List<Map<String,Object>> lists=new ArrayList<>();
    EditText xiangqing_edit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tiezixiangqing);

        LayoutInflater inflater= LayoutInflater.from(TiZiXiangQingActivity.this);
        tiezixiangqing_list=(ListView)findViewById(R.id.tiezixiangqing_list);

        String[] from={"name","date","pinglun","images"};
        int [] to={R.id.pinglun_userName,R.id.date,R.id.tiezi_pinglun,R.id.tiezi_images};

        getdata();

        simpleAdapter=new SimpleAdapter(TiZiXiangQingActivity.this,lists,R.layout.tiezixiangqing_item,from,to);

        View v=inflater.inflate(R.layout.tiezixiangqing_headitem,null);
        tiezixiangqing_list.addHeaderView(v);


        xiangqing_back=(ImageView)findViewById(R.id.xiangqing_back);
        xiangqing_edit=(EditText)findViewById(R.id.xiangqing_edit);
        xiangqing_xiaolian=(ImageView)findViewById(R.id.xiangqing_xiaolian);

        xiangqing_back.setOnClickListener(listener);
        xiangqing_edit.setOnClickListener(listener);
        xiangqing_xiaolian.setOnClickListener(listener);

        tiezixiangqing_list.setAdapter(simpleAdapter);
    }

    public void getdata(){
        for (int i = 0; i < 10; i++) {
            Map<String,Object> map=new HashMap<>();
            map.put("name","赵日天");
            map.put("date","03-10 13:40");
            map.put("pinglun","数据挺好");
            map.put("images",R.mipmap.aamao);
            lists.add(map);
        }


    }


    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.xiangqing_back:
                    Intent intent=new Intent();
                    intent.setClass(TiZiXiangQingActivity.this,JiaRuTieZiActivity.class);
                    startActivity(intent);

                    break;

                case R.id.xiangqing_edit:
                    Toast.makeText(TiZiXiangQingActivity.this,"说点儿啥",Toast.LENGTH_SHORT).show();

                    break;

                case R.id.xiangqing_xiaolian:
                    Toast.makeText(TiZiXiangQingActivity.this,"笑笑",Toast.LENGTH_SHORT).show();

                    break;

                default:
                    break;

            }
        }
    };






}
