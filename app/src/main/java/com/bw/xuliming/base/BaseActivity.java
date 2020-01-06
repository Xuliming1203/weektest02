package com.bw.xuliming.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 时间：2020/1/6
 * 作者：徐黎明
 * 类的作用：
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView{
    public P presenter;
    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutid());
        bind = ButterKnife.bind(this);
        presenter=initPresenter();
        EventBus.getDefault().register(this);
        if (presenter != null) {
            presenter.attach(this);
        }
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P initPresenter();

    protected abstract int layoutid();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.deatch();
        }
        if (bind != null) {
            bind.unbind();
        }
        EventBus.getDefault().unregister(this);
    }
}
