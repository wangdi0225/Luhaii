package com.king.luhai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.king.luhai.R;

/**
 * Created by Administrator on 2016/8/23.
 */
public class LoginActivity extends Activity{
    private ImageButton imageButtontx;
    private EditText editTextzh,editTextmm;
    private Button buttondl,buttonzc;
    private CheckBox checkBox;
    private TextView textViewwjmm,textViewqq,textViewwb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        dote();
    }
    private void dote(){
        imageButtontx= (ImageButton) findViewById(R.id.denglu_touxiang);
        editTextzh= (EditText) findViewById(R.id.denglu_zhanghao);
        editTextmm= (EditText) findViewById(R.id.denglu_mima);
        buttondl= (Button) findViewById(R.id.denglu_denglu);
        buttonzc= (Button) findViewById(R.id.denglu_zhuche);
        checkBox= (CheckBox) findViewById(R.id.denglu_jizhumima);
        textViewwjmm= (TextView) findViewById(R.id.denglu_wangjimima);
        textViewqq= (TextView) findViewById(R.id.denglu_qqdenglu);
        textViewwb= (TextView) findViewById(R.id.denglu_weibodenglu);
        imageButtontx.setOnClickListener(onClickListener);
        buttondl.setOnClickListener(onClickListener);
        buttonzc.setOnClickListener(onClickListener);
        checkBox.setOnClickListener(onClickListener);
        textViewwjmm.setOnClickListener(onClickListener);
        textViewqq.setOnClickListener(onClickListener);
        textViewwb.setOnClickListener(onClickListener);
    }
    View.OnClickListener onClickListener=new View.OnClickListener() {
        Intent intent=new Intent();
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.denglu_touxiang:
                    Toast.makeText(LoginActivity.this,"头像",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.denglu_denglu:
                    Toast.makeText(LoginActivity.this,"头像",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.denglu_zhuche:
                   intent.setClass(LoginActivity.this,SigninActivity.class);
                    startActivity(intent);
                    break;
                case R.id.denglu_jizhumima:
                    Toast.makeText(LoginActivity.this,"头像",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.denglu_wangjimima:
                    Toast.makeText(LoginActivity.this,"头像",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.denglu_qqdenglu:
                    Toast.makeText(LoginActivity.this,"头像",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.denglu_weibodenglu:
                    Toast.makeText(LoginActivity.this,"头像",Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    };

}
