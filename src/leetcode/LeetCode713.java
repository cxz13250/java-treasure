package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个正整数数组 nums。找出该数组内乘积小于 k 的连续的子数组的个数。
 * @Date: Created in 下午11:51 2018/7/20
 * @Modified By: *
 */
public class LeetCode713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k<=1){
            return 0;
        }
        int result=0;
        int i=0;
        long count=1L;
        for (int j=0;j<nums.length;j++){
             count*=nums[j];
             while (count>=k){
                 count/=nums[i];
                 i++;
             }
             result+=(j-i+1);
        }
        return result;
    }
}
