package com.ousy.javaproject.merge;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * @author ousiyuan
 * @date 2019/10/10
 */
public class JoinDemo {
    public static void main(String[] args) {
        Observable observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                observableEmitter.onNext(1);
                Thread.sleep(1000);
                observableEmitter.onNext(2);
                Thread.sleep(1000);
                observableEmitter.onNext(3);
                Thread.sleep(1000);
                observableEmitter.onNext(4);
            }
        });
        Observable observable2 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                observableEmitter.onNext(7);
                Thread.sleep(1000);
                observableEmitter.onNext(8);
                /**
                 * 打印7简称y7，发送7简称7
                 * 睡1000时
                 *    1s    1s   1s
                 * y7————y8————7————8
                 *        1————2————3————4
                 * 在打印8的同时，第二个observable开始发送数据
                 * 在打印7和发送7之间，第二个Observable发送了1（其中2和7算同时发，不包括在内），故输出了7:1
                 * 在打印8和发送8之间，第二个Observable发送了1,2（其中3和8算同时发，不包括在内），故输出了8:1,8:2
                 *
                 * 睡2000时
                 *       2s         2s
                 * y7————————y8和7————————8
                 *              1————2————3————4
                 * 在打印8的同时，第二个observable开始发送数据
                 * 在打印7和发送7之间，没任何第二个发送的数据，故7组合没输出
                 * 在打印8和发送8之间，第二个Observable发送了1,2（其中3和8算同时发，不包括在内），故输出了8:1,8:2
                 *
                 *
                 * 附--上面睡眠1000的情况，如果想改成8:3输出，就直接修改2和3的输出间隔为500就可以，下面分析
                 *    1s    1s   1s
                 * y7————y8————7————8
                 *        1————2——3————4
                 */
            }
        });

        observable2.join(observable1, num -> {
                    System.out.println(num + "+");
//                    return Observable.empty();
                    return Observable.timer(2000, TimeUnit.MILLISECONDS);
                }, num -> {
                    System.out.println(num + "-");
                    return Observable.empty();
//                    return Observable.timer(1000, TimeUnit.MILLISECONDS);
                },
                //结合上面发射的数据
                (num1, num2) -> num1 +":"+ num2)
                .subscribe(s -> System.out.println(s));
    }
}
