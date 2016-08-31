package com.king.luhai.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.king.luhai.R;

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



        return v;
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.qiandao:

                    break;
                case R.id.ismy:

                    break;
                case R.id.jifeng:

                    break;
                case R.id.mytiezhi:

                    break;
                case R.id.xitongset:

                    break;
            }
        }
    };



    }
