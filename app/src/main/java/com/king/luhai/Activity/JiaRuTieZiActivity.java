package com.king.luhai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.king.luhai.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class JiaRuTieZiActivity extends Activity implements AdapterView.OnItemClickListener,AbsListView.OnScrollListener{

    ListView listView;
    TextView textView;
    ImageView jiarutiezi;
    List<Map<String,Object>> lists=new ArrayList<Map<String, Object>>();
    SimpleAdapter simpleAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jiaru_tiezi);

        String[] from={"images","name","kanke","xiaoxi","date","shuoming"};
        int[] to={R.id.tiezi_user,R.id.tiezi_username,R.id.tiezi_kanke,R.id.tiezi_xiaoxi,R.id.tiezi_shijian,R.id.user_shuoming};

        listView=(ListView)findViewById(R.id.jiarutiezi_listView);
        jiarutiezi=(ImageView)findViewById(R.id.jiarutiezi);

        jiarutiezi.setOnClickListener(listener);

        getData();

        simpleAdapter=new SimpleAdapter(JiaRuTieZiActivity.this,lists,R.layout.activity_jiarutiezi,from,to);

        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(this);
    }
    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                 case R.id.jiarutiezi:
                     Intent intent=new Intent();
                     intent.setClass(JiaRuTieZiActivity.this,WoDeTieZiActivity.class);
                     startActivity(intent);

                     break;


                 default:
                     break;

            };

        }
    };


public void getData(){

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("images", R.mipmap.meinv2);
        map.put("name", "中路自然崩");
        map.put("kanke", "8");
        map.put("xiaoxi", "0");
        map.put("date", "2015.9.12");
        map.put("shuoming", "本人菜鸟，求大神带我飞");
        lists.add(map);

        map = new HashMap<String, Object>();
        map.put("images", R.mipmap.meinv2);
        map.put("name", "中路自然崩");
        map.put("kanke", "8");
        map.put("xiaoxi", "0");
        map.put("date", "2015.9.12");
        map.put("shuoming", "本人菜鸟，求大神带我飞");
        lists.add(map);

         map = new HashMap<String, Object>();
         map.put("images", R.mipmap.meinv2);
         map.put("name", "中路自然崩");
         map.put("kanke", "8");
         map.put("xiaoxi", "0");
         map.put("date", "2015.9.12");
         map.put("shuoming", "本人菜鸟，求大神带我飞");
         lists.add(map);
};

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
       /* TextView tiezi_xiaoxi= (TextView) view.findViewById(R.id.tiezi_xiaoxi);
        final int p=i;
        tiezi_xiaoxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(JiaRuTieZiActivity.this,"评论"+p,Toast.LENGTH_SHORT).show();
            }
        });*/

        Intent intent1=new Intent(JiaRuTieZiActivity.this,TiZiXiangQingActivity.class);
        startActivity(intent1);


    }


    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {

    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {

    }
}
