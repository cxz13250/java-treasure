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

    /**
     * 连续的数做与运算，最后得到是公共前缀对应的数，所以只要找到m和n的公共前缀
     * @param m
     * @param n
     * @return
     */
    public static int rangeBitwiseAnd2(int m, int n) {
        int count =0;
        for (;m!=n;count++){
            m>>=1;
            n>>=1;
        }
        return m<<count;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5,7));
//        System.out.println(rangeBitwiseAnd(0,2147483647));
    }
}
