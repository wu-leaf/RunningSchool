package cn.edu.gdou.www.runningschool.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.edu.gdou.www.runningschool.R;
import cn.edu.gdou.www.runningschool.ui.activity.SettingActivity;


public class FragmentMine extends BaseFragment {


    private static final String TAG = FragmentMine.class.getSimpleName();//"CommonFrameFragment"
    @BindView(R.id.enter_change_data)
    ImageView mEnterChangeData;



    @Override
    protected View initView() {

        LayoutInflater mInflater = LayoutInflater.from(mContext);
        View contentView = mInflater.inflate(R.layout.layout_mine, null);


        return contentView;
    }

    @Override
    protected void initData() {
        super.initData();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        mEnterChangeData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);//跳转到 设置界面
            }
        });







        return rootView;
    }



}
