package com.king.luhai.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.king.luhai.R;

/**
 * Created by Administrator on 2016/8/31.
 */
public class HomepageFragmenttitle extends Fragment {

    TextView regoin;
    ImageView duanwei;
    HomepageFragment homepageFragment;
    HomepageFragmenttel homepageFragmenttel;
    private boolean ischeck=false;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.item_homepagetitle, container, false);
        duanwei=(ImageView)v.findViewById(R.id.duanwei);
        duanwei.setOnClickListener(onClickListenerduanwei);
        regoin = (TextView) v.findViewById(R.id.region);
        regoin.setOnClickListener(onClickListener);
        setDefaultFragment();
        return v;
    }
    private void setDefaultFragment()
    {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        homepageFragment = new HomepageFragment();
        transaction.replace(R.id.fragment_content, homepageFragment);
        transaction.commit();
    }
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                // 开启Fragment事务
                FragmentTransaction transaction = fm.beginTransaction();
                if(ischeck){
                    homepageFragment =new HomepageFragment();
                    transaction.replace(R.id.fragment_content, homepageFragment);
                    ischeck=false;
                }else{
                    homepageFragmenttel = new HomepageFragmenttel();
                    transaction.replace(R.id.fragment_content,homepageFragmenttel);
                    ischeck=true;
                }
                transaction.commit();
            }
        };
        View.OnClickListener onClickListenerduanwei  = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                

            }
        };
}
