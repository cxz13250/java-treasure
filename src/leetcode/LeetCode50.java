package leetcode;

/**
 * @Author ROKG
 * @Description 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * @Date: Created in 下午6:17 2018/5/25
 * @Modified By: *
 */
public class LeetCode50 {

    public static double myPow(double x, int n) {
        if (n==0){
            return 1;
        }
        if (n<0){
            //当n为-2^31-1时，取反会越界
            if (n==Integer.MIN_VALUE){
                return 1.0/myPow(x,Integer.MAX_VALUE)/x;
            }else {
                return 1.0/myPow(x,-n);
            }
        }else {
            if (n%2==0){
                double temp=myPow(x,n >> 1);
                return temp*temp;
            }else {
                double temp=myPow(x,(n-1) >> 1);
                return temp*temp*x;
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(myPow(1.00001,123456));
    }
}
