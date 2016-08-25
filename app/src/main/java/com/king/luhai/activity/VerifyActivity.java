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
public class VerifyActivity extends Activity{
    private ImageButton imageButton;
    private TextView textViewsj,textViewcx,textViewbd;
    private EditText editText;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tianxieyanzhengma);
        dote();
    }
    private void dote(){
        imageButton= (ImageButton) findViewById(R.id.tianxieyanzhengma_fanhui);
        textViewcx= (TextView) findViewById(R.id.tianxieyanzhengma_chongxinfasong);
        textViewbd= (TextView) findViewById(R.id.tianxieyanzhengma_bangding);
        textViewsj= (TextView) findViewById(R.id.tianxieyanzhengma_shouji);
        editText= (EditText) findViewById(R.id.tianxieyanzhengma_duanxin);
        button= (Button) findViewById(R.id.tianxieyanzhengma_xiayibu);
        imageButton.setOnClickListener(onClickListener);
        Intent i=getIntent();
        Bundle b=new Bundle();
        b=i.getBundleExtra("data");
        textViewsj.setText(b.getString("shoujihao"));
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            switch (view.getId()) {
                case R.id.tianxieyanzhengma_fanhui:
                    intent.setClass(VerifyActivity.this, SigninActivity.class);
                    startActivity(intent);
                    break;
                case R.id.tianxieyanzhengma_xiayibu:
                    Toast.makeText(VerifyActivity.this, "头像", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.tianxieyanzhengma_chongxinfasong:
                    Toast.makeText(VerifyActivity.this, "头像", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    };
}
