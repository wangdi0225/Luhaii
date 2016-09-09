package com.king.luhai.activity;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.king.luhai.R;

import org.w3c.dom.Text;


public class WoDeTieZiActivity extends Activity {

    ImageView wode_tiezi_back;

    LinearLayout jiarudetiezi_linearLayout;

    TextView yifaguo_tiezi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wode_tiezi);

        jiarudetiezi_linearLayout=(LinearLayout) findViewById(R.id.jiarudetiezi_linearLayout);
        wode_tiezi_back=(ImageView)findViewById(R.id.wode_tiezi_back);

        yifaguo_tiezi=(TextView)findViewById(R.id.yifaguo_tiezi);
        yifaguo_tiezi.setOnClickListener(listener);

        wode_tiezi_back.setOnClickListener(listener);
        jiarudetiezi_linearLayout.setOnClickListener(listener);


    }

    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.jiarudetiezi_linearLayout:
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
