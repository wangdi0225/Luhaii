package com.king.luhai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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
public class SigninActivity extends Activity {
    private ImageButton imageButton;
    private EditText editText;
    private Button button;
    private TextView textView;
    private String str1;
    private String phoneNums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tianxieshoujihao);
        dote();
    }

    private void dote() {
        imageButton = (ImageButton) findViewById(R.id.tianxieshoujihao_fanhui);
        editText = (EditText) findViewById(R.id.tianxieshoujihao_shouji);
        button = (Button) findViewById(R.id.tianxieshoujihao_xiayibu);
        textView = (TextView) findViewById(R.id.tianxieshoujihao_tongyi);
        imageButton.setOnClickListener(onClickListener);
        button.setOnClickListener(onClickListener);
        textView.setOnClickListener(onClickListener);
        phoneNums = editText.getText().toString();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            switch (view.getId()) {
                case R.id.tianxieshoujihao_fanhui:
                    intent.setClass(SigninActivity.this, LoginActivity.class);
                    startActivity(intent);
                    break;
                case R.id.tianxieshoujihao_xiayibu:

                        login();

                    break;
                case R.id.tianxieshoujihao_tongyi:
                    Toast.makeText(SigninActivity.this, "头像", Toast.LENGTH_SHORT).show();
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
                    String httpHost = "http://192.168.1.191/home/shouye/zhuce/numb";
                    String name =editText.getText().toString();
                    String urlName = httpHost + "/" + name;
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
                    Toast.makeText(SigninActivity.this,message, Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent();
                    intent.setClass(SigninActivity.this, VerifyActivity.class);
                    Bundle bundle1 = new Bundle();
                    str1 = editText.getText().toString();
                    bundle1.putString("shoujihao", str1);
                    intent.putExtra("data", bundle1);
                    startActivity(intent);
                    finish();
                }else if(status==400){
                    Toast.makeText(SigninActivity.this,message,Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }
        }
    };
    private boolean judgePhoneNums(String phoneNums) {
        if (isMatchLength(phoneNums, 11)
                && isMobileNO(phoneNums)) {
            return true;
        }
        Toast.makeText(this, "手机号码输入有误！", Toast.LENGTH_SHORT).show();
        return false;
    }

    public static boolean isMatchLength(String str, int length) {
        if (str.isEmpty()) {
            return false;
        } else {
            return str.length() == length ? true : false;
        }
    }

    public static boolean isMobileNO(String mobileNums) {
        /*
         * 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
         * 联通：130、131、132、152、155、156、185、186 电信：133、153、180、189、（1349卫通）
         * 总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
         */
        String telRegex = "[1][358]\\d{9}";// "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobileNums))
            return false;
        else
            return mobileNums.matches(telRegex);
    }
}
