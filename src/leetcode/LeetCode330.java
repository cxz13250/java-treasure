package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个已排序的正整数数组 nums，和一个正整数 n 。从 [1, n] 区间内选取任意个数字补充到 nums 中，使得 [1, n] 区间内的任何数字都可以用 nums 中某几个数字的和来表示。请输出满足上述要求的最少需要补充的数字个数。
 * @Date: Created in 2018/8/23
 * @Modified By: **
 */
public class LeetCode330 {

    // 贪心算法，
    public int minPatches(int[] nums, int n) {
        long miss=1;
        int count=0;
        int i=0;
        while (miss<=n){
            if (i<nums.length&&nums[i]<=miss){
                miss+=nums[i++];
            }else  {
                miss <<= 1;
                count++;
            }
        }
        return count;
    }
}
