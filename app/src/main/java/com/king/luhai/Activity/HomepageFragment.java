package com.king.luhai.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.king.luhai.Adapter.CycleViewPager;
import com.king.luhai.Product.Adinfo;
import com.king.luhai.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/23.
 */
public class HomepageFragment extends Fragment {
    private List<ImageView> views = new ArrayList<ImageView>();
    private List<Adinfo> adinfos = new ArrayList<Adinfo>();
    private CycleViewPager cycleViewPager;

    private String[] imageUrls = {"http://img.taodiantong.cn/v55183/infoimg/2013-07/130720115322ky.jpg",
            "http://pic30.nipic.com/20130626/8174275_085522448172_2.jpg",
            "http://pic18.nipic.com/20111215/577405_080531548148_2.jpg",
            "http://pic15.nipic.com/20110722/2912365_092519919000_2.jpg",
            "http://pic.58pic.com/58pic/12/64/27/55U58PICrdX.jpg"};

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.item_homepage, container, false);

        return v;
    }



    }
