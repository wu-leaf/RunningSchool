package cn.edu.gdou.www.runningschool.ui.activity;

import android.Manifest;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.edu.gdou.www.runningschool.R;
import cn.edu.gdou.www.runningschool.ui.fragments.dialogfragment.CustomInputIntroFragment;
import cn.edu.gdou.www.runningschool.ui.fragments.dialogfragment.CustomInputNameFragment;
import cn.edu.gdou.www.runningschool.ui.fragments.dialogfragment.CustomInputSchoolFragment;
import gun0912.tedbottompicker.TedBottomPicker;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class SettingActivity extends AppCompatActivity {

    public RequestManager mGlideRequestManager;
    Uri selectedUri;

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
    @BindView(R.id.icon)
    ImageView mIcon;
    @BindView(R.id.sex)
    TextView mSex;
    @BindView(R.id.name)
    TextView mName;
    @BindView(R.id.birthday)
    TextView mBirthday;

    DateFormat format;
    Calendar calendar;
    @BindView(R.id.schoolday)
    TextView mSchoolday;
    private CustomInputNameFragment mCustomInputNameFragment;
    private CustomInputIntroFragment mCustomInputIntroFragment;
    private CustomInputSchoolFragment mCustomInputSchoolFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);

        format = DateFormat.getDateTimeInstance();
        //获取日期格式器对象
        calendar = Calendar.getInstance(Locale.CHINA);
        //获取日期格式器对象

        mCustomInputNameFragment = CustomInputNameFragment.newInstance();
        mCustomInputIntroFragment = CustomInputIntroFragment.newInstance();
        mCustomInputSchoolFragment = CustomInputSchoolFragment.newInstance();

        mGlideRequestManager = Glide.with(this);
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
                Toast.makeText(SettingActivity.this, "save_setting", Toast.LENGTH_SHORT).show();

                break;
            case R.id.ly_icon:
                //选择图片,单张
                getIcon();
                break;
            case R.id.ly_name:
                //修改姓名
                mCustomInputNameFragment.show(getSupportFragmentManager(), CustomInputNameFragment.TAG);
                //mCustomInputNameFragment.getEditTextValueFromSetting(mName.getText().toString());
                break;
            case R.id.ly_sex:
                //修改性别
                showSexChoose();
                break;
            case R.id.ly_brithday:
                //修改生日
                showBirthDayChoose();

                break;
            case R.id.ly_school:
                //修改学校
                mCustomInputSchoolFragment.show(getSupportFragmentManager(), CustomInputSchoolFragment.TAG);

                break;
            case R.id.ly_time_school:
                //入学时间

                showSchoolDayChoose();

                break;
            case R.id.ly_intro:
                mCustomInputIntroFragment.show(getSupportFragmentManager(), CustomInputIntroFragment.TAG);

                break;
            case R.id.btn_log_out:
                //退出登录
                Toast.makeText(SettingActivity.this, "btn_log_out", Toast.LENGTH_SHORT).show();

                break;
        }
    }

    private void showSchoolDayChoose() {
        updateSchoolDayTimeShow();
        //将页面TextView的显示更新为最新时间

        //生成一个DatePickerDialog对象，并显示。显示的DatePickerDialog控件可以选择年月日，并设置
        DatePickerDialog datePickerDialog = new DatePickerDialog(SettingActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //修改日历控件的年，月，日
                //这里的year,monthOfYear,dayOfMonth的值与DatePickerDialog控件设置的最新值一致
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateSchoolDayTimeShow();
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
        updateSchoolDayTimeShow();
        //将页面TextView的显示更新为最新时间
    }

    private void updateSchoolDayTimeShow() {
        //将页面TextView的显示更新为最新时间
        mSchoolday.setText(format.format(calendar.getTime()));
    }

    private void showBirthDayChoose() {

        updateBirthDayTimeShow();
        //将页面TextView的显示更新为最新时间

        //生成一个DatePickerDialog对象，并显示。显示的DatePickerDialog控件可以选择年月日，并设置
        DatePickerDialog datePickerDialog = new DatePickerDialog(SettingActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //修改日历控件的年，月，日
                //这里的year,monthOfYear,dayOfMonth的值与DatePickerDialog控件设置的最新值一致
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateBirthDayTimeShow();
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
        updateBirthDayTimeShow();
        //将页面TextView的显示更新为最新时间
    }

    private void updateBirthDayTimeShow() {
        //将页面TextView的显示更新为最新时间
        mBirthday.setText(format.format(calendar.getTime()));
    }


    public void setNameByDialog(String sname) {
        mName.setText(sname);
    }

    private void showSexChoose() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("选择性别:");
        builder.setIcon(R.mipmap.ic_launcher);
        final String[] items = new String[]{"男", "女", "妖"};
        builder.setSingleChoiceItems(items, 2, new DialogInterface.OnClickListener() {/*设置单选条件的点击事件*/
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mSex.setText(items[which]);
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(SettingActivity.this, "OK", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(SettingActivity.this, "取消", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    private void getIcon() {

        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {

                TedBottomPicker bottomSheetDialogFragment = new TedBottomPicker.Builder(SettingActivity.this)
                        .setOnImageSelectedListener(new TedBottomPicker.OnImageSelectedListener() {
                            @Override
                            public void onImageSelected(final Uri uri) {
                                Log.d("ted", "uri: " + uri);
                                Log.d("ted", "uri.getPath(): " + uri.getPath());
                                selectedUri = uri;


                                mIcon.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        mGlideRequestManager
                                                .load(uri)
                                                .bitmapTransform(new CropCircleTransformation(SettingActivity.this))//成功设置原型
                                                .into(mIcon);//把图片设置进 image 里面
                                    }
                                });

                            }
                        })
                        //.setPeekHeight(getResources().getDisplayMetrics().heightPixels/2)
                        .setSelectedUri(selectedUri)
                        .setPeekHeight(600)
                        .create();

                bottomSheetDialogFragment.show(getSupportFragmentManager());
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                Toast.makeText(SettingActivity.this, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }
        };

        new TedPermission(SettingActivity.this)
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .check();

    }
}
