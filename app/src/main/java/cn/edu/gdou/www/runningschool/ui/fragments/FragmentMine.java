package cn.edu.gdou.www.runningschool.ui.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import cn.edu.gdou.www.runningschool.R;


public class FragmentMine extends BaseFragment {


    private static final String TAG = FragmentMine.class.getSimpleName();//"CommonFrameFragment"
    private TextView textView;

    @Override
    protected View initView() {

        LayoutInflater mInflater = LayoutInflater.from(mContext);
        View contentView  = mInflater.inflate(R.layout.layout_mine,null);



        return contentView;
    }

    @Override
    protected void initData() {
        super.initData();

    }
}
