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


public class TiJiaoYanZhengMaActivity extends Activity {

    ImageView tianyanma_back;
    EditText yanzheng_shuru;
    TextView yanzheng_tijiao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tianxieshoujima);

        tianyanma_back=(ImageView)findViewById(R.id.tianyanma_back);
        yanzheng_shuru=(EditText)findViewById(R.id.yanzheng_shuru);
        yanzheng_tijiao=(TextView)findViewById(R.id.yanzheng_tijiao);

        tianyanma_back.setOnClickListener(onClickListener);
        yanzheng_shuru.setOnClickListener(onClickListener);
        yanzheng_tijiao.setOnClickListener(onClickListener);


    }

    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.tianyanma_back:
                    Intent intent=new Intent();
                    intent.setClass(TiJiaoYanZhengMaActivity.this,ZhuanFaActivity.class);
                    startActivity(intent);

                    break;

                default:
                    break;

                case R.id.yanzheng_shuru:

                case R.id.yanzheng_tijiao:
                    String edyam=yanzheng_shuru.getText().toString();
                    if(edyam.equals("d2d3s")) {
                        Toast.makeText(TiJiaoYanZhengMaActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(TiJiaoYanZhengMaActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
                    }
                    break;

            };

        }
    };
}
