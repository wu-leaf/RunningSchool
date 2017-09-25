package cn.edu.gdou.www.runningschool.ui.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import net.lemonsoft.lemonbubble.LemonBubbleGlobal;
import net.lemonsoft.lemonhello.LemonHello;
import net.lemonsoft.lemonhello.LemonHelloAction;
import net.lemonsoft.lemonhello.LemonHelloGlobal;
import net.lemonsoft.lemonhello.LemonHelloInfo;
import net.lemonsoft.lemonhello.LemonHelloView;
import net.lemonsoft.lemonhello.adapter.LemonHelloEventDelegateAdapter;
import net.lemonsoft.lemonhello.interfaces.LemonHelloActionDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.edu.gdou.www.runningschool.R;

public class PostingActivity extends AppCompatActivity {

    @BindView(R.id.back_posting)
    ImageView mBackPosting;
    @BindView(R.id.send_posting)
    TextView mSendPosting;
    @BindView(R.id.post_title)
    EditText mPostTitle;
    @BindView(R.id.post_content)
    EditText mPostContent;
    @BindView(R.id.post_type_spinner)
    Spinner mPostTypeSpinner;
    @BindView(R.id.post_time_spinner)
    Spinner mPostTimeSpinner;
    @BindView(R.id.post_salary)
    EditText mPostSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posting);
        ButterKnife.bind(this);

        LemonHelloGlobal.statusBarColor = Color.parseColor("#3399FF");
        LemonBubbleGlobal.statusBarColor = Color.parseColor("#3399FF");

        mPostTitle.setFocusable(true);
        mPostTitle.setFocusableInTouchMode(true);
        mPostTitle.requestFocus();
        //打开软键盘,似乎没有起作用
        InputMethodManager imm = (InputMethodManager)PostingActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    @OnClick({R.id.back_posting, R.id.send_posting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_posting:
                finish();
                break;
            case R.id.send_posting:
                //发起网络请求，把数据全部丢给后台

                //成功回调
                LemonHello.getSuccessHello("发布成功", "请耐心等待后台咪咪的审核")
                        .setContentFontSize(14)
                        .addAction(new LemonHelloAction("我知道啦", new LemonHelloActionDelegate() {
                            @Override
                            public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
                                helloView.hide();
                            }
                        }))
                        .setEventDelegate(new LemonHelloEventDelegateAdapter() {
                            @Override
                            public void onMaskTouch(LemonHelloView helloView, LemonHelloInfo helloInfo) {
                                super.onMaskTouch(helloView, helloInfo);
                                helloView.hide();
                            }
                        })
                        .show(PostingActivity.this);
                break;
        }
    }
}
