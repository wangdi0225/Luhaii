package com.king.luhai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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


public class FaGuoTieZiActivity extends Activity {

    SimpleAdapter simpleAdapter;
    ListView listView;
    List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();

    TextView tieze_usersname,tize_kankaS,tiezi_xiaoxiS,tiezi_dates,tiezi_shuomingS;

    ImageView tiezi_users,faguo_tieziback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faguo_tiezi);


        listView = (ListView) findViewById (R.id.yifa_tiezi_listView);

        String [] from={"images","biaoti","kanke","xiaoxi","date","shuoming"};
        int [] to={R.id.tiezi_users,R.id.tieze_usersname,R.id.tize_kankaS,R.id.tiezi_xiaoxiS,R.id.tiezi_dates,R.id.tiezi_shuomingS};

        getData();

        simpleAdapter=new SimpleAdapter(FaGuoTieZiActivity.this,getData(),R.layout.activity_faguotiezi,from,to);

        listView.setAdapter(simpleAdapter);

        tiezi_users=(ImageView)findViewById(R.id.tiezi_users);
        tieze_usersname=(TextView)findViewById(R.id.tieze_usersname);
        tize_kankaS=(TextView)findViewById(R.id.tize_kankaS);
        tiezi_xiaoxiS=(TextView)findViewById(R.id.tiezi_xiaoxiS);
        tiezi_dates=(TextView)findViewById(R.id.tiezi_dates);
        tiezi_shuomingS=(TextView)findViewById(R.id.tiezi_shuomingS);
        faguo_tieziback=(ImageView)findViewById(R.id.faguo_tieziback);


      //  tiezi_users.setOnClickListener(listener);
      //  tieze_usersname.setOnClickListener(listener);
      //  tize_kankaS.setOnClickListener(listener);
      //  tiezi_xiaoxiS.setOnClickListener(listener);
      //  tiezi_dates.setOnClickListener(listener);
      //  tiezi_shuomingS.setOnClickListener(listener);
        faguo_tieziback.setOnClickListener(listener);


    }






    public  List<Map<String,Object>> getData(){
        for (int i=0;i<10;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("images", R.mipmap.meinv2);
            map.put("biaoti", "SKT-1  Caker");
            map.put("kanke", "24");
            map.put("xiaoxi", "0");
            map.put("date", "2015.8.12");
            map.put("shuoming", "艾欧尼亚五差一个");
            list.add(map);

        }

        return list;
    };

    View.OnClickListener listener=new View.OnClickListener () {

        public void onClick(View view){
            switch (view.getId()){
                case R.id.faguo_tieziback:
                    Intent intent=new Intent();
                    intent.setClass(FaGuoTieZiActivity.this,WoDeTieZiActivity.class);
                    startActivity(intent);

                    break;

                case R.id.tize_kankaS:
                    Toast.makeText(FaGuoTieZiActivity.this,"看看",Toast.LENGTH_SHORT).show();

                    break;

                case R.id.tiezi_xiaoxiS:
                    Toast.makeText(FaGuoTieZiActivity.this,"消息",Toast.LENGTH_SHORT).show();

                    break;

                default:
                    break;
            };

        };


    };

    AdapterView.OnItemClickListener cliclListener=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


        }
    };



}
