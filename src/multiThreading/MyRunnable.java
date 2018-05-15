package multiThreading;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午8:17 2018/5/8
 * @Modified By:
 */
class MyRunnable implements Runnable{

    Temp t=null;

    MyRunnable(Temp t){
        this.t=t;
    }

    @Override
    public void run(){
        t.test++;
        System.out.println(System.currentTimeMillis()+" "+t.test);
    }
}
