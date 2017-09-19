package cn.edu.gdou.www.runningschool.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
            Toast.makeText(this,mFeedbackContent.getText().toString().trim()+
                    mFeedbackContact.getText().toString().trim(),Toast.LENGTH_SHORT).show();
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
