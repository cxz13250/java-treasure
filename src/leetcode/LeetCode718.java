package leetcode;

/**
 * @Author ROKG
 * @Description 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * @Date: Created in 下午7:48 2018/6/17
 * @Modified By: *
 */
public class LeetCode718 {

    // dp[i][j]代表以A[i-1]与B[j-1]结尾的公共字串的长度
    public int findLength(int[] A, int[] B) {
         int[][] dp=new int[A.length+1][B.length+1];
         int result=0;
         for (int i=1;i<A.length+1;i++){
             for (int j=1;j<B.length+1;j++){
                 if (A[i-1]==B[j-1]){
                     dp[i][j]=dp[i-1][j-1]+1;
                 }
                 result=Math.max(dp[i][j],result);
             }
         }
         return result;
    }

}
