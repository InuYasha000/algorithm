package com.example.jvm;

/**
 * @Auther: cheng
 * @Date: 2020/9/5 15:47
 * @Description:
 */
public class Main3 {
    public static void main(String[] args) throws Exception{
        Thread.sleep(30000);
        while (true){
            load();
        }
    }

    private static void load() throws Exception{
        byte[] data = null;
        for (int i = 0; i < 50; i++) {
            data = new byte[100*1024];
        }
        data = null;
        Thread.sleep(1000);
    }
}
