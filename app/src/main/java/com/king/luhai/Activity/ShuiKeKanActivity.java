package com.king.luhai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.king.luhai.R;


public class ShuiKeKanActivity extends Activity implements AdapterView.OnItemClickListener {

    ImageView sheikan_back;
    TextView kekan_wancheng;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sheikeyikan);

        sheikan_back=(ImageView)findViewById(R.id.sheikan_back);
        kekan_wancheng=(TextView)findViewById(R.id.kekan_wancheng);

        sheikan_back.setOnClickListener(onClickListener);
        kekan_wancheng.setOnClickListener(onClickListener);

    }

View.OnClickListener onClickListener=new View.OnClickListener() {
    @Override
    public void onClick(View view) {
          switch (view.getId()){
              case R.id.sheikan_back:
                  Intent intent=new Intent();
                  intent.setClass(ShuiKeKanActivity.this,WenTiFanKuiActivity.class);
                  startActivity(intent);

                  break;

              case R.id.kekan_wancheng:
                  Intent intent1=new Intent();
                  intent1.setClass(ShuiKeKanActivity.this,WenTiFanKuiActivity.class);
                  startActivity(intent1);

                  break;

              default:
                  break;


          };
    }
};


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
