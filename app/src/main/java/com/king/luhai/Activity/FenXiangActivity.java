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


public class FenXiangActivity extends Activity {

    TextView fenxiang_quxiao,fenxiang_fasong;
    EditText fenxiang_neirong;
    ImageView fenxiang_tupian,fenxiang_weizhi,fenxiang_kekan,fenxiang_shui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenxiang);

        fenxiang_quxiao=(TextView)findViewById(R.id.fenxiang_quxiao);
        fenxiang_fasong=(TextView)findViewById(R.id.fenxiang_fasong);

        fenxiang_tupian=(ImageView) findViewById(R.id.fenxiang_tupian);
        fenxiang_weizhi=(ImageView)findViewById(R.id.fenxiang_weizhi);
        fenxiang_kekan=(ImageView)findViewById(R.id.fenxiang_kekan);
        fenxiang_shui=(ImageView)findViewById(R.id.fenxiang_shui);

        fenxiang_neirong=(EditText) findViewById(R.id.fenxiang_neirong);

        fenxiang_quxiao.setOnClickListener(onClickListener);
        fenxiang_fasong.setOnClickListener(onClickListener);
        fenxiang_tupian.setOnClickListener(onClickListener);
        fenxiang_kekan.setOnClickListener(onClickListener);
        fenxiang_shui.setOnClickListener(onClickListener);
        fenxiang_neirong.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
               switch (view.getId()){
                   case R.id.fenxiang_quxiao:
                       Intent intent=new Intent();
                       intent.setClass(FenXiangActivity.this,ZhuanFaActivity.class);
                       startActivity(intent);

                       break;

                   case R.id.fenxiang_fasong:
                       Toast.makeText(FenXiangActivity.this,"发送成功",Toast.LENGTH_SHORT).show();

                       break;

                   case R.id.fenxiang_weizhi:
                       Intent intent2=new Intent();
                       intent2.setClass(FenXiangActivity.this,ZhuanFaActivity.class);
                       startActivity(intent2);

                       break;

                   case R.id.fenxiang_kekan:
                       Intent intent3=new Intent();
                       intent3.setClass(FenXiangActivity.this,ShuiKeKanActivity.class);
                       startActivity(intent3);

                       break;

                   case R.id.fenxiang_shui:
                       Intent intent4=new Intent();
                       intent4.setClass(FenXiangActivity.this,ZhuanFaActivity.class);
                       startActivity(intent4);

                       break;

                   case R.id.fenxiang_neirong:
                       Toast.makeText(FenXiangActivity.this,"想法",Toast.LENGTH_SHORT).show();
                       fenxiang_neirong.getHint();

                       break;

                   default:
                       break;

               };

        }


    };
}
