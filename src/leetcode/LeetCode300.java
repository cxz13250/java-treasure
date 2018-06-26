package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * @Date: Created in 下午12:54 2018/6/19
 * @Modified By: *
 */
public class LeetCode300 {

    public int lengthOfLIS(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int result=0;
        int[] dp=new int[nums.length];
        for (int i=0;i<nums.length;i++){
            dp[i]=1;
            for (int j=0;j<i;j++){
                if (nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            result=Math.max(dp[i],result);
        }
        return result;
    }
}
