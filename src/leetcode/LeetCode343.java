package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * 例如，给定 n = 2，返回1（2 = 1 + 1）；给定 n = 10，返回36（10 = 3 + 3 + 4）。
 * 注意：你可以假设 n 不小于2且不大于58。
 * @Date: Created in 下午11:36 2018/7/4
 * @Modified By:
* */
public class LeetCode343 {

    //动态规划，result[n]=max(i*result[n-i],i*(n-i))，（i从1到n-1）
    public static int integerBreak(int n) {
        int result[]=new int[n+1];
        result[1]=1;
        result[2]=1;
        for (int i=3;i<=n;i++){
            result[i]=-1;
            for (int j=1;j<i;j++){
                result[i]=Math.max(j*result[i-j],Math.max(result[i],j*(i-j)));
            }
        }
        return result[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(24));
    }
}
