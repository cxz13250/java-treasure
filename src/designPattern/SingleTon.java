package designPattern;

/**
 * @Author ROKG
 * @Description 单例模式
 * @Date: Created in 下午11:52 2018/8/2
 * @Modified By:
 */
public class SingleTon {

    //饿汉模式
    private static SingleTon s = new SingleTon();

    private SingleTon(){

    }

    public static SingleTon getInstance(){
        return s;
    }

    //懒汉模式，多线程环境下，不再是单例
    private static SingleTon s2;

    public static SingleTon getInstance2(){
        if (s2 == null){
            s2 = new SingleTon();
        }
        return s2;
    }

    //懒汉模式，线程安全
    public synchronized SingleTon getInstance3(){
        if (s2 == null){
            s2 = new SingleTon();
        }
        return s2;
    }

    public static SingleTon getInstance4() {
        synchronized (SingleTon.class){
            if (s2 == null){
                s2 = new SingleTon();
            }
            return s2;
        }
    }


}
