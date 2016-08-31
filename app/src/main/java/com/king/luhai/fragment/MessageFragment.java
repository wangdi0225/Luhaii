package com.king.luhai.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.king.luhai.fragment.HaoyouFragment;
import com.king.luhai.fragment.XiaoxiFragment;
import com.king.luhai.R;

/**
 * Created by Administrator on 2016/8/23.
 */
public class MessageFragment extends Fragment {
    TextView tabhaoyou;
    TextView tabxiaoxi;
    HaoyouFragment haoyou;
    XiaoxiFragment xiaoxi;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.item_message, container, false);
        tabhaoyou=(TextView)v.findViewById(R.id.haoyou);
        tabxiaoxi=(TextView)v.findViewById(R.id.xiaoxi);
        tabhaoyou.setOnClickListener(onClickListener);
        tabxiaoxi.setOnClickListener(onClickListener);
        setDefaultFragment();
        return v;
    }
    private void setDefaultFragment(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        haoyou= new HaoyouFragment();
        transaction.replace(R.id.fragment,haoyou);
        transaction.commit();

    }

        View.OnClickListener onClickListener =new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm =getFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                switch (v.getId()){
                    case R.id.haoyou:
                        if (haoyou==null){
                            haoyou = new HaoyouFragment();
                        }
                        transaction.replace(R.id.fragment,haoyou);
                        tabhaoyou.setBackgroundResource(R.drawable.haoyouyuan);
                        tabxiaoxi.setBackgroundResource(R.color.black);

                        break;
                    case R.id.xiaoxi:
                        if (xiaoxi==null){
                            xiaoxi = new XiaoxiFragment();
                        }
                        transaction.replace(R.id.fragment,xiaoxi);
                        tabxiaoxi.setBackgroundResource(R.drawable.xiaoxiyuan);
                        tabhaoyou.setBackgroundResource(R.color.black);
                        break;
                }
                transaction.commit();
            }
        };


    }
