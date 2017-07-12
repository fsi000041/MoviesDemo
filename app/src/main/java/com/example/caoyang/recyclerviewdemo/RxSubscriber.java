package com.example.caoyang.recyclerviewdemo;


import rx.Subscriber;

/**
 * Created by wuwei on 2016/12/19.
 */

public abstract class RxSubscriber<T> extends Subscriber<T> {
    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();

        if (!NetUtils.isNetworkConnected(App.getContext())) {
            _onError("网络不可用!");
            return;
        }
        if (e instanceof NullPointerException) {
            _onError("内容对象为空");
        }else{
            _onError("请求失败，请稍后重试...");
        }
    }

    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    public abstract void _onNext(T t);

    public abstract void _onError(String msg);
}
