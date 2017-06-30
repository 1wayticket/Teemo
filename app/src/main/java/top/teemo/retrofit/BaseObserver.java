package top.teemo.retrofit;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/6/30.
 */

public abstract class BaseObserver<T> implements Observer<T> {
    public BaseObserver() {
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        onloadSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        onloadFailed(e);
    }

    @Override
    public void onComplete() {

    }
    protected abstract void onloadSuccess(T t);
    protected abstract void onloadFailed(Throwable e);
}
