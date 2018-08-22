package designPattern;

/**
 * @Author ROKG
 * @Description 抽象工厂模式
 * @Date: Created in 2018/8/21
 * @Modified By:
 */
public class AbstractFactory {

    interface Factory{

        Product1 createProduct1();
        Product2 createProduct2();
    }
    class FactoryA implements Factory{
        @Override
        public Product1 createProduct1(){
            return new Product1A();
        }
        @Override
        public Product2 createProduct2(){
            return new Product2A();
        }
    }
    class FactoryB implements Factory{
        @Override
        public Product1 createProduct1(){
            return new Product1B();
        }
        @Override
        public Product2 createProduct2(){
            return new Product2B();
        }
    }
    abstract class Product1{

    }
    class Product1A extends Product1{

    }
    class Product1B extends Product1{

    }
    abstract class Product2{

    }
    class Product2A extends Product2{

    }
    class Product2B extends Product2{

    }
}


