package com.king.luhai.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.king.luhai.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DuiHuanShangPinActivty extends Activity {

    GridView gridView;
    SimpleAdapter simpleAdapter;

    List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.duihuan_shangpin);


        gridView = (GridView) findViewById(R.id.duihuan_gridView);


        String[] from = {"images", "mingzi", "jiage"};
        int[] to = {R.id.image_timos, R.id.renwu, R.id.wujia};

        simpleAdapter = new SimpleAdapter(this, getLists(), R.layout.activity_duihuan, from, to);

        gridView.setAdapter(simpleAdapter);

    }

    public List<Map<String, Object>> getLists() {

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("images", R.mipmap.timod);

        map.put("mingzi", "迅捷斥候");
        map.put("jiage", "500");
        lists.add(map);

        map = new HashMap<String, Object>();
        map.put("images", R.mipmap.dasheng);
        map.put("mingzi", "齐天大圣");
        map.put("jiage", "500");
        lists.add(map);

        map = new HashMap<String, Object>();
        map.put("images", R.mipmap.guanghui);
        map.put("mingzi", "光辉女郎");
        map.put("jiage", "500");
        lists.add(map);

        map = new HashMap<String, Object>();
        map.put("images", R.mipmap.hanbing);
        map.put("mingzi", "寒冰射手");
        map.put("jiage", "500");
        lists.add(map);

        map = new HashMap<String, Object>();
        map.put("images", R.mipmap.guicai);
        map.put("mingzi", "爆破鬼才");
        map.put("jiage", "500");
        lists.add(map);

        map = new HashMap<String, Object>();
        map.put("images", R.mipmap.longgui);
        map.put("mingzi", "披甲龙龟");
        map.put("jiage", "500");
        lists.add(map);

        return lists;
    }
}

