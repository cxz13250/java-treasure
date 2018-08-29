package multiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author ROKG
 * @Description Semaphore  常用于限制获取某种资源的线程数量,两种模式公平与非公平，基于AQS
 * @Date: Created in 下午8:43 2018/5/8
 * @Modified By:
 */
public class MySemaphore {

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
        Semaphore semaphore=new Semaphore(3);
        for (int i=0;i<10;i++){
            try{
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }
            Runnable runnable=new Runnable() {
                @Override
                public void run() {
                    try{
                        semaphore.acquire();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread().getName() +
                            "进入，当前已有" + (3-semaphore.availablePermits()) + "个并发");
                    try{
                        Thread.sleep((long)(Math.random()*10000));
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread().getName() +
                            "即将离开");
                    semaphore.release();
                    System.out.println("线程" + Thread.currentThread().getName() +
                            "已离开，当前已有" + (3-semaphore.availablePermits()) + "个并发");
                }
            };
            executorService.submit(runnable);
        }
    }
}
