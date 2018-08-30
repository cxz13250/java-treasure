package designPattern;

/**
 * @Author ROKG
 * @Description 工厂方法模式
 * @Date: Created in 下午10:40 2018/8/26
 * @Modified By:
 */
public class FactoryMethod {

    interface Factory{
        Product createProduct();
    }

    class FactoryA implements Factory{
        @Override
        public Product createProduct(){
            return new ProductA();
        }
    }

    class FactoryB implements Factory{
        @Override
        public Product createProduct(){
            return new ProductB();
        }
    }
}
