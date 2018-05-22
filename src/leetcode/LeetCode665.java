package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
 * @Date: Created in 下午2:49 2018/5/18
 * @Modified By: *
 */
public class LeetCode665 {

    public static boolean checkPossibility(int[] nums) {
        int i=0,j=nums.length-1;
        while (i<j&&nums[i]<=nums[i+1]){
            i++;
        }
        while (i<j&&nums[j-1]<=nums[j]){
            j--;
        }
        int left=0;
        if (i==0){
            left=Integer.MIN_VALUE;
        }else {
            left=nums[i-1];
        }
        int right=(j==nums.length-1)?Integer.MAX_VALUE:nums[j+1];
        if (j-i<=1&&(left<=nums[j]||right>=nums[i])){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nums={3,3,2,2};
        System.out.println(checkPossibility(nums));
    }
}
