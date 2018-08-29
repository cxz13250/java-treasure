package designPattern;

/**
 * @Author ROKG
 * @Description 策略模式
 * @Date: Created in 下午10:53 2018/8/26
 * @Modified By:
 */
public class Strategy {

    public static void main(String[] args) {
        AbstractStrategy a=new ConcreteStrategyA();
        Context context=new Context(a);
        context.operate();
    }
}
class Context{
    AbstractStrategy strategy;
    Context(AbstractStrategy strategy){
        this.strategy=strategy;
    }
    void operate(){
        this.strategy.operate();
    }
}
interface AbstractStrategy{
    void operate();
}
class ConcreteStrategyA implements AbstractStrategy{
    @Override
    public void operate(){
        System.out.println("A");
    }
}
class ConcreteStrategyB implements AbstractStrategy{
    @Override
    public void operate(){
        System.out.println("B");
    }
}
class ConcreteStrategyC implements AbstractStrategy{
    @Override
    public void operate(){
        System.out.println("C");
    }
}