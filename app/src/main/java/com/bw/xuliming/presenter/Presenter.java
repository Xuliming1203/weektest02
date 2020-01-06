package com.bw.xuliming.presenter;

import com.bw.xuliming.base.BasePresenter;
import com.bw.xuliming.contracl.IContracl;
import com.bw.xuliming.model.Model;

import java.util.HashMap;

/**
 * 时间：2020/1/6
 * 作者：徐黎明
 * 类的作用：
 */
public class Presenter  implements IContracl.IPresenter {
    private Model model;
    private IContracl.IView iView;

    public Presenter(IContracl.IView iView) {
        this.iView = iView;
        this.model=new Model();
    }

    @Override
    public void getLeft() {
        model.getLeft(new IContracl.IModel.ModelCallBack() {
            @Override
            public void success(Object o) {
                iView.success(o);
            }

            @Override
            public void fshibai(Throwable throwable) {
                iView.fshibai(throwable);
            }
        });
    }

    @Override
    public void getRight(HashMap<String, String> parmas) {
        model.getRight(parmas, new IContracl.IModel.ModelCallBack() {
            @Override
            public void success(Object o) {
                iView.success(o);
            }

            @Override
            public void fshibai(Throwable throwable) {
                iView.fshibai(throwable);
            }
        });
    }


}
