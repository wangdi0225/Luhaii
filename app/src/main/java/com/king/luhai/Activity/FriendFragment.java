package com.king.luhai.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.king.luhai.R;

/**
 * Created by Administrator on 2016/8/23.
 */
public class FriendFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.item_friend, container, false);



        return v;

    }


}

