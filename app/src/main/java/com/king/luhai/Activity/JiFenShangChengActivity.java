package com.king.luhai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.king.luhai.R;


public class JiFenShangChengActivity extends Activity {

    ImageView jifen_back;
    LinearLayout wodejifen_linearLayout,jifenSp_linearLayout,yigouSp_linearLayout,shoudaoSp_linearLayout,songchuSp_linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jifen_shangcheng);

        wodejifen_linearLayout=(LinearLayout) findViewById(R.id.wodejifen_linearLayout);
        jifenSp_linearLayout=(LinearLayout) findViewById(R.id.jifenSp_linearLayout);
        yigouSp_linearLayout=(LinearLayout) findViewById(R.id.yigouSp_linearLayout);
        songchuSp_linearLayout=(LinearLayout) findViewById(R.id.songchuSp_linearLayout);
        shoudaoSp_linearLayout=(LinearLayout)findViewById(R.id.shoudaoSp_linearLayout);
        jifen_back=(ImageView)findViewById(R.id.jifen_back);

        wodejifen_linearLayout.setOnClickListener(listener);
        jifenSp_linearLayout.setOnClickListener(listener);
        yigouSp_linearLayout.setOnClickListener(listener);
        songchuSp_linearLayout.setOnClickListener(listener);
        shoudaoSp_linearLayout.setOnClickListener(listener);
        jifen_back.setOnClickListener(listener);


    }

    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view){
              switch (view.getId()){
                  case R.id.jifen_back:
                      Intent intent=new Intent();
                      intent.setClass(JiFenShangChengActivity.this,HomepageActivity.class);
                      startActivity(intent);

                      break;

                  case R.id.wodejifen_linearLayout:
                      Intent intent2=new Intent();
                      intent2.setClass(JiFenShangChengActivity.this,WoDeJiFenActivity.class);
                      startActivity(intent2);

                      break;

                  case R.id.jifenSp_linearLayout:
                      Intent intent3=new Intent();
                      intent3.setClass(JiFenShangChengActivity.this,DuiHuanShangPinActivty.class);
                      startActivity(intent3);

                      break;

                  case R.id.yigouSp_linearLayout:
                      Intent intent4=new Intent();
                      intent4.setClass(JiFenShangChengActivity.this,GouMaiShangPinActivity.class);
                      startActivity(intent4);

                      break;

                  case R.id.songchuSp_linearLayout:
                      Intent intent5=new Intent();
                      intent5.setClass(JiFenShangChengActivity.this,ShangPinActivity.class);
                      startActivity(intent5);

                      break;

                  case R.id.shoudaoSp_linearLayout:
                      Intent intent6=new Intent();
                      intent6.setClass(JiFenShangChengActivity.this,ShouShangPinActivity.class);
                      startActivity(intent6);

                      break;


                  default:
                      break;

              }
        }
    };



    }
