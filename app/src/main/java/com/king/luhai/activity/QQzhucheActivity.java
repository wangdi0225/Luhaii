package com.king.luhai.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.king.luhai.R;

/**
 * Created by Administrator on 2016/8/25.
 */
public class QQzhucheActivity extends Activity{
    private ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qqzhuce);
        imageButton= (ImageButton) findViewById(R.id.qqzhuche_fanhui);
    }
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          //  switch (view.getId()){
               // case R.id.qqzhuche_fanhui:
                  //  Intent  intent=new Intent();
                    //intent.setClass(QQzhucheActivity.this,)
            //}
        }
    };
}
