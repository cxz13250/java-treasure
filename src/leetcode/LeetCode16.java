package leetcode;

import java.util.Arrays;

/**
 * @Author ROKG
 * @Description 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
 * @Date: Created in 下午9:50 2018/4/16
 * @Modified By:
 */
public class LeetCode16 {

    public static int threeSumClosest(int[] nums, int target) {
        int result=-1;
        int diff=Integer.MAX_VALUE;
        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){
            while (i>1&&nums[i]==nums[i-1]&&i<nums.length-2){
                i++;
            }
            int j=i+1;
            int k=nums.length-1;
            while (j<k) {
                int a = nums[i];
                int b = nums[j];
                int c = nums[k];
                int sum = a + b + c;
                if(Math.abs(sum-target)<=diff){
                    diff=Math.abs(sum-target);
                    result=sum;
                }
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={-1,2,1,-4};
        int target=1;
        System.out.println(threeSumClosest(nums,target));
        int[] nums1={0,1,2};
        int target1=0;
        System.out.println(threeSumClosest(nums1,target1));
    }
}
