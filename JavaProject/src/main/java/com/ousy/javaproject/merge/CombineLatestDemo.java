package com.ousy.javaproject.merge;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.BiFunction;

/**
 * @author ousiyuan
 * @date 2019/10/10
 * 试了很多，不管怎么睡眠，都是第一个observable的最后一条数据和第二个的observable所有结合
 */
public class CombineLatestDemo {
    public static void main(String[] args) {
        Observable observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                observableEmitter.onNext(1);
                observableEmitter.onNext(2);
                observableEmitter.onNext(3);
                observableEmitter.onNext(4);
            }
        });
        Observable observable2 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                observableEmitter.onNext(7);
                observableEmitter.onNext(8);
            }
        });

        Observable.combineLatest(observable1, observable2, new BiFunction<Integer, Integer, String>() {
            @Override
            public String apply(Integer num1, Integer num2) throws Throwable {
                return num1 +""+ num2;
            }
        }).subscribe(s -> System.out.println(s));
    }
}
