package com.ousy.javaproject.condition;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * @author ousiyuan
 * @date 2019/11/7
 */
public class SkipUntilDemo {
    public static void main(String[] args) {
        Observable observable1 = Observable.intervalRange(1, 4, 0,1, TimeUnit.SECONDS, Schedulers.trampoline());
        Observable observable2 = Observable.intervalRange(10, 4, 2,1, TimeUnit.SECONDS, Schedulers.newThread());
        observable1.skipUntil(observable2).subscribe(num -> System.out.println(num+"*"));
    }
}
