package com.ousy.javaproject.filter;

import com.ousy.javaproject.change.entity.Student;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;

/**
 * @author ousiyuan
 * @date 2019/10/9
 */
public class DistinctDemo {
    public static void main(String[] args) {
        // 过滤全列表重复
        // 基本类型会自动比较
        Observable.just(1, 2, 1, 1, 2, 3)
                .distinct()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer s) throws Exception {
                        System.out.println(s + "*");
                    }
                });

        Student[] students = {new Student("1"), new Student("2"), new Student("1"),new Student("1"), new Student("2"),new Student("3")};
        Observable.fromArray(students)
                .distinct(student -> student.getName())
                .subscribe(student -> System.out.println(student.getName() + "*"));

//        Observable.fromArray(students)
//                .distinct(new Function<Student, String>() {
//                    @Override
//                    public String apply(Student student) throws Throwable {
//                        return student.getName();
//                    }
//                })
//                .subscribe(new Consumer<Student>() {
//                    @Override
//                    public void accept(Student s) throws Exception {
//                        System.out.println(s.getName() + "*");
//                    }
//                });

        // 过滤连续重复
        Observable.just(1, 2, 1, 1, 2, 3)
                .distinctUntilChanged()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer s) throws Exception {
                        System.out.println(s + "*");
                    }
                });
    }
}
