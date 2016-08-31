package com.king.luhai.activity;

import android.app.Activity;
import android.content.Entity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.king.luhai.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ChartActivity extends Activity implements View.OnClickListener {

    List<Map<String,Object>> lists=new ArrayList<Map<String,Object>>();
    ListView users_listView;

    TextView users_back,users_liaotian;

    ImageView users_shuohua,users_biaoqing,users_tianjia;

    EditText users_edit;

    Entity entity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users);
        //键盘不自动出来
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        initView();
        initData();
    }





    public void initView(){
        users_listView=(ListView)findViewById(R.id.users_listView);
        users_back=(TextView)findViewById(R.id.users_back);
        users_liaotian=(TextView)findViewById(R.id.users_liaotian);

        users_shuohua=(ImageView)this.findViewById(R.id.users_shuohua);

        users_biaoqing=(ImageView)findViewById(R.id.users_biaoqing);
        users_tianjia=(ImageView)findViewById(R.id.users_tianjia);

        users_edit=(EditText)findViewById(R.id.users_edit);

        users_back.setOnClickListener(this);
        users_shuohua.setOnClickListener(this);


    };

    public void initData(){

    };




    @Override
    public void onClick(View view) {
             switch (view.getId()){
                 case R.id.users_back:

                 break;



             };
    }
}
