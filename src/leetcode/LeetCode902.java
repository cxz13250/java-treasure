package leetcode;

/**
 * @Author ROKG
 * @Description 我们有一组排序的数字 D，它是  {'1','2','3','4','5','6','7','8','9'} 的非空子集。（请注意，'0' 不包括在内。）
 * 现在，我们用这些数字进行组合写数字，想用多少次就用多少次。例如 D = {'1','3','5'}，我们可以写出像 '13', '551', '1351315' 这样的数字。
 * 返回可以用 D 中的数字写出的小于或等于 N 的正整数的数目。
 * @Date: Created in 2018/9/17
 * @Modified By: *
 */
public class LeetCode902 {

    // N的位数为n，位数小于n的所有情况都满足
    // 位数等于n的，dp[i]表示第i位之前的数字与N相同，i位之后的组合数，
    // 对于N中第i位数字，一次与D中数字比大小，相等dp[i]+=dp[i+1]
    // 小与N中第i位数字，则后续n-i-1位可以任意组合，dp[i]+=pow(m,n-i-1)
    public static int atMostNGivenDigitSet(String[] D, int N) {
        String nstr=String.valueOf(N);
        int n=nstr.length();
        int m=D.length;
        int[] dp=new int[n+1];
        dp[n]=1;
        int count=0;
        for (int i=1;i<n;i++){
            count+=Math.pow(m, i);
        }
        for (int i=n-1;i>=0;i--){
            int tmp=nstr.charAt(i)-'0';
            for (int j=0;j<m;j++){
                int tmp2=D[j].charAt(0)-'0';
                if (tmp>tmp2){
                    dp[i]+=Math.pow(m, n-i-1);
                }else if (tmp==tmp2){
                    dp[i]+=dp[i+1];
                }
            }
        }
        count+=dp[0];
        return count;
    }

    public static void main(String[] args) {
        System.out.println(atMostNGivenDigitSet(new String[]{"1","3","5","7"}, 100));
        System.out.println(atMostNGivenDigitSet(new String[]{"1","4","9"}, 1000000000));
    }
}
