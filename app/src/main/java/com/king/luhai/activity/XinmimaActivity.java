package com.king.luhai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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
 * Created by Administrator on 2016/8/31.
 */
public class XinmimaActivity extends Activity{
    private ImageButton imageButton;
    private EditText editTextmm1,editTextmm2;
    private Button buttonxyb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xinmima);
        date();
    }
    String a;
    String c;
    public void date(){
        imageButton= (ImageButton) findViewById(R.id.xinmima_fanhui);
        editTextmm1= (EditText) findViewById(R.id.xinmima_mima);
        editTextmm2= (EditText) findViewById(R.id.xinmima_mima2);
        buttonxyb= (Button) findViewById(R.id.xinmima_xiayibu);
        imageButton.setOnClickListener(onClickListener);
        buttonxyb.setOnClickListener(onClickListener);
        a=editTextmm1.getText().toString();
        c=editTextmm2.getText().toString();
    }
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent();
            switch (view.getId()){
                case R.id.xinmima_fanhui:
                    intent.setClass(XinmimaActivity.this,WangjimimaActivity.class);
                    startActivity(intent);
                break;
                case R.id.xinmima_xiayibu:
                    login();

                    break;
            }
        }
    };
    String str;
    String name;
    public void login() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                StringBuilder builder = new StringBuilder();
                try {
                    String httpHost = "http://192.168.1.191/home/shouye/savapass/numb";
                    Intent i = getIntent();
                    Bundle b = new Bundle();
                    b = i.getBundleExtra("data1");
                    String shouji=b.getString("shoujihao1");
                    if(a.equals(c)){
                         name =editTextmm2.getText().toString();
                    }else {
                        Toast.makeText(XinmimaActivity.this,"两次密码不一致",Toast.LENGTH_SHORT).show();
                    }
                    String urlName = httpHost + "/"+ shouji+"/pass/"+ name;
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
                    Toast.makeText(XinmimaActivity.this,message, Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent();
                    intent.setClass(XinmimaActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }else if(status==400){
                    Toast.makeText(XinmimaActivity.this,message,Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }
        }
    };
}
