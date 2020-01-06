package com.bw.xuliming.model;

import com.bw.xuliming.api.ClsService;
import com.bw.xuliming.contracl.IContracl;
import com.bw.xuliming.entity.LeftEntity;
import com.bw.xuliming.entity.RigthEntity;
import com.bw.xuliming.utils.RetrofitUtil;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 时间：2020/1/6
 * 作者：徐黎明
 * 类的作用：
 */
public class Model implements IContracl.IModel {

    @Override
    public void getLeft(ModelCallBack modelCallBack) {
        RetrofitUtil.getInstance().createservice(ClsService.class)
                .getleft()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LeftEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LeftEntity leftEntity) {
                        if (modelCallBack != null) {
                            modelCallBack.success(leftEntity);
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (modelCallBack != null) {
                            modelCallBack.fshibai(e);
                        }

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getRight(HashMap<String, String> parmas, ModelCallBack modelCallBack) {
        RetrofitUtil.getInstance().createservice(ClsService.class)
                .getright(parmas)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RigthEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RigthEntity rigthEntity) {
                    modelCallBack.success(rigthEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        modelCallBack.fshibai(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
