package com.king.luhai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.king.luhai.R;


public class WoDeTieZiActivity extends Activity {

    ImageView jiaru_tiezi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wode_tiezi);

        jiaru_tiezi=(ImageView)findViewById(R.id.jiaru_tiezi);

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

                default:
                    break;

            };

        }

    };


    }
