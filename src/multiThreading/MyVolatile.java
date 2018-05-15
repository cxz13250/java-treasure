package multiThreading;

import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午7:41 2018/5/8
 * @Modified By:
 */
public class MyVolatile {

    public static void main(String[] args) {
        Temp t=new Temp();
        MyRunnable m=new MyRunnable(t);
        MyRunnable n=new MyRunnable(t);
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        executorService.submit(m);
        executorService.submit(n);
        System.out.println(t.test);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat();
    }
}
class Temp{

    volatile int test=0;
}
