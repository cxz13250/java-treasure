package designPattern;

/**
 * @Author ROKG
 * @Description 建造者模式 应用：JavaMail
 * @Date: Created in 下午11:15 2018/8/27
 * @Modified By:
 */
public class Builder {

    public static void main(String[] args) {
        AbstractBuilder builder=new ConcreteBuilder();
        builder.buildPart1();
        builder.buildPart2();
        builder.build();
    }
}
abstract class AbstractBuilder{

    public abstract void buildPart1();

    public abstract void buildPart2();

    public abstract Product build();
}
class ConcreteBuilder extends AbstractBuilder{

    private ProductA productA;

    @Override
    public void buildPart1(){

    }

    @Override
    public void buildPart2(){

    }

    @Override
    public Product build(){
        return productA;
    }
}

