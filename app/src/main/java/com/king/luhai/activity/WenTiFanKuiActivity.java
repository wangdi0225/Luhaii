package com.king.luhai.activity;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.LinkAddress;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.king.luhai.R;

import java.util.Timer;

public class WenTiFanKuiActivity extends Activity {
    ImageView wentifankui_back;
    TextView wenti_weizhi, wenti_gongkai;
    LinearLayout wentifankui;
    EditText edittext;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wentifankui);


        wentifankui_back = (ImageView) findViewById(R.id.wentifankui_back);
        wenti_weizhi = (TextView) findViewById(R.id.wenti_weizhi);
        wenti_gongkai = (TextView) findViewById(R.id.wenti_gongkai);
        wentifankui = (LinearLayout) findViewById(R.id.wentifankui);

        wentifankui_back.setOnClickListener(onClickListener);
        wenti_weizhi.setOnClickListener(onClickListener);
        wenti_gongkai.setOnClickListener(onClickListener);
        wentifankui.setOnClickListener(onClickListener);

    }


    View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.wentifankui_back:
                    Intent intent = new Intent();
                    intent.setClass(WenTiFanKuiActivity.this, XiTongSheZheActivity.class);
                    startActivity(intent);

                    break;

                case R.id.wenti_weizhi:
                    Intent intent1 = new Intent();
                    intent1.setClass(WenTiFanKuiActivity.this, WeiZhiActivity.class);
                    startActivity(intent1);

                    break;

                case R.id.wenti_gongkai:
                    Intent intent2 = new Intent();
                    intent2.setClass(WenTiFanKuiActivity.this, ShuiKeKanActivity.class);
                    startActivity(intent2);

                    break;

                case R.id.wentifankui:
                    Toast.makeText(WenTiFanKuiActivity.this, "", Toast.LENGTH_SHORT).show();


                    break;


                default:
                    break;


            }
            ;

        }
    };

}
