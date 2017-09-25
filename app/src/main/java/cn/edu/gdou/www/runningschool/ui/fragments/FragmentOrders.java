package cn.edu.gdou.www.runningschool.ui.fragments;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cn.edu.gdou.www.runningschool.R;
import cn.edu.gdou.www.runningschool.ui.adapter.MyViewPagerAdapter;


public class FragmentOrders extends BaseFragment {
    ViewPager viewPager;
    TabLayout tabLayout;
    ArrayList<MyFragment> fragments;
    MyViewPagerAdapter adapter;

    private static final String TAG = FragmentNews.class.getSimpleName();//"CommonFrameFragment"
    private TextView textView;

    @Override
    protected View initView() {

        LayoutInflater mInflater = LayoutInflater.from(mContext);
        View contentView  = mInflater.inflate(R.layout.layout_orders,null);

        viewPager = (ViewPager) contentView.findViewById(R.id.viewPager);
        tabLayout = (TabLayout) contentView.findViewById(R.id.tabLayout);

        return contentView;
    }

    @Override
    protected void initData() {
        super.initData();
//初始化数据
        fragments = new ArrayList<>();
        fragments.add(new MyFragment("已发布任务","6"));
        fragments.add(new MyFragment("已接单任务","7"));

        //设置ViewPager的适配器

        //adapter = new ViewPagerAdapter(getSupportFragmentManager(),fragments);
        adapter=new MyViewPagerAdapter(getChildFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
        //关联ViewPager
        tabLayout.setupWithViewPager(viewPager);
        //设置固定的
        //tabLayout.setTabMode(TabLayout.MODE_FIXED);
//设置滑动的。
        //tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }
}
