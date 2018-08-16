package multiThreading;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 2018/8/13
 * @Modified By:
 */
public class MyInvoke {

    public static void main(String[] args) {
        hello h=new helloImpl();
        myInvocationHandler handler=new myInvocationHandler(h);
        hello p=(hello) Proxy.newProxyInstance(helloImpl.class.getClassLoader(),helloImpl.class.getInterfaces() , handler);
        p.sayHello();
    }
}
interface hello{
    void sayHello();
}

class helloImpl implements hello {
    @Override
    public void sayHello(){
        System.out.println("hahaha");
    }
}

class myInvocationHandler implements InvocationHandler{

    private Object target;
    myInvocationHandler(Object o){
        target=o;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)throws Throwable{
        System.out.println("start");
        Object result=method.invoke(target,args);
        return result;
    }
}
