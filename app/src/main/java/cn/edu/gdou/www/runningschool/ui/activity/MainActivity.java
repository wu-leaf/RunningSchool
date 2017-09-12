package cn.edu.gdou.www.runningschool.ui.activity;

import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import cn.edu.gdou.www.runningschool.R;

public class MainActivity extends AppCompatActivity {
    long ExitTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void login(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }
    public void register(View view){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
    public void forget(View view){
        Intent intent = new Intent(this,ForgetAndResetActivity.class);
        startActivity(intent);

    }




    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 4 || event.getRepeatCount() != 0) {
            return super.onKeyDown(keyCode, event);
        }
        if (System.currentTimeMillis() - this.ExitTime > 2000) {


            this.ExitTime = System.currentTimeMillis();
            Toast.makeText(this,"再按一次退出应用",Toast.LENGTH_SHORT).show();
        } else {
            finish();
        }
        return true;
    }
}
