package leetcode;


/**
 * @Author ROKG
 * @Description 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * @Date: Created in 上午11:49 2018/7/8
 * @Modified By: *多重背包问题
 */
public class LeetCode322 {

    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        for (int i=1;i<=amount;i++){
            dp[i]=Integer.MAX_VALUE;
            for (int j=0;j<coins.length;j++){
                if (i-coins[j]>=0&&dp[i-coins[j]]!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}
