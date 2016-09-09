package com.king.luhai.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.king.luhai.R;
import com.king.luhai.adapter.ExpandAdapter;
import com.king.luhai.product.MyExpanchildlist;
import com.king.luhai.product.MyExpandlist;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/30.
 */
public class HaoyouFragment extends Fragment {
    private ExpandableListView lists;
    private ExpandAdapter mAdapter;
    private List<MyExpandlist> myList;
    private List<MyExpanchildlist> childlistone;
    private List<List<MyExpanchildlist>> childlist;

    private String[][] childlists={{"赵四","尼古拉斯丶赵四","张三"},{"王老五"}};
    private String[] fathername={"游戏基友","约黑基友"};
    private String[] fatherdaqu={"艾欧尼亚",""};
    private String[][] childtext={{"来一起玩游戏","我就是街头舞王尼古拉斯,赵四","大家好,我叫张三"},{"我王老五就是喜欢超市,哦不,超神"}};
    private int[][] childicon={{R.mipmap.tx4,R.mipmap.tx6,R.mipmap.tx12},{R.mipmap.tx22}};
    private String[][] childstate={{"游戏在线","游戏中","游戏在线"},{"游戏中"}};

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // initData();
        View v = inflater.inflate(R.layout.item_messagehaoyou, container, false);
        lists=(ExpandableListView)v.findViewById(R.id.lists);
        mAdapter=new ExpandAdapter(getActivity());
        AddDate();
        lists.setAdapter(mAdapter);
        return v;
    }
        public void AddDate(){
            myList=new ArrayList<MyExpandlist>();
            childlist=new ArrayList<List<MyExpanchildlist>>();
            for(int i=0;i<fathername.length;i++){
                MyExpandlist lists = new MyExpandlist();
                lists.haoyou=fathername[i];
                lists.youxidaqu=fatherdaqu[i];
                myList.add(lists);
            }
            for(int i=0;i<childlists.length;i++){
                childlistone=new ArrayList<MyExpanchildlist>();
                for (int j=0;j<childlists[i].length;j++){
                    MyExpanchildlist lists= new MyExpanchildlist();
                    lists.name=childlists[i][j];
                    lists.content=childtext[i][j];
                    lists.icon=childicon[i][j];
                    lists.state=childstate[i][j];
                    childlistone.add(lists);
                }
                childlist.add(childlistone);
            }
            mAdapter.setData(myList,childlist);
        }
}