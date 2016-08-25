package com.king.luhai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.king.luhai.R;

/**
 * Created by Administrator on 2016/8/23.
 */
public class SigninActivity extends Activity {
    private ImageButton imageButton;
    private EditText editText;
    private Button button;
    private TextView textView;
    private String str;
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
                   intent.setClass(SigninActivity.this,VerifyActivity.class);
                    Bundle bundle=new Bundle();
                    str=editText.getText().toString();
                    bundle.putString("shoujihao",str);
                    intent.putExtra("data",bundle);
                    startActivity(intent);
                    break;
                case R.id.tianxieshoujihao_tongyi:
                    Toast.makeText(SigninActivity.this, "头像", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    };
}
