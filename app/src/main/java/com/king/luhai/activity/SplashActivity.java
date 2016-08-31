package com.king.luhai.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.king.luhai.R;
import com.king.luhai.product.Guide;

/**
 * 
 * @{# SplashActivity.java Create on 2013-5-2 下午9:10:01
 * 
 *     class desc: 启动画面 (1)判断是否是首次加载应用--采取读取SharedPreferences的方法
 *     (2)是，则进入GuideActivity；否，则进入MainActivity (3)3s后执行(2)操作
 * 
 *     <p>
 *     Copyright: Copyright(c) 2013
 *     </p>
 * @Version 1.0
 * @Author <a href="mailto:gaolei_xj@163.com">Leo</a>
 * 
 * 
 */
public class SplashActivity extends Activity {
	private boolean isFirstIn = false;
	private static final int TIME = 2000;
	private static final int GO_HOME = 1000;
	private static final int GO_GUIDE = 1001;


	private Handler mHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what){
				case GO_HOME:
					goHome();
				//goGuide();
					break;
				case GO_GUIDE:
					//goGuide();
					goHome();
					break;


			}

		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		init();
	}

	private void init(){
		SharedPreferences perPreferences = getSharedPreferences("jike", MODE_PRIVATE);
		isFirstIn = perPreferences.getBoolean("isFirstIn", true);
		if (!isFirstIn) {
			mHandler.sendEmptyMessageDelayed(GO_HOME, TIME);
		}else{
			mHandler.sendEmptyMessageDelayed(GO_GUIDE, TIME);
			SharedPreferences.Editor editor = perPreferences.edit();
			editor.putBoolean("isFirstIn", false);
			editor.commit();
		}

	}

	private void goHome(){
		Intent i = new Intent(SplashActivity.this,LoginActivity.class);
		startActivity(i);
		finish();
	}
	private void goGuide(){
		Intent i = new Intent(SplashActivity.this,YingdaoyeActivity.class);
		startActivity(i);
		finish();
	}
}
