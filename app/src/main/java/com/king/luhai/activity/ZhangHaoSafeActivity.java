package com.king.luhai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.king.luhai.R;


public class ZhangHaoSafeActivity extends Activity {
    ImageView Haosafe_back;
    LinearLayout dengluming_linearLayout,youxiang_linearLayout,shoujihao_linearLayout,xiugaiMima_linearLayout,safeCenter_linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhuanghao_safe);

        Haosafe_back=(ImageView)findViewById(R.id.Haosafe_back);

        dengluming_linearLayout=(LinearLayout)findViewById(R.id.dengluming_linearLayout);
        youxiang_linearLayout=(LinearLayout)findViewById(R.id.youxiang_linearLayout);
        shoujihao_linearLayout=(LinearLayout)findViewById(R.id.shoujihao_linearLayout);
        xiugaiMima_linearLayout=(LinearLayout)findViewById(R.id.xiugaiMima_linearLayout);
        safeCenter_linearLayout=(LinearLayout)findViewById(R.id.safeCenter_linearLayout);

        Haosafe_back.setOnClickListener(onClickListener);
        dengluming_linearLayout.setOnClickListener(onClickListener);
        youxiang_linearLayout.setOnClickListener(onClickListener);
        shoujihao_linearLayout.setOnClickListener(onClickListener);
        xiugaiMima_linearLayout.setOnClickListener(onClickListener);
        safeCenter_linearLayout.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                switch (view.getId()){
                    case R.id.Haosafe_back:
                        Intent intent=new Intent();
                        intent.setClass(ZhangHaoSafeActivity.this,XiTongSheZheActivity.class);
                        startActivity(intent);

                        break;

                    case R.id.dengluming_linearLayout:

                        break;

                    case R.id.youxiang_linearLayout:

                        break;

                    case R.id.shoujihao_linearLayout:

                        break;

                    case R.id.xiugaiMima_linearLayout:

                        break;

                    case R.id.safeCenter_linearLayout:

                        break;

                    default:
                        break;



                };
        }
    };

}
