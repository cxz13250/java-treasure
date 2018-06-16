package leetcode;

/**
 * @Author ROKG
 * @Description 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * @Date: Created in 下午2:00 2018/6/1
 * @Modified By: *
 */
public class LeetCode279 {

    public static int numSquares(int n) {
        if (n<=0){
            return 0;
        }
        int result[]=new int[n+1];
        result[0]=0;
        for (int i=1;i<=n;i++){
            int temp=Integer.MAX_VALUE;
            for (int j=1;j*j<=i;j++){
                temp=Math.min(temp,result[i-j*j]+1);
            }
            result[i]=temp;
        }
        return result[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(48));
    }
}
