package leetcode;

import java.util.Arrays;

/**
 * @Author ROKG
 * @Description 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的子数组。如果不存在符合条件的子数组，返回 0。
 * @Date: Created in 下午2:34 2018/5/23
 * @Modified By:
 */
public class LeetCode209 {

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums.length<=1){
            return 0;
        }
        int result=Integer.MAX_VALUE;
        int sum=0;
        int i=0;
        int len=0;
        while (i<nums.length){
            if (sum<s){
                sum+=nums[i];
                len++;
                i++;
            }else {
                result=Math.min(len,result);
                sum-=nums[i-len];
                len--;
            }
        }
        boolean change=false;
        while (sum>=s){
            change=true;
            sum-=nums[nums.length-len];
            len--;
        }
        if (change){
            result=Math.min(len+1,result);
        }
        return result==Integer.MAX_VALUE?0:result;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        System.out.println(minSubArrayLen(11,nums));
    }
}
