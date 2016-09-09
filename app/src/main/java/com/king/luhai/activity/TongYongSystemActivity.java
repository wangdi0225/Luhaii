package com.king.luhai.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.king.luhai.R;


public class TongYongSystemActivity extends Activity {
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    ImageView tongyongsystem_back;
    LinearLayout ziti_system_linearLayout,beizhu_systemLinearLayout,kuaisu_linearLayout,zidonghuan_linearLayout,
                 shengdong_linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tongyong_shezhi);

        sp=getSharedPreferences("set",MODE_PRIVATE);
        editor=sp.edit();

        tongyongsystem_back=(ImageView)findViewById(R.id.tongyongsystem_back);

        boolean iskai=sp.getBoolean("iskai",false);

        ziti_system_linearLayout=(LinearLayout)findViewById(R.id.ziti_system_linearLayout);
        beizhu_systemLinearLayout=(LinearLayout)findViewById(R.id.beizhu_systemLinearLayout);
        kuaisu_linearLayout=(LinearLayout)findViewById(R.id.kuaisu_linearLayout);
        zidonghuan_linearLayout=(LinearLayout)findViewById(R.id.zidonghuan_linearLayout);
        shengdong_linearLayout=(LinearLayout)findViewById(R.id.shengdong_linearLayout);

        tongyongsystem_back.setOnClickListener(onClickListener);
        ziti_system_linearLayout.setOnClickListener(onClickListener);
        beizhu_systemLinearLayout.setOnClickListener(onClickListener);
        kuaisu_linearLayout.setOnClickListener(onClickListener);
        zidonghuan_linearLayout.setOnClickListener(onClickListener);
        shengdong_linearLayout.setOnClickListener(onClickListener);


        if(iskai){
            beizhu_systemLinearLayout.setClickable(true);
        }
        else {
            beizhu_systemLinearLayout.setClickable(false);
        }
    }



    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                 switch (view.getId()){
                     case R.id.tongyongsystem_back:
                         Intent intent=new Intent();
                         intent.setClass(TongYongSystemActivity.this,XiTongSheZheActivity.class);
                         startActivity(intent);

                         break;

                     case R.id.ziti_system_linearLayout:


                         break;

                     case R.id.beizhu_systemLinearLayout:
                        if (beizhu_systemLinearLayout.isClickable()){
                            Toast.makeText(TongYongSystemActivity.this,"开",Toast.LENGTH_SHORT).show();
                        }
                         else {
                            Toast.makeText(TongYongSystemActivity.this,"关",Toast.LENGTH_SHORT).show();
                        }
                        editor.putBoolean("iskai",false);



                         break;

                     case R.id.kuaisu_linearLayout:

                         break;

                     case R.id.zidonghuan_linearLayout:

                         break;

                     case R.id.shengdong_linearLayout:
                         Intent intent1=new Intent(TongYongSystemActivity.this,ShengYinActivity.class);
                         startActivity(intent1);

                         break;

                     default:
                         break;

                 };
        }
    };
}
