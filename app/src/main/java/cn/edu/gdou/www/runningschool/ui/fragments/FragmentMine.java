package cn.edu.gdou.www.runningschool.ui.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import net.lemonsoft.lemonbubble.LemonBubble;
import net.lemonsoft.lemonbubble.enums.LemonBubbleLayoutStyle;
import net.lemonsoft.lemonbubble.enums.LemonBubbleLocationStyle;
import net.lemonsoft.lemonhello.LemonHello;
import net.lemonsoft.lemonhello.LemonHelloAction;
import net.lemonsoft.lemonhello.LemonHelloInfo;
import net.lemonsoft.lemonhello.LemonHelloView;
import net.lemonsoft.lemonhello.interfaces.LemonHelloActionDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.edu.gdou.www.runningschool.R;
import cn.edu.gdou.www.runningschool.ui.activity.FeedBackActivity;
import cn.edu.gdou.www.runningschool.ui.activity.SettingActivity;


public class FragmentMine extends BaseFragment {


    private static final String TAG = FragmentMine.class.getSimpleName();//"CommonFrameFragment"
    @BindView(R.id.enter_change_data)
    ImageView mEnterChangeData;
    @BindView(R.id.mine_wallet)
    LinearLayout mMineWallet;
    @BindView(R.id.mine_help)
    LinearLayout mMineHelp;
    @BindView(R.id.mine_feedback)
    LinearLayout mMineFeedback;
    @BindView(R.id.mine_checknew)
    LinearLayout mMineChecknew;
    @BindView(R.id.mine_msg)
    LinearLayout mMineMsg;
    @BindView(R.id.mine_about)
    LinearLayout mMineAbout;


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


    @OnClick({R.id.mine_wallet, R.id.mine_help, R.id.mine_feedback, R.id.mine_checknew, R.id.mine_msg, R.id.mine_about})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mine_wallet:
                Toast.makeText(getActivity(),"mine_wallet",Toast.LENGTH_SHORT).show();

                break;
            case R.id.mine_help:
                Toast.makeText(getActivity(),"mine_help",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_feedback:

                Intent intent = new Intent(getActivity(),FeedBackActivity.class);
                startActivity(intent);
                break;
            case R.id.mine_checknew:

             LemonBubble.getRoundProgressBubbleInfo()
                        .setLocationStyle(LemonBubbleLocationStyle.BOTTOM)
                        .setLayoutStyle(LemonBubbleLayoutStyle.ICON_LEFT_TITLE_RIGHT)
                        .setBubbleSize(200, 50)
                        .setProportionOfDeviation(0.1f)

                        .setTitle("正在请求服务器...")
                        .show(getActivity());
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        LemonBubble.showRight(getActivity(), "目前已经是最新版，请君慢用", 2000);
                    }
                }, 1500);


                break;
            case R.id.mine_msg:
                Toast.makeText(getActivity(),"mine_msg",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_about:
                Toast.makeText(getActivity(),"mine_about",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
