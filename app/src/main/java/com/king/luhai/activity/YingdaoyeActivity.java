package com.king.luhai.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

import com.king.luhai.R;

/**
 * Created by Administrator on 2016/8/27.
 */
public class YingdaoyeActivity extends Activity{
    private ViewFlipper viewFlipper;
    private Button button;
    private GestureDetector mGestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yingdaoye);
      //  mGestureDetector = new GestureDetector(onGestureListener);
       // viewFlipper= (ViewFlipper) findViewById(R.id.yingdaoye_viewflipper);
    }
    public void setButton(){
        button= (Button) findViewById(R.id.start_btn);
        button.setVisibility(View.VISIBLE);
        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent=new Intent();
                intent.setClass(YingdaoyeActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    GestureDetector.OnGestureListener onGestureListener = new GestureDetector.OnGestureListener() {

        @Override
        public boolean onDown(MotionEvent e) {
            // TODO Auto-generated method stub
            return true;
        }

        @SuppressLint("NewApi")
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {
            // TODO Auto-generated method stub
            if (e1.getX() - e2.getX() > 20) {
                viewFlipper.showNext();
            } else if (e2.getX() - e1.getX() > 20) {
                viewFlipper.showPrevious();
            }else if(viewFlipper.getDisplayedChild() == viewFlipper.getChildCount() - 1){
                setButton();
            }
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                float distanceX, float distanceY) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            // TODO Auto-generated method stub
            return false;
        }
    };
}
