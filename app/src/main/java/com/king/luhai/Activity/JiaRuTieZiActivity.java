package com.king.luhai.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.king.luhai.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class JiaRuTieZiActivity extends Activity {

    ListView listView;
    TextView textView;
    ImageView imageView;
    List<Map<String,Object>> lists=new ArrayList<Map<String, Object>>();
    SimpleAdapter simpleAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jiaru_tiezi);

        String[] from={"images","name","kanke","xiaoxi","date","shuoming"};
        int[] to={R.id.tiezi_user,R.id.tiezi_username,R.id.tiezi_kanke,R.id.tiezi_xiaoxi,R.id.tiezi_shijian,R.id.user_shuoming};

        listView=(ListView)findViewById(R.id.jiarutiezi_listView);

        getData();

        simpleAdapter=new SimpleAdapter(JiaRuTieZiActivity.this,lists,R.layout.activity_jiarutiezi,from,to);

        listView.setAdapter(simpleAdapter);

    }

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


}
