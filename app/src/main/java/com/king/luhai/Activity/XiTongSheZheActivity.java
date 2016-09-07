package com.king.luhai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.king.luhai.R;


public class XiTongSheZheActivity extends Activity {

   ImageView xitong_shezhi_back;

    LinearLayout zhanghaoGL_linearLayout,zhanghaosafe_linearLayout,tongyong_linearLayout,qinglihuancun_linearLayout,yinsi_systemlinearLayout,wentifankui_linearLayout,
            guanyuwomen_linearLayout,duichuzhanghao_linearLayout;

    TextView qinghuancun_textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xitongshezhi);

        zhanghaoGL_linearLayout=(LinearLayout) findViewById(R.id.zhanghaoGL_linearLayout);
        zhanghaosafe_linearLayout=(LinearLayout) findViewById(R.id.zhanghaosafe_linearLayout);
        tongyong_linearLayout=(LinearLayout) findViewById(R.id.tongyong_linearLayout);
        qinglihuancun_linearLayout=(LinearLayout) findViewById(R.id.qinglihuancun_linearLayout);
        yinsi_systemlinearLayout=(LinearLayout) findViewById(R.id.yinsi_systemlinearLayout);
        wentifankui_linearLayout=(LinearLayout) findViewById(R.id.wentifankui_linearLayout);
        guanyuwomen_linearLayout=(LinearLayout)findViewById(R.id.guanyuwomen_linearLayout);
        duichuzhanghao_linearLayout=(LinearLayout)findViewById(R.id.duichuzhanghao_linearLayout);


        qinghuancun_textView=(TextView)findViewById(R.id.qinghuancun_textView);
        xitong_shezhi_back=(ImageView)findViewById(R.id.xitong_shezhi_back);
        xitong_shezhi_back.setOnClickListener(listener);
<<<<<<< HEAD

        qinghuancun_textView.setOnClickListener(listener);


        zhanghaoGL_linearLayout.setOnClickListener(listener);
        zhanghaosafe_linearLayout.setOnClickListener(listener);
        tongyong_linearLayout.setOnClickListener(listener);
        qinglihuancun_linearLayout.setOnClickListener(listener);
        yinsi_systemlinearLayout.setOnClickListener(listener);
        wentifankui_linearLayout.setOnClickListener(listener);
        guanyuwomen_linearLayout.setOnClickListener(listener);
        duichuzhanghao_linearLayout.setOnClickListener(listener);


=======
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
>>>>>>> 0273d0cab9ee770000b64dc3f08158f8edd2feb5
    }
    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view){
            switch (view.getId()){
                case R.id.xitong_shezhi_back:
                    Intent intent=new Intent();
                    intent.setClass(XiTongSheZheActivity.this,HomepageActivity.class);
                    startActivity(intent);

                    break;

                case R.id.zhanghaoGL_linearLayout:
                    Intent intent2=new Intent();
                    intent2.setClass(XiTongSheZheActivity.this,ZHGuanLi.class);
                    startActivity(intent2);

                    break;

                case R.id.zhanghaosafe_linearLayout:
                    Intent intent3=new Intent();
                    intent3.setClass(XiTongSheZheActivity.this,ZhangHaoSafeActivity.class);
                    startActivity(intent3);

                    break;

                case R.id.tongyong_linearLayout:
                    Intent intent4=new Intent();
                    intent4.setClass(XiTongSheZheActivity.this,TongYongSystemActivity.class);
                    startActivity(intent4);

                    break;

                case R.id.qinglihuancun_linearLayout:
                    Intent intent5=new Intent();
                    intent5.setClass(XiTongSheZheActivity.this,HomepageActivity.class);
                    startActivity(intent5);

                    break;

                case R.id.yinsi_systemlinearLayout:
                    Intent intent6=new Intent();
                    intent6.setClass(XiTongSheZheActivity.this,YinSiSheZhiActivity.class);
                    startActivity(intent6);

                    break;

                case R.id.wentifankui_linearLayout:
                    Intent intent7=new Intent();
                    intent7.setClass(XiTongSheZheActivity.this,WenTiFanKuiActivity.class);
                    startActivity(intent7);

                    break;

                case R.id.guanyuwomen_linearLayout:
                    Intent intent8=new Intent();
                    intent8.setClass(XiTongSheZheActivity.this,GuanYuWoMenActivity.class);
                    startActivity(intent8);

                    break;

                case R.id.duichuzhanghao_linearLayout:
                    Intent intent9=new Intent();
                    intent9.setClass(XiTongSheZheActivity.this,LoginActivity.class);
                    startActivity(intent9);

                    break;


                default:
                    break;
            };

        }
    };



}
