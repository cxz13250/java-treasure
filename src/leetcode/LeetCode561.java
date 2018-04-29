package leetcode;

import java.util.Arrays;

/**
 * @Author ROKG
 * @Description 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 * @Date: Created in 下午8:14 2018/4/26
 * @Modified By:
 */
public class LeetCode561 {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result=0;
        for(int i=0;i<nums.length;i+=2){
            result+=nums[i];
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
