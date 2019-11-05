package com.ousy.javaproject.assist;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;

/**
 * @author ousiyuan
 * @date 2019/11/5
 */
public class ToDemo {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4).toList().subscribe(new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> integers) throws Throwable {
                System.out.println(integers.get(3)+"++");
            }
        });

        // 还有toMap
    }
}
