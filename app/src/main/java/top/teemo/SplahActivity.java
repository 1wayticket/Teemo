package top.teemo;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import top.teemo.base.BaseActivity;

/**
 * Created by Administrator on 2017/6/6.
 */

public class SplahActivity extends BaseActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_splash);
    }
}
