package com.king.luhai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.king.luhai.R;


public class GuanYuWoMenActivity extends Activity {

    ImageView guanyu_back;
    TextView pingfen,gongneng_jieshao,xinbanben;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guanyu_women);

        guanyu_back=(ImageView)findViewById(R.id.guanyu_back);
        pingfen=(TextView)findViewById(R.id.pingfen);
        gongneng_jieshao=(TextView)findViewById(R.id.gongneng_jieshao);
        xinbanben=(TextView)findViewById(R.id.xinbanben);


        guanyu_back.setOnClickListener(onClickListener);
        pingfen.setOnClickListener(onClickListener);
        gongneng_jieshao.setOnClickListener(onClickListener);
        xinbanben.setOnClickListener(onClickListener);

    }
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
               switch (view.getId()){
                   case R.id.guanyu_back:
                       Intent intent=new Intent();
                       intent.setClass(GuanYuWoMenActivity.this,XiTongSheZheActivity.class);
                       startActivity(intent);

                       break;

                   case R.id.pingfen:
                       Toast.makeText(GuanYuWoMenActivity.this,"五星",Toast.LENGTH_SHORT).show();

                       break;

                   case R.id.gongneng_jieshao:
                       Toast.makeText(GuanYuWoMenActivity.this, "打LOL", Toast.LENGTH_SHORT).show();

                       break;

                   case R.id.xinbanben:
                       Toast.makeText(GuanYuWoMenActivity.this, "没得", Toast.LENGTH_SHORT).show();

                       break;

                   default:
                       break;
               };
        }
    };






}
