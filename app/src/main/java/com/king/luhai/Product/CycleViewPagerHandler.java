package com.king.luhai.Product;

import android.content.Context;
import android.os.Handler;

/**
 * 为了防止内存泄露,定义外部类,防止内部类对外部类的引用
 * Created by Administrator on 2016/8/23.
 */
public class CycleViewPagerHandler extends Handler {
    Context context;

    public CycleViewPagerHandler(Context context) {
        this.context = context;
    }
};