package com.ousy.javaproject.create;

/**
 * @author ousiyuan
 * @date 2019/9/30
 */
public class EmptyNeverThrowDemo {
    public static void main(String[] args) {
        new EmptyDemo().create();
        new NeverDemo().create();
        new ThrowDemo().create();
    }
}
