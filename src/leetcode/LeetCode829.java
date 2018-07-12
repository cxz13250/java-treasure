package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个正整数 N，试求有多少组连续正整数满足所有数字之和为 N?
 * @Date: Created in 下午5:41 2018/7/2
 * @Modified By:
 */
public class LeetCode829 {

    // a为数组起始元素，有(a+a+(i-1))*i/2=N，a为正整数，公式转换得a=N/i-(i-1)/2，i<0.5+根号下(2*N+0.25)
    public static int consecutiveNumbersSum(int N) {
        int result=0;
        double temp=0.5+Math.sqrt(2*N+0.25);
        for (int i=1;i<temp;i++){
            double a= (double) N/i-(double)(i-1)/2;
            if (a == Math.floor(a)){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(consecutiveNumbersSum(5));
    }
}
