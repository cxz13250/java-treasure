package multiThreading;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午11:55 2018/7/30
 * @Modified By:
 */
public class MyThreadLocal extends ThreadLocal<Integer> {

    @Override
    protected Integer initialValue() {
        return null;
    }
}
