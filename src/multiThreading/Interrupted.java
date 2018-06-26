package multiThreading;

/**
 * @Author ROKG
 * @Description interrupted与isInterrupted区别
 * @Date: Created in 上午9:54 2018/6/17
 * @Modified By:
 */
public class Interrupted {

    public static void main(String[] args) {
        try {
            Thread.currentThread().interrupt();
            System.out.println("是否停止1? ="+Thread.interrupted());
            System.out.println("是否停止2? ="+Thread.interrupted());


            Thread m=new Thread();
            m.start();
            Thread.sleep(1000);
            m.interrupt();
            System.out.println("是否停止1? ="+m.isInterrupted());
            System.out.println("是否停止2? ="+m.isInterrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
