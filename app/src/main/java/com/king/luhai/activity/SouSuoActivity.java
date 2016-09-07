package com.king.luhai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.king.luhai.R;

public class SouSuoActivity extends Activity {
    EditText sousuokuang;
    TextView sousuoitem_quxiao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sousuo_item);

        sousuokuang=(EditText)findViewById(R.id.sousuokuang);
        sousuoitem_quxiao=(TextView)findViewById(R.id.sousuoitem_quxiao);

        sousuokuang.setOnClickListener(listener);
        sousuoitem_quxiao.setOnClickListener(listener);


    }


    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                switch (view.getId()){
                    case R.id.sousuokuang:
                        Toast.makeText(SouSuoActivity.this,"去哪儿",Toast.LENGTH_SHORT).show();


                        break;

                    case R.id.sousuoitem_quxiao:
                        Intent intent=new Intent();
                        intent.setClass(SouSuoActivity.this,WeiZhiActivity.class);
                        startActivity(intent);

                        break;


                    default:
                        break;

                };
        }
    };
}
