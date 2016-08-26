package com.king.luhai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.king.luhai.R;


public class JiFenShangChengActivity extends Activity {

    ImageView jifen_right,jifenhuanSp,maiguo_Sp,shoudao_Sp,songchu_Sp,jifenBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jifen_shangcheng);

        jifen_right=(ImageView)findViewById(R.id.jifen_right);
        jifenhuanSp=(ImageView)findViewById(R.id.jifenhuanSp);
        maiguo_Sp=(ImageView)findViewById(R.id.maiguo_Sp);
        shoudao_Sp=(ImageView)findViewById(R.id.shoudao_Sp);
        songchu_Sp=(ImageView)findViewById(R.id.songchu_Sp);
        jifenBack=(ImageView) findViewById(R.id.jifen_back);

        jifen_right.setOnClickListener(listener);
        jifenhuanSp.setOnClickListener(listener);
        maiguo_Sp.setOnClickListener(listener);
        shoudao_Sp.setOnClickListener(listener);
        songchu_Sp.setOnClickListener(listener);
        jifenBack.setOnClickListener(listener);



    }

    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view){
              switch (view.getId()){
                  case R.id.jifen_back:
                      Intent intent=new Intent();
                      intent.setClass(JiFenShangChengActivity.this,ZhuanFaActivity.class);
                      startActivity(intent);

                      break;

                  case R.id.jifen_right:
                      Intent intent2=new Intent();
                      intent2.setClass(JiFenShangChengActivity.this,WoDeJiFenActivity.class);
                      startActivity(intent2);

                      break;

                  case R.id.jifenhuanSp:
                      Intent intent3=new Intent();
                      intent3.setClass(JiFenShangChengActivity.this,DuiHuanShangPinActivty.class);
                      startActivity(intent3);

                      break;

                  case R.id.maiguo_Sp:
                      Intent intent4=new Intent();
                      intent4.setClass(JiFenShangChengActivity.this,ZhuanFaActivity.class);
                      startActivity(intent4);

                      break;

                  case R.id.shoudao_Sp:
                      Intent intent5=new Intent();
                      intent5.setClass(JiFenShangChengActivity.this,ShouShangPinActivity.class);
                      startActivity(intent5);

                      break;

                  case R.id.songchu_Sp:
                      Intent intent6=new Intent();
                      intent6.setClass(JiFenShangChengActivity.this,ShangPinActivity.class);
                      startActivity(intent6);

                      break;



                  default:
                      break;

              }
        }
    };



    }
