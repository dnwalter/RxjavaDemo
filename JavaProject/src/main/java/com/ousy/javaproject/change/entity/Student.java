package com.ousy.javaproject.change.entity;

/**
 * @author ousiyuan
 * @date 2019/9/30
 */
public class Student extends Person{
    public Student(String s){
        name = s;
    }

    public String getName(){
        return name;
    }
}
