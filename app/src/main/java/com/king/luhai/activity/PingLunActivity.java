package com.king.luhai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.king.luhai.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PingLunActivity extends Activity {
    LinearLayout pllayout,edlyout;
    RelativeLayout bqlyout;
    ListView pinglun_xiangqingList;

    List<Map<String,Object>> lists=new ArrayList<>();
    SimpleAdapter simpleAdapter;
    ImageView pinglunaite,pinglunxiaolian,pinglunpicture,pinglun_xiangqing;
    EditText pinglun_edit;
    TextView dianzan_xiangqingdianzan,dianzan_xiangqingpinglun,dianzan_xiangqingzhuanfa,pinglun_xiangqing_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pinglunxiangqing);

        LayoutInflater inflater= LayoutInflater.from(PingLunActivity.this);
        pinglun_xiangqingList=(ListView)findViewById(R.id.pinglun_xiangqingList);

        View v=inflater.inflate(R.layout.pinglunxiangqing_headitem,null);
        pinglun_xiangqingList.addHeaderView(v);

        bqlyout= (RelativeLayout) findViewById(R.id.bqlayout);
        edlyout= (LinearLayout) findViewById(R.id.edlayout);
        pllayout= (LinearLayout) findViewById(R.id.pllayout);

        pinglun_xiangqing_back= (TextView) findViewById(R.id.pinglun_xiangqing_back);
        pinglunaite=(ImageView) findViewById(R.id.pinglunaite);
        pinglunxiaolian=(ImageView) findViewById(R.id.pinglunxiaolian);
        pinglunpicture=(ImageView) findViewById(R.id.pinglunpicture);
        pinglun_xiangqing=(ImageView) findViewById(R.id.pinglun_xiangqing);
        pinglun_edit=(EditText)findViewById(R.id.pinglun_edit) ;

        dianzan_xiangqingdianzan=(TextView)findViewById(R.id.dianzan_xiangqingdianzan);
        dianzan_xiangqingpinglun=(TextView)findViewById(R.id.dianzan_xiangqingpinglun);
        dianzan_xiangqingzhuanfa=(TextView)findViewById(R.id.dianzan_xiangqingzhuanfa);


        pinglun_xiangqing_back.setOnClickListener(listener);
        pinglunaite.setOnClickListener(listener);
        pinglunxiaolian.setOnClickListener(listener);
        pinglunpicture.setOnClickListener(listener);
        pinglun_xiangqing.setOnClickListener(listener);
        pinglun_edit.setOnClickListener(listener);





        String[] from ={"name","date","pinglun","images"};
        int[] to={R.id.pinglun_deren,R.id.pinglun_date,R.id.pinglun_dehua,R.id.pinglun_user_images};

        getdata();

        simpleAdapter=new SimpleAdapter(PingLunActivity.this,lists,R.layout.pinglun_xiangqingitem,from,to);

        pinglun_xiangqingList.setAdapter(simpleAdapter);

        dianzan_xiangqingpinglun.setOnClickListener(listener);
        dianzan_xiangqingzhuanfa.setOnClickListener(listener);

    }


    public void getdata(){

            Map<String,Object> map=new HashMap<>();
            map.put("name","叶良辰");
            map.put("date","03-10 09:29");
            map.put("pinglun","来啊，一起一起!");
            map.put("images",R.mipmap.aamao);
            lists.add(map);
        }





    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
               switch (view.getId()){
                   case R.id.pinglun_xiangqing_back:
                       Intent intent=new Intent();
                       intent.setClass(PingLunActivity.this,PingLunActivity.class);
                       startActivity(intent);

                       break;

                   case R.id.pinglunaite:

                       break;

                   case R.id.pinglunxiaolian:

                       break;

                   case R.id.pinglunpicture:

                       break;

                   case R.id.pinglun_xiangqing:


                       pllayout.setVisibility(View.VISIBLE);
                       bqlyout.setVisibility(View.GONE);
                       edlyout.setVisibility(View.GONE);
                       break;

                   case R.id.dianzan_xiangqingdianzan:

                       break;

                   case R.id.dianzan_xiangqingpinglun:
                       pllayout.setVisibility(View.GONE);
                       bqlyout.setVisibility(View.VISIBLE);
                       edlyout.setVisibility(View.VISIBLE);
                       break;

                   case R.id.dianzan_xiangqingzhuanfa:
                       Intent intent3=new Intent();
                       intent3.setClass(PingLunActivity.this,ZhuanFaActivity.class);
                       startActivity(intent3);
                       break;

                   case R.id.pinglun_edit:
                       Toast.makeText(PingLunActivity.this,"说点啥",Toast.LENGTH_SHORT).show();

                       break;

                   default:
                       break;


               };
        }
    };

}
