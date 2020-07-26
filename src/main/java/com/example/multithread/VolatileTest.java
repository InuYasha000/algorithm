//package com.example.multithread;
//
///**
// * @Auther: cheng
// * @Date: 2020/7/22 01:34
// * @Description:
// */
//public class VolatileTest {
////    public static volatile int i = 0;
////    public static int j = 0;
//    public void main(String[] args) throws Exception{
//        int i = 0;
//        int j = 0;
//        Thread thread1 = new Thread(()->{
//            for (int k = 0; k < 100; k++) {
//                i++;
//                j++;
//            }
//        });
//        Thread thread2 = new Thread(()->{
//            for (int k = 0; k < 100; k++) {
//                i++;
//                j++;
//            }
//        });
//        thread1.start();
//        thread2.start();
//        Thread.sleep(1000);
//        System.out.println(i);
//        System.out.println(j);
//    }
//}
