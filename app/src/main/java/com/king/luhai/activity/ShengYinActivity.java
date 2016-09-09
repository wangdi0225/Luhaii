package com.king.luhai.activity;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.king.luhai.R;

/**
 * Created by Administrator on 2016-9-5.
 */
public class ShengYinActivity extends Activity {

    ImageView shengyin_zhendong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sound);

        shengyin_zhendong=(ImageView)findViewById(R.id.shengyin_zhendong);

        shengyin_zhendong.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.shengyin_zhendong:
                    Intent intent=new Intent();
                    intent.setClass(ShengYinActivity.this,TongYongSystemActivity.class);
                    startActivity(intent);

                    break;

                default:
                    break;

            };
        }
    };


}
