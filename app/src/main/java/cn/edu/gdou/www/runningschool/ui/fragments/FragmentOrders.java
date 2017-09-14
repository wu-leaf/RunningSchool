package cn.edu.gdou.www.runningschool.ui.fragments;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import cn.edu.gdou.www.runningschool.R;


public class FragmentOrders extends BaseFragment {


    private static final String TAG = FragmentOrders.class.getSimpleName();//"CommonFrameFragment"
    private TextView textView;

    @Override
    protected View initView() {
        Log.e(TAG,"其他Fragment页面被初始化了...");
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        View contentView  = mInflater.inflate(R.layout.layout_orders,null);
        return contentView;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "其他Fragment数据被初始化了...");

    }
}