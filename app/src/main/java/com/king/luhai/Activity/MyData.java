package com.king.luhai.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.king.luhai.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/22 0022.
 */
public class MyData extends Activity {
    ListView data_lv;
    SimpleAdapter sa;
    List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mydata);
        chushi();
        data_lv.setAdapter(sa);
    }
    private void chushi(){
        data_lv= (ListView) findViewById(R.id.data_lv);
        String[] from={"tx","ms","jg","js","sw","zg","rq","time"};
        int[] to={R.id.data_item_tx,R.id.data_item_ms,R.id.data_item_jg,R.id.data_item_js,R.id.data_item_sw,R.id.data_item_zg,R.id.data_item_rq,R.id.data_item_time,};
        sa=new SimpleAdapter(this,getList(),R.layout.data_item,from,to);
        }

    public List<Map<String, Object>> getList() {
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("tx",R.mipmap.ic_launcher);
        map.put("ms","");
        map.put("ms","");
        map.put("ms","");
        map.put("ms","");
        map.put("ms","");
        map.put("ms","");
        map.put("ms","");
        return list;
    }
}
