package employee;

/**
 * @Author ROKG
 * @Description 求一个整数二进制形式中1的个数
 * @Date: Created in 下午1:34 2018/4/4
 * @Modified By:
 */
public class BinaryCount {

    public int NumberOf1(int n) {
        int count = 0;
        while(n!= 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        BinaryCount count=new BinaryCount();
        System.out.println("15的二进制中1的个数为:"+count.NumberOf1(15));
    }

}
