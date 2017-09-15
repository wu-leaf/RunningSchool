package cn.edu.gdou.www.runningschool.ui.fragments.dialogfragment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.edu.gdou.www.runningschool.R;
import cn.edu.gdou.www.runningschool.ui.activity.SettingActivity;


public class CustomInputIntroFragment extends DialogFragment implements DialogInterface.OnKeyListener, View.OnClickListener{

    private TextView cancle;
    private TextView commit;
    private EditText mEditText;

    private View view;
    public static final String TAG = "customIntro";

    public static CustomInputIntroFragment newInstance() {
        Bundle bundle = new Bundle();
        CustomInputIntroFragment dFragment = new CustomInputIntroFragment();
        dFragment.setArguments(bundle);
        return dFragment;
    }

    public void getEditTextValueFromSetting(String name){
        if(!name.isEmpty()){
            mEditText.setHint(name);
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.DialogStyle);
    }

    @Override
    public void onStart() {
        super.onStart();
        initDialog();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialog_custom_intro, container, false);

        init();//实例化

        return view;
    }

    private void init() {
       cancle = (TextView) view.findViewById(R.id.intro_cancel);
       commit = (TextView) view.findViewById(R.id.intro_commit);
        mEditText = (EditText) view.findViewById(R.id.edit_intro);
        cancle.setOnClickListener(this);
        commit.setOnClickListener(this);
    }

    private void initDialog() {
        Window window = getDialog().getWindow();
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int width = (int) (metrics.widthPixels); //DialogSearch的宽
        int height = (int) (metrics.heightPixels*0.25);//高度
        window.setLayout(width, height);
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.DialogEmptyAnimation);//取消过渡动画 , 使DialogSearch的出现更加平滑
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.intro_cancel){
            Toast.makeText(getActivity(),"取消",Toast.LENGTH_SHORT).show();
            dismiss();
        }else if (view.getId() == R.id.intro_commit){

            String name = mEditText.getText().toString();
            if(!name.isEmpty()){
                ((SettingActivity)getActivity()).setNameByDialog(name);
                dismiss();
            }else{
                Toast.makeText(getActivity(),"没有介绍就找不到女朋友了",Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    public boolean onKey(DialogInterface anInterface, int i, KeyEvent event) {
        return false;
    }
}
