package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @Date: Created in 下午5:08 2018/5/7
 * @Modified By:
 */
public class LeetCode53 {

    public int maxSubArray(int[] nums) {
        int[] temp=new int[nums.length];
        int total=nums[0];
        temp[0]=nums[0];
        for (int i=1;i<nums.length;i++){
            temp[i]=Math.max(temp[i-1]+nums[i],nums[i]);
            total=Math.max(total,temp[i]);
        }
        return total;
    }
}
