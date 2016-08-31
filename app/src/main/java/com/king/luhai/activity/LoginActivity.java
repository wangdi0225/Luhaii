package com.king.luhai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.king.luhai.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

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
                    login();
                  //  buttondl.performClick();

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
    String str;
    public void login() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                StringBuilder builder = new StringBuilder();
                try {
                    String httpHost = "http://192.168.1.191/home/shouye/denglu/numb";
                    String name =editTextzh.getText().toString();
                    String mima=editTextmm.getText().toString();
                    String urlName = httpHost + "/" + name+"/pass/"+mima;
                    URL url = new URL(urlName);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setConnectTimeout(5000);
                    connection.setRequestProperty("accept", "*/*");// 设置客户端接受那些类型的信息，通配符代表接收所有类型的数据
                    connection.setRequestProperty("connection", "Keep-Alive");// 保持长链接
                    connection
                            .setRequestProperty("user-agent",
                                    "Mozilla/4.0(compatible;MSIE 6.0;Windows NT5.1;SV1)");// 设置浏览器代理
                    connection
                            .setRequestProperty("accept-charset", "utf-8;GBK");// 客户端接受的字符集
                    connection.connect();// 建立连接
                    InputStream inputStream = connection.getInputStream();
                    Map<String, List<String>> headers = connection
                            .getHeaderFields();
                    for (String key : headers.keySet()) {
                        System.out.println(key + "----" + headers.get(key));
                    }
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String line = bufferedReader.readLine();
                    while (line != null && line.length() > 0) {
                        builder.append(line);
                        line = bufferedReader.readLine();
                    }
                    bufferedReader.close();
                    inputStream.close();
                    Log.i("builder-----", builder.toString());
                    str = builder.toString();
                    myHandler.sendEmptyMessage(0);

                } catch (MalformedURLException e) {
                    // TODO 自动生成的 catch 块
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO 自动生成的 catch 块
                    e.printStackTrace();
                }
            }
        }).start();
    }
    int status;
    String message;
    Handler myHandler = new Handler() {
        public void handleMessage(Message msg) {
            try {
                JSONObject jsonObject = new JSONObject(str);
                Bundle bundle = new Bundle();
                status = jsonObject.getInt("code");
                Log.i("code", "" + status);
                message = jsonObject.getString("message");
                Log.i("message", "" + message);
                if(status==200) {
                    createProgressBar();
                    Toast.makeText(LoginActivity.this,message, Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent();
                    intent.setClass(LoginActivity.this, HomepageActivity.class);
                    startActivity(intent);
                    finish();
                }else if(status==400){
                    Toast.makeText(LoginActivity.this,message,Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }
        }
    };
    private void createProgressBar() {
        FrameLayout layout = (FrameLayout) findViewById(android.R.id.content);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        ProgressBar mProBar = new ProgressBar(this);
        mProBar.setLayoutParams(layoutParams);
        mProBar.setVisibility(View.VISIBLE);
        layout.addView(mProBar);
    }
}
