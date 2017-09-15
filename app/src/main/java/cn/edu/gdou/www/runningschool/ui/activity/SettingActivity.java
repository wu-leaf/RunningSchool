package cn.edu.gdou.www.runningschool.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.edu.gdou.www.runningschool.R;

public class SettingActivity extends AppCompatActivity {

    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.save_setting)
    TextView mSaveSetting;
    @BindView(R.id.ly_icon)
    LinearLayout mLyIcon;
    @BindView(R.id.ly_name)
    LinearLayout mLyName;
    @BindView(R.id.ly_sex)
    LinearLayout mLySex;
    @BindView(R.id.ly_brithday)
    LinearLayout mLyBrithday;
    @BindView(R.id.ly_school)
    LinearLayout mLySchool;
    @BindView(R.id.ly_time_school)
    LinearLayout mLyTimeSchool;
    @BindView(R.id.ly_intro)
    LinearLayout mLyIntro;
    @BindView(R.id.btn_log_out)
    Button mBtnLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back, R.id.save_setting, R.id.ly_icon,
            R.id.ly_name, R.id.ly_sex, R.id.ly_brithday,
            R.id.ly_school, R.id.ly_time_school, R.id.ly_intro, R.id.btn_log_out})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.save_setting:
                //发起网络请求，把数据全部丢给后台
                Toast.makeText(SettingActivity.this,"save_setting",Toast.LENGTH_SHORT).show();

                break;
            case R.id.ly_icon:
                //选择图片
                Toast.makeText(SettingActivity.this,"ly_icon",Toast.LENGTH_SHORT).show();

                break;
            case R.id.ly_name:
                //修改姓名
                Toast.makeText(SettingActivity.this,"ly_name",Toast.LENGTH_SHORT).show();

                break;
            case R.id.ly_sex:
                //修改性别
                Toast.makeText(SettingActivity.this,"ly_sex",Toast.LENGTH_SHORT).show();

                break;
            case R.id.ly_brithday:
                //修改生日
                Toast.makeText(SettingActivity.this,"ly_brithday",Toast.LENGTH_SHORT).show();

                break;
            case R.id.ly_school:
                //修改学校
                Toast.makeText(SettingActivity.this,"ly_school",Toast.LENGTH_SHORT).show();

                break;
            case R.id.ly_time_school:
                //入学时间
                Toast.makeText(SettingActivity.this,"ly_time_school",Toast.LENGTH_SHORT).show();

                break;
            case R.id.ly_intro:
                //个人介绍
                Toast.makeText(SettingActivity.this,"ly_intro",Toast.LENGTH_SHORT).show();

                break;
            case R.id.btn_log_out:
                //退出登录
                Toast.makeText(SettingActivity.this,"btn_log_out",Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
