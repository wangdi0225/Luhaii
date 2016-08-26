package com.king.luhai.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.king.luhai.Adapter.HomepageAdapter;
import com.king.luhai.R;
import com.king.luhai.fragment.FriendFragment;
import com.king.luhai.fragment.HomepageFragment;
import com.king.luhai.fragment.MessageFragment;
import com.king.luhai.fragment.MyFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/22.
 */
public class HomepageActivity extends FragmentActivity {
    RadioButton shouye, xiaoxi, wode, pengyou;
    ArrayList<Fragment> fragmentlist;
    HomepageAdapter homepageAdapter;
    ViewPager viewPager;
    RadioGroup radiogroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        shouye = (RadioButton) findViewById(R.id.shouye);
        xiaoxi = (RadioButton) findViewById(R.id.xiaoxi);
        wode = (RadioButton) findViewById(R.id.wode);
        pengyou = (RadioButton) findViewById(R.id.pengyou);
        getDate();
        homepageAdapter = new HomepageAdapter(getSupportFragmentManager(), fragmentlist);
        viewPager = (ViewPager) findViewById(R.id.homepage_viewpager);
        viewPager.setAdapter(homepageAdapter);
        radiogroup = (RadioGroup) findViewById(R.id.homepage_radiogroup);
        viewPager.setOnPageChangeListener(onPageChangeListener);
        radiogroup.setOnCheckedChangeListener(onCheckedChangeListener);

    }

    RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (radioGroup.getCheckedRadioButtonId()) {
                case R.id.shouye:
                    viewPager.setCurrentItem(0);
                    Drawable drawable = getResources().getDrawable(
                            R.mipmap.main_shou_ye_zhi_ye);
                    shouye.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
                    Drawable drawable1 = getResources().getDrawable(
                            R.mipmap.main_shou_ye_xiao_xi_not_select);
                    xiaoxi.setCompoundDrawablesWithIntrinsicBounds(null, drawable1, null, null);
                    Drawable drawable2 = getResources().getDrawable(
                            R.mipmap.main_shou_ye_lu_you_quan_not_select);
                    pengyou.setCompoundDrawablesWithIntrinsicBounds(null, drawable2, null, null);
                    Drawable drawable3 = getResources().getDrawable(
                            R.mipmap.main_shou_ye_wo_not_select);
                    wode.setCompoundDrawablesWithIntrinsicBounds(null, drawable3, null, null);
                    break;
                case R.id.xiaoxi:
                    viewPager.setCurrentItem(1);
                    Drawable drawable4 = getResources().getDrawable(
                            R.mipmap.main_shou_ye_zhi_ye_not_select);
                    shouye.setCompoundDrawablesWithIntrinsicBounds(null, drawable4, null, null);
                    Drawable drawable5 = getResources().getDrawable(
                            R.mipmap.main_shou_ye_xiao_xi);
                    xiaoxi.setCompoundDrawablesWithIntrinsicBounds(null, drawable5, null, null);
                    Drawable drawable6 = getResources().getDrawable(
                            R.mipmap.main_shou_ye_lu_you_quan_not_select);
                    pengyou.setCompoundDrawablesWithIntrinsicBounds(null, drawable6, null, null);
                    Drawable drawable7 = getResources().getDrawable(
                            R.mipmap.main_shou_ye_wo_not_select);
                    wode.setCompoundDrawablesWithIntrinsicBounds(null, drawable7, null, null);
                    break;
                case R.id.pengyou:
                    viewPager.setCurrentItem(2);
                    Drawable drawable8 = getResources().getDrawable(
                            R.mipmap.main_shou_ye_zhi_ye_not_select);
                    shouye.setCompoundDrawablesWithIntrinsicBounds(null, drawable8, null, null);
                    Drawable drawable9 = getResources().getDrawable(
                            R.mipmap.main_shou_ye_xiao_xi_not_select);
                    xiaoxi.setCompoundDrawablesWithIntrinsicBounds(null, drawable9, null, null);
                    Drawable drawable10 = getResources().getDrawable(
                            R.mipmap.main_shou_ye_lu_you_quan);
                    pengyou.setCompoundDrawablesWithIntrinsicBounds(null, drawable10, null, null);
                    Drawable drawable11 = getResources().getDrawable(
                            R.mipmap.main_shou_ye_wo_not_select);
                    wode.setCompoundDrawablesWithIntrinsicBounds(null, drawable11, null, null);
                    break;
                case R.id.wode:
                    viewPager.setCurrentItem(3);
                    Drawable drawable12 = getResources().getDrawable(
                            R.mipmap.main_shou_ye_zhi_ye_not_select);
                    shouye.setCompoundDrawablesWithIntrinsicBounds(null, drawable12, null, null);
                    Drawable drawable13 = getResources().getDrawable(
                            R.mipmap.main_shou_ye_xiao_xi_not_select);
                    xiaoxi.setCompoundDrawablesWithIntrinsicBounds(null, drawable13, null, null);
                    Drawable drawable14 = getResources().getDrawable(
                            R.mipmap.main_shou_ye_lu_you_quan_not_select);
                    pengyou.setCompoundDrawablesWithIntrinsicBounds(null, drawable14, null, null);
                    Drawable drawable15 = getResources().getDrawable(
                            R.mipmap.main_shou_ye_wo);
                    wode.setCompoundDrawablesWithIntrinsicBounds(null, drawable15, null, null);
            }

        }
    };


    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    shouye.setChecked(true);
                    break;
                case 1:
                    xiaoxi.setChecked(true);
                    break;
                case 2:
                    pengyou.setChecked(true);
                    break;
                case 3:
                    wode.setChecked(true);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    public void getDate() {
        fragmentlist = new ArrayList<Fragment>();
        HomepageFragment homepageFragment = new HomepageFragment();
        fragmentlist.add(homepageFragment);
        MessageFragment messageFragment = new MessageFragment();
        fragmentlist.add(messageFragment);
        FriendFragment friendFragment = new FriendFragment();
        fragmentlist.add(friendFragment);
        MyFragment myFragment = new MyFragment();
        fragmentlist.add(myFragment);
    }

}
