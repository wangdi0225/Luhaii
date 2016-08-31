package com.king.luhai.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/23.
 */
public class HomepageAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragmentlist;

    public HomepageAdapter(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
    }

    public HomepageAdapter(FragmentManager fm, ArrayList<Fragment> fragmentlist) {
        super(fm);
        this.fragmentlist = fragmentlist;
        // TODO 自动生成的构造函数存根
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentlist.get(position);
    }

    @Override
    public int getCount() {
        return fragmentlist.size();
    }
}
