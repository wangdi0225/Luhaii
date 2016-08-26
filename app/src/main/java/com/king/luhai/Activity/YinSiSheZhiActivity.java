package com.king.luhai.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.king.luhai.R;


public class YinSiSheZhiActivity extends Activity {

    ImageView jiawo_yanzheng,wotuijian,sousuowo,heimingdan,bukan_right,
                yinsi_shezhi_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yinsi_shezhi);

        jiawo_yanzheng=(ImageView)findViewById(R.id.jiawo_yanzheng);
        wotuijian=(ImageView)findViewById(R.id.wotuijian);
        sousuowo=(ImageView)findViewById(R.id.sousuowo);

        heimingdan=(ImageView)findViewById(R.id.heimingdan);
        bukan_right=(ImageView)findViewById(R.id.bukan_right);
        yinsi_shezhi_back=(ImageView)findViewById(R.id.yinsi_shezhi_back);

        jiawo_yanzheng.setOnClickListener(listener);
        wotuijian.setOnClickListener(listener);
        sousuowo.setOnClickListener(listener);
        heimingdan.setOnClickListener(listener);
        bukan_right.setOnClickListener(listener);
        yinsi_shezhi_back.setOnClickListener(listener);

    }
    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view){

        }
    };


}
