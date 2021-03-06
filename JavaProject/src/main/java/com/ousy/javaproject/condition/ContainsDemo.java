package com.ousy.javaproject.condition;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Predicate;

/**
 * @author ousiyuan
 * @date 2019/11/6
 * // 发射的数据中是否包含contains里面的数据
 */
public class ContainsDemo {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4).contains(2).subscribe(num -> System.out.println(num+"*"));
    }
}
