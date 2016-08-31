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

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

/**
 * Created by Administrator on 2016/8/31.
 */
public class WangjimimaActivity extends Activity{
    private ImageButton imageButton;
    private EditText editTextsj,editTextyz;
    private Button buttonyz,buttonxyb;
    private static String APPKEY = "1690cff1865c8";
    private static String APPSECRET = "1b639e1a66d08c8dc47ddbe43f362eb7";
    private static final int CODE_ING = 1;   //已发送，倒计时
    private static final int CODE_REPEAT = 2;  //重新发送
    private static final int SMSDDK_HANDLER = 3;  //短信回调
    private int TIME = 60;
    private String userphone;
    private EventHandler eventHandler = new MyHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wangjimima);
        date();
    }
    public void date(){
        imageButton= (ImageButton) findViewById(R.id.wangjimima_fanhui);
        editTextsj= (EditText) findViewById(R.id.wangjimima_shouji);
        editTextyz= (EditText) findViewById(R.id.wangjimima_duanxin);
        buttonyz= (Button) findViewById(R.id.wangjimima_huoqu);
        buttonxyb= (Button) findViewById(R.id.wangjimima_xiayibu);
        imageButton.setOnClickListener(onClickListener);
        buttonyz.setOnClickListener(onClickListener);
        buttonxyb.setOnClickListener(onClickListener);
        SMSSDK.initSDK(this, APPKEY, APPSECRET);
        SMSSDK.registerEventHandler(eventHandler);
        phoneNums=editTextsj.getText().toString();

    }
    private class MyHandler extends EventHandler {
        @Override
        public void onRegister() {
            super.onRegister();
        }

        @Override
        public void beforeEvent(int event, Object data) {
            super.beforeEvent(event, data);
        }

        @Override
        public void afterEvent(int event, int result, Object data) {
            Message msg = new Message();
            msg.arg1 = event;
            msg.arg2 = result;
            msg.obj = data;
            handler.sendMessage(msg);

            super.afterEvent(event, result, data);
        }

        @Override
        public void onUnregister() {
            super.onUnregister();
        }
    }

    String phoneNums;
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent =new Intent();
            switch (view.getId()){
                case R.id.wangjimima_fanhui:
                    intent.setClass(WangjimimaActivity.this,LoginActivity.class);
                    startActivity(intent);
                    break;
                case R.id.wangjimima_huoqu:

              // 2. 通过sdk发送短信验证
                    SMSSDK.getVerificationCode("86", phoneNums);

                    // 3. 把按钮变成不可点击，并且显示倒计时（正在获取）
                    buttonyz.setClickable(false);
                    buttonyz.setText("重新发送(" + TIME + ")");
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            for (; TIME > 0; TIME--) {
                                handler.sendEmptyMessage(-9);
                                if (TIME <= 0) {
                                    break;
                                }
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            handler.sendEmptyMessage(-8);
                        }
                    }).start();
                    break;
                case R.id.wangjimima_xiayibu:
                   login();
                    break;
            }
        }
    };
    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == -9) {
                buttonyz.setText("重新发送(" + TIME + ")");
            } else if (msg.what == -8) {
                buttonyz.setText("获取验证码");
                buttonyz.setClickable(true);
                TIME = 60;
            } else {
                int event = msg.arg1;
                int result = msg.arg2;
                Object data = msg.obj;
                Log.e("event", "event=" + event);
                if (result == SMSSDK.RESULT_COMPLETE) {
                    // 短信注册成功后，返回下一个界面,然后提示
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {// 提交验证码成功
                        Toast.makeText(getApplicationContext(), "验证成功",
                                Toast.LENGTH_SHORT).show();//消息提示

                        Intent intent = new Intent(WangjimimaActivity.this,
                                XinmimaActivity.class)    ;//跳转activity
                        intent.putExtra("phone", editTextsj.getText().toString());//将phone值放进phone里以便传送至下一个activity中
                        startActivity(intent);
                        finish();//设置无法返回本界面
                    } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                        Toast.makeText(getApplicationContext(), "验证码已经发送",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        ((Throwable) data).printStackTrace();
                    }
                }
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
                    String httpHost = "http://192.168.1.191/home/shouye/wangji/numb";
                    String name =editTextsj.getText().toString();
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
    String str1;
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
                    Toast.makeText(WangjimimaActivity.this,message, Toast.LENGTH_SHORT).show();
                    //SMSSDK.submitVerificationCode("86", phoneNums, editTextyz.getText().toString());
                    Intent intent=new Intent();
                    intent.setClass(WangjimimaActivity.this,XinmimaActivity.class);
                    Bundle bundle1=new Bundle();
                    str1 = editTextsj.getText().toString();
                    bundle1.putString("shoujihao1", str1);
                    intent.putExtra("data1", bundle1);
                    startActivity(intent);
                    finish();
                }else if(status==400){
                    Toast.makeText(WangjimimaActivity.this,message,Toast.LENGTH_SHORT).show();
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
