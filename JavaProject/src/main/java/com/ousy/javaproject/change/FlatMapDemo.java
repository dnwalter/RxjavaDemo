package com.ousy.javaproject.change;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;

/**
 * @author ousiyuan
 * @date 2019/9/30
 */
public class FlatMapDemo {
    public static void main(String[] args) {
        Observable.just(1,2,3).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Throwable {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < integer; i++){
                    list.add(integer);
                }
                return  Observable.fromIterable(list).map(num -> num+"+");
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Throwable {
                System.out.println(s+"*");
            }
        });
    }
}
