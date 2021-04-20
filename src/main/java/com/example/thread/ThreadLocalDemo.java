package com.example.thread;

import java.util.Arrays;

/**
 * @Auther: cheng
 * @Date: 2021/4/11 13:25
 * @Description:
 */
public class ThreadLocalDemo {
    static class DemoClass {
        private ThreadLocal<Integer> i = new ThreadLocal<Integer>() {
            @Override
            protected Integer initialValue() {
                return 0;
            }
        };

        private Integer get() {
            return i.get();
        }

        private void set(Integer integer) {
            i.set(i.get() + integer);
        }
    }

    public static void main(String[] args) throws Exception{
        DemoClass demoClass = new DemoClass();
        for (int i = 1; i <= 10; i++) {
            new Thread(()->{
                for (int j = 1; j <= 10; j++) {
                    demoClass.set(j);
                }
                System.out.println(demoClass.get());
            }).start();
        }
        Thread.sleep(200000);
    }
}
