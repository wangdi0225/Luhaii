package com.king.luhai.activity;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.king.luhai.R;

/**
 * Created by Administrator on 2016-9-2.
 */
public class WeiZhiActivity extends Activity {

    ImageView dingwei_back,weizhi_sousuo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suozaiweizhi);

        dingwei_back=(ImageView)findViewById(R.id.dingwei_back);
        weizhi_sousuo=(ImageView)findViewById(R.id.weizhi_sousuo);


        dingwei_back.setOnClickListener(onClickListener);
        weizhi_sousuo.setOnClickListener(onClickListener);


    }


    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
              switch (view.getId()){

                  case R.id.dingwei_back:
                      Intent intent=new Intent();
                      intent.setClass(WeiZhiActivity.this,WenTiFanKuiActivity.class);
                      startActivity(intent);

                      break;

                  case R.id.weizhi_sousuo:
                      Intent intent1=new Intent();
                      intent1.setClass(WeiZhiActivity.this,SouSuoActivity.class);
                      startActivity(intent1);

                      break;

                  default:
                      break;


              };
        }
    };
}
