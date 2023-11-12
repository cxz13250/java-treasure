package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * @Date: Created in 下午11:34 2018/4/30
 * @Modified By:
 */
public class LeetCode152 {

    //O(n)
    public static int maxProduct(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int max, min;  // 到i-1为止的最大连续乘积和最小乘积
        int result = Integer.MIN_VALUE;
        max = min =1;
        for(int i=0;i<nums.length;i++){
            if (nums[i]<0){  // 如果nums[i]为负数，那最大和最小就需要交换
               int temp = max;
               max = min;
               min = temp;
            }
            max = Math.max(nums[i], nums[i]*max);
            min = Math.min(nums[i], nums[i]*min);
            result=Math.max(max,result);
        }
        return result;
    }

    //O(n)
    public static int maxProduct2(int[] nums) {
        int min[]=new int[nums.length];
        int max[]=new int[nums.length];
        int result;
        result=min[0]=max[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            min[i]=Math.min(nums[i],Math.min(min[i-1]*nums[i],max[i-1]*nums[i]));
            max[i]=Math.max(nums[i],Math.max(min[i-1]*nums[i],max[i-1]*nums[i]));
            result=Math.max(max[i],result);
        }
        return result;

    }

    public static void main(String[] args) {
        int nums[]={-4,-3,-2};
        System.out.println(maxProduct(nums));
    }
}


