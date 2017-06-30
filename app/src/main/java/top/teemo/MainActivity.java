package top.teemo;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import top.teemo.base.BaseActivity;
import top.teemo.base.BaseFragment;
import top.teemo.fragment.OneFragment;
import top.teemo.fragment.ThreeFragment;
import top.teemo.fragment.TwoFragment;
import top.teemo.fragment.ZeroFragment;
import top.teemo.myutils.LogUtil;
import top.teemo.myutils.ToastUtil;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    @BindView(R.id.frame)
    FrameLayout frameLayout;
    @BindView(R.id.index)
    RadioGroup index;
    @BindView(R.id.index_zero)
    RadioButton indexZero;
    @BindView(R.id.index_one)
    RadioButton indexOne;
    @BindView(R.id.index_two)
    RadioButton indexTwo;
    @BindView(R.id.index_three)
    RadioButton indexThree;
    private List<BaseFragment> fragments;
    private FragmentTransaction transaction;
    private android.app.Fragment showFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enableSwipeBack(false);
        index.setOnCheckedChangeListener(this);
        fragments=new ArrayList<>();
        fragments.add(ZeroFragment.getInstance());
        fragments.add(OneFragment.getInstance());
        fragments.add(TwoFragment.getInstance());
        fragments.add(ThreeFragment.getInstance());
        transaction = getFragmentManager().beginTransaction();
        showFragment=fragments.get(0);
        transaction.add(R.id.frame, fragments.get(0));
        transaction.commit();
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        transaction=getFragmentManager().beginTransaction();
        transaction.hide(showFragment);
        if (checkedId==indexZero.getId()) {
            showFragment=fragments.get(0);
        }else if (checkedId==indexOne.getId()){
            showFragment=fragments.get(1);
        }
        else if(checkedId==indexTwo.getId()){
            showFragment=fragments.get(2);
        }
        else if(checkedId==indexThree.getId()){
            showFragment=fragments.get(3);
        }else {
            ToastUtil.error(this,"软件错误");
        }
        transaction.add(R.id.frame,showFragment);
//        transaction.commit();
    }
}
