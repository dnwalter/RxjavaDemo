package com.ousy.javaproject.assist;

import com.ousy.javaproject.change.entity.Person;
import com.ousy.javaproject.change.entity.Student;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;

/**
 * @author ousiyuan
 * @date 2019/11/5
 */
public class UsingDemo {
    public static void main(String[] args) {
        Observable.using(new Supplier<Student>() {
            @Override
            public Student get() throws Throwable {
                Student student = new Student("aaa");
                return student;
            }
        }, new Function<Student, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Student student) throws Throwable {
                return Observable.just(student.getName());
            }
        }, new Consumer<Student>() {
            @Override
            public void accept(Student student) throws Throwable {
                System.out.println(student.getName()+"++");

            }
        }).subscribe(str -> System.out.println(str+"*"));
    }
}
