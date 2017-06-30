package top.teemo.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import top.teemo.R;
import top.teemo.base.BaseFragment;
import top.teemo.kaiyan.mdeol.KaiYanBean;
import top.teemo.kaiyan.mdeol.KaiYanDiscover;
import top.teemo.myutils.LogUtil;
import top.teemo.retrofit.HttpStringUtil;
import top.teemo.retrofit.BaseObserver;
import top.teemo.retrofit.HttpUtil;


/**
 * Created by Administrator on 2017/6/9.
 */

public class ZeroFragment extends BaseFragment {
    public static ZeroFragment zeroFragment;
    public static ZeroFragment getInstance(){
        if (zeroFragment==null) {
            zeroFragment = new ZeroFragment();
            return zeroFragment;
        }else {
            return zeroFragment;
        }
    }
    @BindView(R.id.video_list)
    RecyclerView videoList;
    @Override
    protected int setResourceId() {
        return R.layout.fragment_zero;
    }
    @Override
    protected void onCreateView() {
        loadVideos();
        videoList.setLayoutManager(new LinearLayoutManager(context));
    }

    private void loadVideos() {
        sendHttp(HttpUtil.getInstance().getApiService().getKaiYanBean(new HashMap<String, String>())
                , new BaseObserver<KaiYanBean>() {
            @Override
            protected void onloadSuccess(KaiYanBean kaiYanBean) {
                LogUtil.logI(kaiYanBean.getNextPageUrl());
            }

            @Override
            protected void onloadFailed(Throwable e) {

            }
        });

    }


}
