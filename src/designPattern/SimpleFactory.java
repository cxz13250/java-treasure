package designPattern;

/**
 * @Author ROKG
 * @Description 简单工厂模式
 * @Date: Created in 2018/8/21
 * @Modified By:
 */
public class SimpleFactory {

    public Product create(String name){
        if ("A"==name){
            return new ProductA();
        }else if ("B"==name){
            return new ProductB();
        }
        return null;
    }
}
abstract class Product{

}
class ProductA extends Product{

}
class ProductB extends Product{

}
