package com.king.luhai.Activity;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.king.luhai.R;

public class ZhuanFaActivity extends Activity {
       TextView textView,zhuanfa,liyou;
       ImageView imageViewface,imageViewPictrue;
       CheckBox  pinglun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhuanfa_yemian);

        textView=(TextView) findViewById(R.id.zhuanfa_back);
        zhuanfa=(TextView)findViewById(R.id.fasong);
        liyou=(TextView)findViewById(R.id.liyou);
        pinglun=(CheckBox)findViewById(R.id.zhuanfa_pinglun);
        imageViewface=(ImageView)findViewById(R.id.zhuanfa_biaoqing);
        imageViewPictrue=(ImageView)findViewById(R.id.zhuanfa_tupian);


        textView.setOnClickListener(listener);
        zhuanfa.setOnClickListener(listener);
        liyou.setOnClickListener(listener);
        pinglun.setOnClickListener(listener);
        imageViewface.setOnClickListener(listener);
        imageViewPictrue.setOnClickListener(listener);

    }

    View.OnClickListener listener=new View.OnClickListener() {

        @Override
        public void onClick(View view) {
               switch (view.getId()){
                   case R.id.zhuanfa_back:
                       Intent intent = new Intent();
                       intent.setClass(ZhuanFaActivity.this, ShangPinActivity.class);
                       startActivity(intent);

                       break;

                   case R.id.fasong:
                       Toast.makeText(ZhuanFaActivity.this,"发送",Toast.LENGTH_SHORT).show();

                       break;

                   case R.id.liyou:
                       Toast.makeText(ZhuanFaActivity.this, "请输入分享理由", Toast.LENGTH_SHORT).show();
                       liyou.setHint("");
                       break;

                   default:
                       break;
               }
        }
    };



}
