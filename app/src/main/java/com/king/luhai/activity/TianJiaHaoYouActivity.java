package com.king.luhai.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.king.luhai.R;

public class TianJiaHaoYouActivity extends Activity{

    ImageView xiai,xinlang,chazhao,tenxun;
    TextView tianjia_youback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tianjia_haoyou);

        xiai=(ImageView)findViewById(R.id.xiai);
        xinlang=(ImageView)findViewById(R.id.xinlang);
        chazhao=(ImageView)findViewById(R.id.chazhao);
        tenxun=(ImageView)findViewById(R.id.tenxun);
        tianjia_youback=(TextView)findViewById(R.id.tianjia_youback);

        xiai.setOnClickListener(onClickListener);
        xinlang.setOnClickListener(onClickListener);
        chazhao.setOnClickListener(onClickListener);
        tenxun.setOnClickListener(onClickListener);
        tianjia_youback.setOnClickListener(onClickListener);


    }

    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.tianjia_youback:
                    Intent intent=new Intent();
                    intent.setClass(TianJiaHaoYouActivity.this,WenTiFanKuiActivity.class);
                    startActivity(intent);

                    break;

                case R.id.xiai:
                    Intent intent1=new Intent();
                    intent1.setClass(TianJiaHaoYouActivity.this,WenTiFanKuiActivity.class);
                    startActivity(intent1);

                    break;

                case R.id.xinlang:
                    Intent intent2=new Intent();
                    intent2.setClass(TianJiaHaoYouActivity.this,WenTiFanKuiActivity.class);
                    startActivity(intent2);

                    break;

                case R.id.tenxun:
                    Intent intent3=new Intent();
                    intent3.setClass(TianJiaHaoYouActivity.this,WenTiFanKuiActivity.class);
                    startActivity(intent3);

                    break;

                case R.id.chazhao:
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
