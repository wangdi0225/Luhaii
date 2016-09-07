package com.king.luhai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.king.luhai.R;


public class YinSiSheZhiActivity extends Activity {

    ImageView jiawo_yanzheng,yinsi_shezhi_back;
    CheckBox sousuowo,wotuijian;
    LinearLayout heimingdan_linearLayout,bukantade_linearLayout,jiawoyanzheng_linearLayout,tuijianhaoyou_linearLayout,sousuowo_linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yinsi_shezhi);

        jiawo_yanzheng=(ImageView)findViewById(R.id.jiawo_yanzheng);
        wotuijian= (CheckBox) findViewById(R.id.wotuijian);
        sousuowo= (CheckBox) findViewById(R.id.sousuowo);
        yinsi_shezhi_back=(ImageView)findViewById(R.id.yinsi_shezhi_back);

        heimingdan_linearLayout=(LinearLayout) findViewById(R.id.heimingdan_linearLayout);
        bukantade_linearLayout=(LinearLayout) findViewById(R.id.bukantade_linearLayout);
        jiawoyanzheng_linearLayout=(LinearLayout)findViewById(R.id.jiawoyanzheng_linearLayout);
        tuijianhaoyou_linearLayout=(LinearLayout)findViewById(R.id.tuijianhaoyou_linearLayout);
        sousuowo_linearLayout=(LinearLayout)findViewById(R.id.sousuowo_linearLayout);


        jiawo_yanzheng.setOnClickListener(listener);
        wotuijian.setOnClickListener(listener);
        sousuowo.setOnClickListener(listener);
        heimingdan_linearLayout.setOnClickListener(listener);
        bukantade_linearLayout.setOnClickListener(listener);
        jiawoyanzheng_linearLayout.setOnClickListener(listener);
        tuijianhaoyou_linearLayout.setOnClickListener(listener);
        sousuowo_linearLayout.setOnClickListener(listener);

        yinsi_shezhi_back.setOnClickListener(listener);

    }
    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view){
            switch (view.getId()){
                case R.id.yinsi_shezhi_back:
                    Intent intent=new Intent();
                    intent.setClass(YinSiSheZhiActivity.this,XiTongSheZheActivity.class);
                    startActivity(intent);

                    break;

                case R.id.heimingdan_linearLayout:
                    Intent intent1=new Intent();
                    intent1.setClass(YinSiSheZhiActivity.this,HomepageActivity.class);
                    startActivity(intent1);

                    break;

                case R.id.bukantade_linearLayout:
                    Intent intent2=new Intent();
                    intent2.setClass(YinSiSheZhiActivity.this,HomepageActivity.class);
                    startActivity(intent2);

                    break;

                case R.id.jiawoyanzheng_linearLayout:

                    break;

                case R.id.tuijianhaoyou_linearLayout:

                    break;

                case R.id.sousuowo_linearLayout:

                    break;

                case R.id.wotuijian:
                    Toast.makeText(YinSiSheZhiActivity.this,"FIFA",Toast.LENGTH_SHORT).show();

                    break;



                default:
                    break;


            };



        }
    };


}
