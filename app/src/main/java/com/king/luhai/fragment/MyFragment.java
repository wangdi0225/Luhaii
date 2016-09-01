package com.king.luhai.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.king.luhai.R;
import com.king.luhai.activity.HomepageActivity;
import com.king.luhai.activity.JiFenShangChengActivity;
import com.king.luhai.activity.WoDeJiFenActivity;
import com.king.luhai.activity.WoDeTieZiActivity;
import com.king.luhai.activity.XiTongSheZheActivity;

import org.w3c.dom.Text;

/**
 * Created by Administrator on 2016/8/23.
 */
public class MyFragment extends Fragment {
    TextView qiandao;
    LinearLayout ismy,mytiezhi,myjifeng,mysystem;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.item_wode, container, false);
        qiandao=(TextView)v.findViewById(R.id.qiandao);
        ismy=(LinearLayout)v.findViewById(R.id.ismy);
        myjifeng=(LinearLayout)v.findViewById(R.id.jifeng);
        mytiezhi=(LinearLayout)v.findViewById(R.id.mytiezhi);
        mysystem=(LinearLayout)v.findViewById(R.id.xitongset);
        qiandao.setOnClickListener(onClickListener);
        ismy.setOnClickListener(onClickListener);
        myjifeng.setOnClickListener(onClickListener);
        mytiezhi.setOnClickListener(onClickListener);
        mysystem.setOnClickListener(onClickListener);





        return v;
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        Intent intent = new Intent();
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.qiandao:

                    break;
                case R.id.ismy:

                    break;
                case R.id.jifeng:
                    intent.setClass(getActivity(), JiFenShangChengActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                    break;
                case R.id.mytiezhi:
                    intent.setClass(getActivity(), WoDeTieZiActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                    break;
                case R.id.xitongset:
                    intent.setClass(getActivity(), XiTongSheZheActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                    break;
            }
        }
    };



    }
