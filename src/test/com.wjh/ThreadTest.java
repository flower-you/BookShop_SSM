package com.wjh;

/**
 * Author:   17976
 * Date:     2019/2/26 14:33
 * Description:
 */
public class ThreadTest {
    public static void main(String[] args){
        new  Thread(){
            @Override
            public void run() {
                while (true){
                        try {
                            System.out.println("The thead sleep........");
                            Thread.sleep(2*2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    for (int i=0;i<100;i++){
                        System.out.println("test-"+i);
                    }
                    break;
                }
            }
        }.start();
    }
}
