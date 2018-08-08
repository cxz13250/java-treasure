package multiThreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author ROKG
 * @Description CyclicBarrier,当等待线程数达到指定参数时，解除阻塞
 * @Date: Created in 下午8:43 2018/5/8
 * @Modified By:
 */
public class MyCyclicBarrier {

    //可能输出321，也可能123
    public static void main(String[] args) {
        CyclicBarrier c=new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println(3);
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();//计数加1
                }catch (BrokenBarrierException e){

                }catch (InterruptedException e){

                }
                System.out.println("1");
            }
        }).start();

        try{
            c.await();
        }catch (BrokenBarrierException e){

        }catch (InterruptedException e){

        }
        System.out.println("2");
    }
}
