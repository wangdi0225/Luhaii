package com.king.luhai.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.king.luhai.R;

public class WenTiFanKuiActivity extends Activity {
            ImageView wentifankui_back;
            TextView wenti_weizhi,wenti_gongkai;
            EditText wentifankui;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wentifankui);

        wentifankui_back=(ImageView)findViewById(R.id.wentifankui_back);
        wenti_weizhi=(TextView)findViewById(R.id.wenti_weizhi);
        wenti_gongkai=(TextView) findViewById(R.id.wenti_gongkai);
        wentifankui=(EditText)findViewById(R.id.wentifankui);

        wentifankui_back.setOnClickListener(onClickListener);
        wenti_weizhi.setOnClickListener(onClickListener);
        wenti_gongkai.setOnClickListener(onClickListener);
        wentifankui.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener=new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.wentifankui_back:
                    Intent intent=new Intent();
                    intent.setClass(WenTiFanKuiActivity.this,ZhuanFaActivity.class);
                    startActivity(intent);

                    break;

                case R.id.wenti_weizhi:
                    Intent intent1=new Intent();
                    intent1.setClass(WenTiFanKuiActivity.this,ZhuanFaActivity.class);
                    startActivity(intent1);

                    break;

                case R.id.wenti_gongkai:
                    Intent intent2=new Intent();
                    intent2.setClass(WenTiFanKuiActivity.this,ZhuanFaActivity.class);
                    startActivity(intent2);

                    break;

                case R.id.wentifankui:
                    Toast.makeText(WenTiFanKuiActivity.this,"",Toast.LENGTH_SHORT).show();

                    break;


                default:
                    break;


            };

        }
    };

}
