package cn.edu.gdou.www.runningschool.ui.fragments;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import cn.edu.gdou.www.runningschool.R;
import cn.edu.gdou.www.runningschool.ui.adapter.MyViewPagerAdapter;


public class FragmentTwo extends BaseFragment {
    ViewPager viewPager;
    TabLayout tabLayout;
    ArrayList<MyFragment>  fragments;
    MyViewPagerAdapter adapter;
    ImageView mImageView;

    private static final String TAG = FragmentTwo.class.getSimpleName();//"CommonFrameFragment"
    private TextView textView;

    @Override
    protected View initView() {
        Log.e(TAG,"其他Fragment页面被初始化了...");
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        View contentView  = mInflater.inflate(R.layout.layout_two,null);

        viewPager = (ViewPager) contentView.findViewById(R.id.viewPager);
        tabLayout = (TabLayout) contentView.findViewById(R.id.tabLayout);
        mImageView = (ImageView) contentView.findViewById(R.id.image);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return contentView;
    }

    @Override
    protected void initData() {
        super.initData();
//初始化数据
        fragments = new ArrayList<>();
            fragments.add(new MyFragment("头条","1"));
            fragments.add(new MyFragment("保险101","2"));
            fragments.add(new MyFragment("国际","3"));
            fragments.add(new MyFragment("两地","4"));
            fragments.add(new MyFragment("实验室","5"));
        //设置ViewPager的适配器

        //adapter = new ViewPagerAdapter(getSupportFragmentManager(),fragments);
        adapter=new MyViewPagerAdapter(getChildFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
        //关联ViewPager
        tabLayout.setupWithViewPager(viewPager);
        //设置固定的
        //tabLayout.setTabMode(TabLayout.MODE_FIXED);
//设置滑动的。
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }
}
