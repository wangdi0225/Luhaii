package com.king.luhai.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.king.luhai.adapter.HomepageAdapter;
import com.king.luhai.adapter.HomepageGridviewAdapter;
import com.king.luhai.adapter.HomepageListViewAdapter;
import com.king.luhai.adapter.RegoinAdapter;
import com.king.luhai.product.GridviewList;
import com.king.luhai.product.HomepageListview;

import android.widget.SimpleAdapter;
import android.widget.TextView;

import android.widget.Toast;

import com.king.luhai.adapter.HomepageAdapter;
import com.king.luhai.adapter.HomepageGridviewAdapter;
import com.king.luhai.adapter.HomepageListViewAdapter;
import com.king.luhai.adapter.RegoinAdapter;
import com.king.luhai.fragment.Teampageone;
import com.king.luhai.fragment.Teampagethree;
import com.king.luhai.fragment.Teampagetwo;
import com.king.luhai.product.GridviewList;
import com.king.luhai.product.HomepageListview;
import com.king.luhai.product.GridviewList;
import com.king.luhai.product.HomepageListview;
import com.king.luhai.product.RegoinList;

import com.king.luhai.R;
import com.king.luhai.product.RegoinList;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2016/8/23.
 */
public class HomepageFragment extends Fragment {
    private HomepageGridviewAdapter homepageGridviewAdapter;
    private HomepageListViewAdapter homepageListViewAdapter;
    private ListView listView;
    private GridView gridview;
    private View header;
    private List<HomepageListview> listlists = new ArrayList<HomepageListview>();
    private List<GridviewList> gridlist = new ArrayList<GridviewList>();
    private String[] name = {"猪哥我爱你", "本萌妹超厉害"};
    private String[] time = {"3分钟前", "3分钟前"};
    private String[] content = {"开黑的快来咯,坑比走开啊!", "大腿快来咯,带我装逼带我飞!"};
    private String[] daqu = {"洛克萨斯", "黑色玫瑰"};
    private String[] level = {"华贵铂金III", "黄金V"};
    private String[] zhudui = {"2", "3"};
    private String[] pinglun = {"2", "4"};
    private String[] dianzhan = {"13", "99+"};
    private String[] dianxqu = {"艾欧尼亚", "祖安", "洛克萨斯", "班德尔城", "皮尔特洛夫", "战争学院", "巨神峰", "雷瑟守备", "裁决之地", "黑色玫瑰", "暗影岛", "钢铁烈阳", "均衡教派", "水晶之痕"};
    private String[] wangtongqu = {"比尔吉沃特", "德玛西亚", "弗雷尔卓德", "无畏先锋"};
    private int[] listicon = {R.mipmap.lovepig, R.mipmap.te11};
    private int[] image = {0, R.mipmap.mao};
    private ArrayList<Fragment> fragmentlist;
    private String[] titleone = {"撸友新动态", "官方新动态", "精彩视频集锦", "转转赢积分"};
    private String[] titletwo = {"不错过每分信息", "时刻了解最新咨询", "各种精彩搞笑合辑", "积分翻倍好机会"};
    private String[] regoinlist = {"全部", "电信", "网通", "其他"};
    private int[] to = {R.id.name};
    private String[] from = {"name"};
    private int[] icon = {R.mipmap.luoli, R.mipmap.wuya, R.mipmap.amumu, R.mipmap.wuya};
    private ImageView[] imageViews = null;
    private ImageView imageView = null;
    private ViewPager advPager = null;
    private AtomicInteger what = new AtomicInteger(0);
    private boolean isContinue = true;
    private HomepageAdapter homepageAdapter;
    private ViewPager viewPager;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.item_homepagetitleone, container, false);
        header = LayoutInflater.from(getActivity()).inflate(
                R.layout.item_homepage, null);

        adddate();
        homepageAdapter = new HomepageAdapter(getActivity().getSupportFragmentManager(), fragmentlist);
        viewPager = (ViewPager) header.findViewById(R.id.team_viewpager);
        viewPager.setAdapter(homepageAdapter);
        gridview = (GridView) header.findViewById(R.id.homepage_gridview);
        listView = (ListView) v.findViewById(R.id.homepage_listview);
        listView.addHeaderView(header);
        homepageListViewAdapter = new HomepageListViewAdapter(getActivity());
        homepageGridviewAdapter = new HomepageGridviewAdapter(getActivity());
        listView.setAdapter(homepageListViewAdapter);
        gridview.setAdapter(homepageGridviewAdapter);
        addlist();
        addgrid();
        initViewPager(header);
        return v;
    }

    private void adddate() {
        fragmentlist = new ArrayList<Fragment>();

        
        Teampageone teampageone = new Teampageone();
        fragmentlist.add(teampageone);
        Teampagetwo teampagetwo = new Teampagetwo();
        fragmentlist.add(teampagetwo);
        Teampagethree teampagethree = new Teampagethree();
        fragmentlist.add(teampagethree);

    }

    private void initViewPager(View v) {
        advPager = (ViewPager) v.findViewById(R.id.adv_pager);
        ViewGroup group = (ViewGroup) v.findViewById(R.id.viewGroup);

        //      这里存放的是三张广告背景
        List<View> advPics = new ArrayList<View>();

        ImageView img1 = new ImageView(getActivity());
        img1.setBackgroundResource(R.mipmap.homepage);
        advPics.add(img1);

        ImageView img2 = new ImageView(getActivity());
        img2.setBackgroundResource(R.mipmap.herolulu);
        advPics.add(img2);

        ImageView img3 = new ImageView(getActivity());
        img3.setBackgroundResource(R.mipmap.heroalitwo);
        advPics.add(img3);
        ImageView img4 = new ImageView(getActivity());
        img4.setBackgroundResource(R.mipmap.heroali);
        advPics.add(img4);


        //      对imageviews进行填充
        imageViews = new ImageView[advPics.size()];
        //小图标
        for (int i = 0; i < advPics.size(); i++) {
            imageView = new ImageView(getActivity());
            imageView.setLayoutParams(new ViewGroup.LayoutParams(20, 20));
            imageView.setPadding(4, 4, 4, 4);
            imageViews[i] = imageView;
            if (i == 0) {
                imageViews[i]
                        .setBackgroundResource(R.mipmap.yeschange);
            } else {
                imageViews[i]
                        .setBackgroundResource(R.mipmap.nochange);
            }
            group.addView(imageViews[i]);
        }

        advPager.setAdapter(new AdvAdapter(advPics));
        advPager.setOnPageChangeListener(new GuidePageChangeListener());
        advPager.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_MOVE:
                        isContinue = false;
                        break;
                    case MotionEvent.ACTION_UP:
                        isContinue = true;
                        break;
                    default:
                        isContinue = true;
                        break;
                }
                return false;
            }
        });
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    if (isContinue) {
                        viewHandler.sendEmptyMessage(what.get());
                        whatOption();
                    }
                }
            }

        }).start();
    }


    private void whatOption() {
        what.incrementAndGet();
        if (what.get() > imageViews.length - 1) {
            what.getAndAdd(-4);
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
    }

    private final Handler viewHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            advPager.setCurrentItem(msg.what);
            super.handleMessage(msg);
        }

    };

    private final class GuidePageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageSelected(int arg0) {
            what.getAndSet(arg0);
            for (int i = 0; i < imageViews.length; i++) {
                imageViews[arg0]
                        .setBackgroundResource(R.mipmap.yeschange);
                if (arg0 != i) {
                    imageViews[i]
                            .setBackgroundResource(R.mipmap.nochange);
                }
            }

        }

    }

    private final class AdvAdapter extends PagerAdapter {
        private List<View> views = null;

        public AdvAdapter(List<View> views) {
            this.views = views;
        }

        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView(views.get(arg1));
        }

        @Override
        public void finishUpdate(View arg0) {

        }

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public Object instantiateItem(View arg0, int arg1) {
            ((ViewPager) arg0).addView(views.get(arg1), 0);
            return views.get(arg1);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override


        public void restoreState(Parcelable arg0, ClassLoader arg1) {

        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public void startUpdate(View arg0) {

        }

    }


    public void addgrid() {
        for (int i = 0; i < 4; i++) {
            GridviewList gridviewList = new GridviewList();
            gridviewList.titleone = titleone[i];
            gridviewList.titletwo = titletwo[i];
            gridviewList.icon = icon[i];
            gridlist.add(gridviewList);
        }
        homepageGridviewAdapter.setData(gridlist);
    }

    public void addlist() {
        for (int i = 0; i < name.length; i++) {
            HomepageListview listviewlist = new HomepageListview();
            listviewlist.name = name[i];
            listviewlist.time = time[i];
            listviewlist.icon = listicon[i];
            listviewlist.content = content[i];
            listviewlist.daqu = daqu[i];
            listviewlist.level = level[i];
            listviewlist.jiaru = zhudui[i];
            listviewlist.dianzhan = dianzhan[i];
            listviewlist.pinglun = pinglun[i];
            listviewlist.image = image[i];


            listlists.add(listviewlist);
        }

        homepageListViewAdapter.setData(listlists);
    }
}




