package com.bw.xuliming.base;

import java.lang.ref.WeakReference;

/**
 * 时间：2020/1/6
 * 作者：徐黎明
 * 类的作用：
 */
public abstract class BasePresenter<M extends IBaseModel,V extends IBaseView> {
    public M model;
    public WeakReference<V> weakReference;

    public BasePresenter() {
        model = initModel();
    }

    protected abstract M initModel();
    public void attach(V v){
        weakReference=new WeakReference<>(v);
    }
    public void deatch(){
        if (weakReference != null) {
            weakReference.clear();
            weakReference=null;
        }
    }
    public V getView(){
        return weakReference.get();
    }
}
