package com.king.luhai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.king.luhai.R;


public class XiTongSheZheActivity extends Activity {

    ImageView guanlihao_imageView,anquanhao_imageView,tongyong_imageView,shezhi_yinsi,fankuai_imageView,
                 guanyu_women,tuichu_imageView,xitong_shezhi_back;
    TextView qinghuancun_textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xitongshezhi);

        guanlihao_imageView=(ImageView)findViewById(R.id.guanlihao_imageView);
        anquanhao_imageView=(ImageView)findViewById(R.id.anquanhao_imageView);
        tongyong_imageView=(ImageView)findViewById(R.id.tongyong_imageView);

        shezhi_yinsi=(ImageView)findViewById(R.id.shezhi_yinsi);
        fankuai_imageView=(ImageView)findViewById(R.id.fankuai_imageView);
        guanyu_women=(ImageView)findViewById(R.id.guanyu_women);
        tuichu_imageView=(ImageView)findViewById(R.id.tuichu_imageView);

        qinghuancun_textView=(TextView)findViewById(R.id.qinghuancun_textView);

        xitong_shezhi_back=(ImageView)findViewById(R.id.xitong_shezhi_back);
        xitong_shezhi_back.setOnClickListener(listener);


        qinghuancun_textView.setOnClickListener(listener);

        guanlihao_imageView.setOnClickListener(listener);
        anquanhao_imageView.setOnClickListener(listener);
        tongyong_imageView.setOnClickListener(listener);

        shezhi_yinsi.setOnClickListener(listener);
        fankuai_imageView.setOnClickListener(listener);
        guanyu_women.setOnClickListener(listener);
        tuichu_imageView.setOnClickListener(listener);




    }

    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view){
            switch (view.getId()){
                case R.id.guanyu_women:
                    Intent intent=new Intent();
                    intent.setClass(XiTongSheZheActivity.this,GuanYuWoMenActivity.class);
                    startActivity(intent);

                    break;

                case R.id.xitong_shezhi_back:
                    Intent intent2=new Intent();
                    intent2.setClass(XiTongSheZheActivity.this,HomepageActivity.class);
                    startActivity(intent2);

                    break;

                default:
                    break;
            };

        }
    };



}
