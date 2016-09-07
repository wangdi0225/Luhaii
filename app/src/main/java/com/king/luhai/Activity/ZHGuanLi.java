package com.king.luhai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.king.luhai.R;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
public class ZHGuanLi extends Activity {
    ImageView data_fanhui;
    TextView tianjiahaoma;
    Button zhuanghaoGL_tuichu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhguanli);

        data_fanhui=(ImageView)findViewById(R.id.data_fanhui);
        tianjiahaoma=(TextView)findViewById(R.id.tianjiahaoma);
        zhuanghaoGL_tuichu=(Button)findViewById(R.id.zhuanghaoGL_tuichu);

        data_fanhui.setOnClickListener(onClickListener);
        tianjiahaoma.setOnClickListener(onClickListener);
        zhuanghaoGL_tuichu.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.data_fanhui:
                    Intent intent=new Intent();
                    intent.setClass(ZHGuanLi.this,XiTongSheZheActivity.class);
                    startActivity(intent);

                    break;

                case R.id.tianjiahaoma:
                    Intent intent1=new Intent();
                    intent1.setClass(ZHGuanLi.this,LoginActivity.class);
                    startActivity(intent1);

                    break;

                case R.id.zhuanghaoGL_tuichu:
                    Intent intent2=new Intent();
                    intent2.setClass(ZHGuanLi.this,LoginActivity.class);
                    startActivity(intent2);

                    break;

                default:
                    break;


            };
        }
    };
}
