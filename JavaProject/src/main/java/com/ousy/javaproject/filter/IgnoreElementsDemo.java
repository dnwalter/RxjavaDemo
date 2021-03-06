package com.ousy.javaproject.filter;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;

/**
 * @author ousiyuan
 * @date 2019/10/10
 */
public class IgnoreElementsDemo {
    public static void main(String[] args) {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                observableEmitter.onNext("1");
//                observableEmitter.onError(new Exception("异常测试"));
                observableEmitter.onComplete();
            }
        }).ignoreElements().subscribe(new Action() {
            @Override
            public void run() throws Throwable {
                System.out.println("完成");
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Throwable {
                System.out.println("异常");
            }
        });
    }
}
