package com.king.luhai.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.king.luhai.R;

public class TianJiaHaoYouActivity extends Activity{


    LinearLayout tianjia_friendback,QQnumber_linearLayout,newfriend_linearLayout,likemore_linearLayout,
                  xinlangweibo_linearLayout,tenxunweibo_linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tianjia_haoyou);

        QQnumber_linearLayout=(LinearLayout) findViewById(R.id.QQnumber_linearLayout);
        newfriend_linearLayout=(LinearLayout) findViewById(R.id.newfriend_linearLayout);
        likemore_linearLayout=(LinearLayout) findViewById(R.id.likemore_linearLayout);
        xinlangweibo_linearLayout=(LinearLayout) findViewById(R.id.xinlangweibo_linearLayout);
        tenxunweibo_linearLayout=(LinearLayout)findViewById(R.id.tenxunweibo_linearLayout);
        tianjia_friendback=(LinearLayout) findViewById(R.id.tianjia_friendback);

        QQnumber_linearLayout.setOnClickListener(onClickListener);
        newfriend_linearLayout.setOnClickListener(onClickListener);
        likemore_linearLayout.setOnClickListener(onClickListener);
        xinlangweibo_linearLayout.setOnClickListener(onClickListener);
        tenxunweibo_linearLayout.setOnClickListener(onClickListener);
        tianjia_friendback.setOnClickListener(onClickListener);


    }

    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.tianjia_friendback:
                    Intent intent=new Intent();
                    intent.setClass(TianJiaHaoYouActivity.this,WenTiFanKuiActivity.class);
                    startActivity(intent);

                    break;

                case R.id.QQnumber_linearLayout:
                    Intent intent1=new Intent();
                    intent1.setClass(TianJiaHaoYouActivity.this,SouSuoActivity.class);
                    startActivity(intent1);

                    break;

                case R.id.likemore_linearLayout:
                    Intent intent2=new Intent();
                    intent2.setClass(TianJiaHaoYouActivity.this,WenTiFanKuiActivity.class);
                    startActivity(intent2);

                    break;

                case R.id.xinlangweibo_linearLayout:
                    Intent intent3=new Intent();
                    intent3.setClass(TianJiaHaoYouActivity.this,WenTiFanKuiActivity.class);
                    startActivity(intent3);

                    break;

                case R.id.tenxunweibo_linearLayout:
                    Intent intent4=new Intent();
                    intent4.setClass(TianJiaHaoYouActivity.this,WenTiFanKuiActivity.class);
                    startActivity(intent4);

                    break;


                default:
                    break;

            };
        }
    };







}
