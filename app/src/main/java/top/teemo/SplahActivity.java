package top.teemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;

import java.util.concurrent.Delayed;

import top.teemo.base.BaseActivity;

/**
 * Created by Administrator on 2017/6/6.
 */

public class SplahActivity extends BaseActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_splash);
        enableSwipeBack(false);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        SystemClock.sleep(3000);
        startActivity(new Intent(this,MainActivity.class));
    }
}
