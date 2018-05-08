package leetcode;

/**
 * @Author ROKG
 * @Description 给定范围 [m,n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含m, n两端点）。
 * @Date: Created in 下午12:13 2018/5/7
 * @Modified By: *
 */
public class LeetCode201 {

    public static int rangeBitwiseAnd(int m, int n) {
        while (n>m){
            n=n&(n-1);
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(0,2147483647));
    }
}
