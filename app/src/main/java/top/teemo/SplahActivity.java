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
    protected void onResume() {
        super.onResume();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    delayToFinish();
                    startActivity(new Intent(SplahActivity.this,MainActivity.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    startActivity(new Intent(SplahActivity.this,MainActivity.class));
                    delayToFinish();
                }

            }
        }).start();

    }
    public void delayToFinish(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    SplahActivity.this.finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
