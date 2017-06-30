package top.teemo.fragment;

import top.teemo.R;
import top.teemo.base.BaseFragment;

/**
 * Created by Administrator on 2017/6/9.
 */

public class TwoFragment extends BaseFragment {
    public static TwoFragment twoFragment;
    public static TwoFragment getInstance(){
        if (twoFragment==null) {
            twoFragment = new TwoFragment();
            return twoFragment;
        }else {
            return twoFragment;
        }
    }

    @Override
    protected int setResourceId() {
        return R.layout.fragment_zero;
    }
    @Override
    protected void onCreateView() {

    }


}
