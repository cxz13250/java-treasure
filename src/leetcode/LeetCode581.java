package leetcode;

import java.util.Arrays;

/**
 * @Author ROKG
 * @Description 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 你找到的子数组应是最短的，请输出它的长度。
 * @Date: Created in 下午3:17 2018/5/1
 * @Modified By:
 */
public class LeetCode581 {

    public int findUnsortedSubarray(int[] nums) {
        int[] temp=Arrays.copyOf(nums,nums.length);
        Arrays.sort(temp);
        int i=0;
        int j=nums.length-1;
        while (i<nums.length&&nums[i]==temp[i]){
            i++;
        }
        while (j>0&&nums[j]==temp[j]){
            j--;
        }
        if(i<j) {
            return Math.abs(j-i)+1;
        }else{
            return 0;
        }
    }
}
