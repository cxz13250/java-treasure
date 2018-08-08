package multiThreading;

import java.util.concurrent.CountDownLatch;

/**
 * @Author ROKG
 * @Description CountDownLatch 只允许指定参数个线程执行，后续调用await()的线程会阻塞直到前面的线程执行完毕
 * @Date: Created in 下午8:43 2018/5/8
 * @Modified By:
 */
public class MyCountDownLatch {

    public static void main(String[] args) {
        CountDownLatch countDownLatch=new CountDownLatch(2);
        MyThread t1=new MyThread(countDownLatch);
        MyThread t2=new MyThread(countDownLatch);
        MyThread t3=new MyThread(countDownLatch);
        t1.start();
        t2.start();
        t3.start();
        try{
            System.out.println("等待2个子线程执行完毕...");
            countDownLatch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
