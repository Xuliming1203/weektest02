package com.bw.xuliming.contracl;

import com.bw.xuliming.base.IBaseModel;
import com.bw.xuliming.base.IBaseView;

import java.util.HashMap;

/**
 * 时间：2020/1/6
 * 作者：徐黎明
 * 类的作用：
 */
public interface IContracl {
    interface IModel  {
        void getLeft(ModelCallBack modelCallBack);
        void getRight(HashMap<String,String> parmas,ModelCallBack modelCallBack);
        interface ModelCallBack {
            void success(Object o);
            void fshibai(Throwable throwable);
        }
    }
    interface IView  {
        void success(Object o);
        void fshibai(Throwable throwable);
    }
    interface IPresenter{
        void getLeft();
        void getRight(HashMap<String,String> parmas);
    }
}
