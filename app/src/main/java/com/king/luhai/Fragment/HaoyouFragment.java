package com.king.luhai.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.king.luhai.R;

/**
 * Created by Administrator on 2016/8/30.
 */
public class HaoyouFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.item_messagehaoyou, container, false);
    }

}
