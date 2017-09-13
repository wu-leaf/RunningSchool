package cn.edu.gdou.www.runningschool.ui.fragments;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import cn.edu.gdou.www.runningschool.R;


public class FragmentFour extends BaseFragment {


    private static final String TAG = FragmentFour.class.getSimpleName();//"CommonFrameFragment"
    private TextView textView;

    @Override
    protected View initView() {

        LayoutInflater mInflater = LayoutInflater.from(mContext);
        View contentView  = mInflater.inflate(R.layout.layout_four,null);



        return contentView;
    }

    @Override
    protected void initData() {
        super.initData();

    }
}
