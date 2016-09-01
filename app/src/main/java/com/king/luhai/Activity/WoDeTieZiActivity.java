package com.king.luhai.activity;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.king.luhai.R;


public class WoDeTieZiActivity extends Activity {

    ImageView jiaru_tiezi,wode_tiezi_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wode_tiezi);

        jiaru_tiezi=(ImageView)findViewById(R.id.jiaru_tiezi);
        wode_tiezi_back=(ImageView)findViewById(R.id.wode_tiezi_back);


        wode_tiezi_back.setOnClickListener(listener);
        jiaru_tiezi.setOnClickListener(listener);


    }

    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.jiaru_tiezi:
                    Intent intent=new Intent();
                    intent.setClass(WoDeTieZiActivity.this,JiaRuTieZiActivity.class);
                    startActivity(intent);

                    break;

                case R.id.yifaguo_tiezi:
                    Intent intent2=new Intent();
                    intent2.setClass(WoDeTieZiActivity.this,FaGuoTieZiActivity.class);
                    startActivity(intent2);

                    break;

                case R.id.wode_tiezi_back:
                    Intent intent3=new Intent();
                    intent3.setClass(WoDeTieZiActivity.this,HomepageActivity.class);
                    startActivity(intent3);

                    break;

                default:
                    break;

            };

        }

    };


    }
