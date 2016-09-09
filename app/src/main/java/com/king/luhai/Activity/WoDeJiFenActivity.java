package com.king.luhai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.king.luhai.R;


public class WoDeJiFenActivity extends Activity {

    ImageView wode_jifen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wode_jifen);

        wode_jifen=(ImageView)findViewById(R.id.wode_jifen);


        wode_jifen.setOnClickListener(listener);


    }

    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.wode_jifen:
                    Intent intent=new Intent();
                    intent.setClass(WoDeJiFenActivity.this,JiFenShangChengActivity.class);
                    startActivity(intent);

                    break;

                default:
                    break;


            };
        }
    };
}
