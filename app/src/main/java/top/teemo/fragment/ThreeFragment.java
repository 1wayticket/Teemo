package top.teemo.fragment;

import top.teemo.R;
import top.teemo.base.BaseFragment;

/**
 * Created by Administrator on 2017/6/9.
 */

public class ThreeFragment extends BaseFragment {
    public static ThreeFragment threeFragment;
    public static ThreeFragment getInstance(){
        if (threeFragment==null) {
            threeFragment = new ThreeFragment();
            return threeFragment;
        }else {
            return threeFragment;
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
