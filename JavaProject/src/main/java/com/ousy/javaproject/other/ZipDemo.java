package com.ousy.javaproject.other;

import java.util.Arrays;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;

/**
 * @author ousiyuan
 * @date 2019/10/24
 */
public class ZipDemo {
    public static void main(String[] args) {
        Observable observable1 = Observable.just(1,2,3);

        Observable observablex = Observable.error(new Exception()).onErrorResumeNext(throwable -> observable1);
        Observable observable2 = Observable.just(7,8,9);
        observablex.zipWith(observable2, (num1, num2) -> num1+":"+num2)
        .subscribe(num -> System.out.println(num+""));
    }
}
