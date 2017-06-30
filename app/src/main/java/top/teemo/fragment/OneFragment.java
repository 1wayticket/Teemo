package top.teemo.fragment;

import top.teemo.R;
import top.teemo.base.BaseFragment;

/**
 * Created by Administrator on 2017/6/9.
 */

public class OneFragment extends BaseFragment {
    public static OneFragment oneFragment;
    public static OneFragment getInstance(){
        if (oneFragment==null) {
            oneFragment = new OneFragment();
            return oneFragment;
        }else {
            return oneFragment;
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
