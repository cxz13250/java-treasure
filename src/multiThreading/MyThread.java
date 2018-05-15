package multiThreading;

import java.util.concurrent.CountDownLatch;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午10:44 2018/5/8
 * @Modified By:
 */
public class MyThread extends Thread{

    private CountDownLatch countDownLatch;

    MyThread(CountDownLatch countDownLatch){
        this.countDownLatch=countDownLatch;
    }

    @Override
    public void run(){
        try{
            System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
            Thread.sleep(3000);
            System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
            countDownLatch.countDown();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
