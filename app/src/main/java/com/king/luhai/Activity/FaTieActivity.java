package com.king.luhai.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.king.luhai.R;


public class FaTieActivity extends Activity {

    TextView fatiezi_quxiao,fatiezi_fasong;
    EditText fatie_neirong;

    ImageView fatie_tupian,fatie_weizhi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fatiezi);

        fatiezi_quxiao=(TextView)findViewById(R.id.fatiezi_quxiao);
        fatiezi_fasong=(TextView)findViewById(R.id.fatiezi_fasong);

        fatie_neirong=(EditText)findViewById(R.id.fatie_neirong);

        fatie_tupian=(ImageView)findViewById(R.id.fatie_tupian);
        fatie_weizhi=(ImageView)findViewById(R.id.fatie_weizhi);

        fatiezi_quxiao.setOnClickListener(onClickListener);
        fatiezi_fasong.setOnClickListener(onClickListener);
        fatie_tupian.setOnClickListener(onClickListener);
        fatie_weizhi.setOnClickListener(onClickListener);
        fatie_neirong.setOnClickListener(onClickListener);




    }
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
              switch (view.getId()){
                  case R.id.fatiezi_quxiao:
                      Intent intent=new Intent();
                      intent.setClass(FaTieActivity.this,ZhuanFaActivity.class);
                      startActivity(intent);

                      break;

                  case R.id.fatiezi_fasong:
                      Toast.makeText(FaTieActivity.this,"发送成功",Toast.LENGTH_SHORT).show();

                      break;

                  case R.id.fatie_tupian:

                      break;

                  case R.id.fatie_weizhi:
                      Intent intent1=new Intent();
                      intent1.setClass(FaTieActivity.this,ZhuanFaActivity.class);
                      startActivity(intent1);

                      break;

                  case R.id.fatie_neirong:
                      Toast.makeText(FaTieActivity.this,"帖子内容",Toast.LENGTH_SHORT).show();
                      fatie_neirong.setHint("");

                      break;


                  default:
                      break;


              };
        }
    };



}
