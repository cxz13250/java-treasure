package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * @Date: Created in 下午3:15 2018/7/14
 * @Modified By:
 */
public class LeetCode416 {

    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int i:nums){
            sum+=i;
        }
        if (sum%2!=0){
            return false;
        }
        int target=sum/2;
        boolean[] dp=new boolean[target+1];
        dp[0]=true;
        for (int n:nums){
            for (int i=target;i>=n;i--){
                if (dp[i-n]){
                    dp[i]=true;
                }
            }
        }
        return dp[target];
    }
}
