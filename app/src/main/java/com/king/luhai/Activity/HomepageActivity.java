package com.king.luhai.activity;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.king.luhai.View.CenterDialog;
import com.king.luhai.adapter.HomepageAdapter;
import com.king.luhai.R;
import com.king.luhai.adapter.Mydialog;
import com.king.luhai.fragment.FriendFragment;
import com.king.luhai.fragment.HomepageFragment;
import com.king.luhai.fragment.HomepageFragmenttitle;
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
    ImageView centertitle;
    private Mydialog mydialog;
    LinearLayout linearLayout;
    private boolean ischeck=true;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        shouye = (RadioButton) findViewById(R.id.shouye);
        xiaoxi = (RadioButton) findViewById(R.id.xiaoxi);
        wode = (RadioButton) findViewById(R.id.wode);
        centertitle = (ImageView) findViewById(R.id.center_title);
        linearLayout=(LinearLayout)findViewById(R.id.linear);
        centertitle.setOnClickListener(onClickListener);

        pengyou = (RadioButton) findViewById(R.id.pengyou);
        getDate();
        homepageAdapter = new HomepageAdapter(getSupportFragmentManager(), fragmentlist);
        viewPager = (ViewPager) findViewById(R.id.homepage_viewpager);
        viewPager.setAdapter(homepageAdapter);
        radiogroup = (RadioGroup) findViewById(R.id.homepage_radiogroup);
        viewPager.setOnPageChangeListener(onPageChangeListener);
        viewPager.setOffscreenPageLimit(4);
        radiogroup.setOnCheckedChangeListener(onCheckedChangeListener);

    }
//动画监听
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            showPopupWindow(view);
        }
    };

    public void showPopupWindow(View view) {
        rotating();


        //多个Activity嵌套时用this.parent否则异常
        new CenterDialog(HomepageActivity.this)
                .showDialog(R.layout.dilog_animal, 80, 50);
        }



//      if (ischeck) {
//          moveup();
//          //viewPager.setBackgroundResource(R.color.homepageback);
//          ischeck=false;
//      }else {
//          movedown();
//        //  viewPager.setBackgroundResource(R.color.white);
//          ischeck=true;
//      }

    //移动到隐藏
    public void movedown(){
        AnimationSet animationSet1 = new AnimationSet(true);
        TranslateAnimation translateAnimation =
                new TranslateAnimation(
                        Animation.RELATIVE_TO_SELF, 0f,//开始的X
                        Animation.RELATIVE_TO_SELF, 0f,//j
                        Animation.RELATIVE_TO_SELF, -1.5f,//开始的Y
                        Animation.RELATIVE_TO_SELF, 0f);
        translateAnimation.setDuration(1000);
        animationSet1.addAnimation(translateAnimation);
        animationSet1.setFillAfter(true);
        linearLayout.startAnimation(animationSet1);
    }
    //移动出来
    public void moveup(){
        AnimationSet animationSet1 = new AnimationSet(true);
        TranslateAnimation translateAnimation =
                new TranslateAnimation(
                        Animation.RELATIVE_TO_SELF, 0f,//开始的X
                        Animation.RELATIVE_TO_SELF, 0f,
                        Animation.RELATIVE_TO_SELF, 0f,//开始的Y
                        Animation.RELATIVE_TO_SELF, -1.5f);
        translateAnimation.setDuration(1000);
        animationSet1.addAnimation(translateAnimation);
        animationSet1.setFillAfter(true);
        linearLayout.startAnimation(animationSet1);
    }
    //旋转动画
    public void rotating(){
        AnimationSet animationSet = new AnimationSet(true);

        //参数1：从哪个旋转角度开始
        //参数2：转到什么角度
        //后4个参数用于设置围绕着旋转的圆的圆心在哪里
        //参数3：确定x轴坐标的类型，有ABSOLUT绝对坐标、RELATIVE_TO_SELF相对于自身坐标、RELATIVE_TO_PARENT相对于父控件的坐标
        //参数4：x轴的值，0.5f表明是以自身这个控件的一半长度为x轴
        //参数5：确定y轴坐标的类型
        //参数6：y轴的值，0.5f表明是以自身这个控件的一半长度为x轴

        RotateAnimation rotateAnimation = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(1000);
        animationSet.addAnimation(rotateAnimation);
        centertitle.startAnimation(animationSet);

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
        HomepageFragmenttitle homepageFragment = new HomepageFragmenttitle();
        fragmentlist.add(homepageFragment);
        MessageFragment messageFragment = new MessageFragment();
        fragmentlist.add(messageFragment);
        FriendFragment friendFragment = new FriendFragment();
        fragmentlist.add(friendFragment);
        MyFragment myFragment = new MyFragment();
        fragmentlist.add(myFragment);
    }

}
