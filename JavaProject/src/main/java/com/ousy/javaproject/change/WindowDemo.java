package com.ousy.javaproject.change;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * @author ousiyuan
 * @date 2019/9/30
 */
public class WindowDemo {
    public static void main(String[] args) {
        Observable.just(1,2,3,4,5,6,7,8,9).window(3).subscribe(new Observer<Observable<Integer>>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(Observable<Integer> integerObservable) {
                integerObservable.subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println(integer+"*");
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("里面完成");
                    }
                });
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {
                System.out.println("全部完成");
            }
        });
    }
}
