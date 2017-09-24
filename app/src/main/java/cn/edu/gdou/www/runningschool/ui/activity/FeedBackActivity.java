package cn.edu.gdou.www.runningschool.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

public class FeedBackActivity extends AppCompatActivity {

    @BindView(R.id.feedback_back)
    ImageView mFeedbackBack;
    @BindView(R.id.feedback_send)
    TextView mFeedbackSend;
    @BindView(R.id.feedback_content)
    EditText mFeedbackContent;
    @BindView(R.id.feedback_contact)
    EditText mFeedbackContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        ButterKnife.bind(this);

        LemonHelloGlobal.statusBarColor = Color.parseColor("#3399FF");
        LemonBubbleGlobal.statusBarColor = Color.parseColor("#3399FF");
    }

    @OnClick({R.id.feedback_back, R.id.feedback_send})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.feedback_back:
                finish();
                break;
            case R.id.feedback_send:
                //Toast.makeText(this,"发送反馈",Toast.LENGTH_SHORT).show();
                sendFeedBack();//把反馈信息发送到后台
                break;
        }
    }

    private void sendFeedBack() {
        Log.e("TAG","sendFeedBack");
        if(isEditTextEmpty()){
            Toast.makeText(this,"输入不能为空",Toast.LENGTH_SHORT).show();
        }else{
            //执行网络请求发送反馈信息
            LemonHello.getSuccessHello("提交成功", "您所填写的反馈信息已经全部提交成功，我们的客服人员将在24小时内进行处理，请耐心等待.")
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
                    .show(FeedBackActivity.this);

        }

    }

    private boolean isEditTextEmpty() {
        if (mFeedbackContent.getText().toString().trim().isEmpty())
            return true;
        if (mFeedbackContact.getText().toString().trim().isEmpty())
            return true;

        return false;
    }


}
