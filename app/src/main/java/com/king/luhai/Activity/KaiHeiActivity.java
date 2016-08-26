package com.king.luhai.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.king.luhai.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class KaiHeiActivity extends Activity {

    ListView listView;
    TextView jiarutiezi;
    ImageView kaihe_jiaru;
    List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();
    SimpleAdapter simpleAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kaihei_tuijian);

        listView=(ListView)findViewById(R.id.kaihei_listView);

        String[] from={"images","name","sex","daqu","duanwei","shuoming"};
        int[] to={R.id.kaihei_user,R.id.kaihei_name,R.id.kaihei_xingbie,R.id.kaihei_daqu,R.id.kaihei_duanwei,R.id.kaihei_qianming};


        simpleAdapter=new SimpleAdapter(KaiHeiActivity.this,lists,R.layout.activity_kaihei,from,to);

        listView.setAdapter(simpleAdapter);

        getData();

     //   kaihe_jiaru=(ImageView)findViewById(R.id.kaihe_jiaru);

     //   kaihe_jiaru.setOnClickListener(listener);

    }

    public void getData(){
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("images", R.mipmap.aamao);
            map.put("name", "机器猫不吃鱼");
            map.put("sex", R.mipmap.girl);
            map.put("daqu", "艾欧尼亚");
            map.put("duanwei", "铂金|||");
            map.put("shuoming", "这世上没有什么我做不到的事");
            lists.add(map);
        }

    };



    View.OnClickListener listener=new View.OnClickListener() {

        @Override
        public void onClick(View view){


        };


    };


}

