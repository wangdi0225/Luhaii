package com.king.luhai.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.king.luhai.R;

import org.w3c.dom.Text;


public class NumbSafeActivity extends Activity {

    ImageView Haosafe_back;
    TextView zhanghao_ming,bangding_youxiang,shoujihao,mimaxiugai,safe_center;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhuanghao_safe);

        Haosafe_back=(ImageView)findViewById(R.id.Haosafe_back);

        zhanghao_ming=(TextView)findViewById(R.id.zhanghao_ming);
        bangding_youxiang=(TextView)findViewById(R.id.bangding_youxiang);
        shoujihao=(TextView)findViewById(R.id.shoujihao);
        mimaxiugai=(TextView)findViewById(R.id.mimaxiugai);
        safe_center=(TextView)findViewById(R.id.safe_center);


        Haosafe_back.setOnClickListener(onClickListener);
        zhanghao_ming.setOnClickListener(onClickListener);
        bangding_youxiang.setOnClickListener(onClickListener);
        shoujihao.setOnClickListener(onClickListener);
        mimaxiugai.setOnClickListener(onClickListener);
        safe_center.setOnClickListener(onClickListener);



    }

    View.OnClickListener onClickListener=new View.OnClickListener(){

        public void onClick(View view){
               switch (view.getId()){
                   case R.id.Haosafe_back:
                       Intent intent=new Intent();
                       intent.setClass(NumbSafeActivity.this,ZhuanFaActivity.class);
                       startActivity(intent);

                       break;

                   case R.id.zhanghao_ming:


                   default:
                       break;

               };

        };


    };




}

