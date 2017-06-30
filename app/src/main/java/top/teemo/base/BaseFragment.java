package top.teemo.base;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.Map;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import top.teemo.retrofit.ApiService;
import top.teemo.retrofit.BaseObserver;

/**
 * Created by Administrator on 2017/6/9.
 */

public abstract class BaseFragment<T> extends Fragment {
    public static final int SUCCESS = 1;
    public static final int FAIL = 0;
    public Context context;
    public View baseView;
    private Unbinder bind;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        baseView = inflater.inflate(setResourceId(), container, false);
        bind = ButterKnife.bind(this, baseView);
        onCreateView();
        return baseView;
    }

    protected abstract int setResourceId();

    protected abstract void onCreateView();

    public void sendHttp(Observable apiService, BaseObserver<T> observer){
        apiService.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }



}
