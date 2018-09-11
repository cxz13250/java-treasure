package leetcode;

import java.util.Arrays;

/**
 * @Author ROKG
 * @Description 给定一个未排序的整数数组，找到最长递增子序列的个数。
 * @Date: Created in 下午11:57 2018/8/29
 * @Modified By: *
 */
public class LeetCode673 {

    // dp[i]表示从0到i元素中中最长递增子序列的长度，初始都为1
    // res[i]表示从0到i元素中中最长递增子序列的个数，初始都为1
    // 当nums[j]<nums[i]，存在两种情况，第一种：dp[j]+1>dp[i];说明前j个元素最长递增子序列长度+1>前i个元素最长递增子序列长度,需要更新dp[i]为dp[j]+1;并且res[i]=res[j]
    // 第二种dp[j]+1==dp[i]，说明出现了长度与dp[i]相等的新的子序列，则res[i]+=res[j]
    public static int findNumberOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        int[] res=new int[nums.length];
        Arrays.fill(dp,1);
        Arrays.fill(res,1);
        int count=0;
        int max=1;
        for (int i=1;i<nums.length;i++){
            for (int j=0;j<i;j++){
                if (nums[j]<nums[i]&&dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                    res[i]=res[j];
                }else if (nums[j]<nums[i]&&dp[j]+1==dp[i]){
                    res[i]+=res[j];
                }
            }
            max=Math.max(max,dp[i]);
        }
        for (int i=0;i<nums.length;i++) {
            if (dp[i]==max) {
                count += res[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[]{1,3,5,4,7}));
    }
}
