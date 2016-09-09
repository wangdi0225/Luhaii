package com.king.luhai.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.king.luhai.R;

import java.net.SocketImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ShiPingActivity extends Activity {
    ImageView shiping_back,bofangqi_niu,bofangqi_niu2;
    TextView shiping_gengduo;
    SimpleAdapter simpleAdapter;
    List<Map<String,Object>> lists=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shiping);



        shiping_back=(ImageView)findViewById(R.id.shiping_back);
        bofangqi_niu=(ImageView)findViewById(R.id.bofangqi_niu);
        bofangqi_niu2=(ImageView)findViewById(R.id.bofangqi_niu2);
        shiping_gengduo=(TextView)findViewById(R.id.shiping_gengduo);

        shiping_back.setOnClickListener(onClickListener);
        bofangqi_niu.setOnClickListener(onClickListener);
        bofangqi_niu2.setOnClickListener(onClickListener);
        shiping_gengduo.setOnClickListener(onClickListener);


    }

    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
             switch (view.getId()){
                 case R.id.shiping_back:

                     break;

                 case R.id.bofangqi_niu:

                     break;

                 case R.id.bofang_anniu2:

                     break;

                 case R.id.shiping_gengduo:

                     break;


                 default:
                     break;


             };
        }
    };

}
