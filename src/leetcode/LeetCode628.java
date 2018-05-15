package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * @Date: Created in 上午12:33 2018/5/11
 * @Modified By:
 */
public class LeetCode628 {

    private static int temp=1;

    public int maximumProduct(int[] nums) {
        if (nums.length<3){
            return 0;
        }
        if (nums.length==3){
            return nums[0]*nums[1]*nums[2];
        }
        Arrays.sort(nums);
        int temp1=nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        if (nums[0]<0&&nums[1]<0){
            int temp2=nums[0]*nums[1]*nums[nums.length-1];
            return Math.max(temp1,temp2);
        }else {
            return temp1;
        }
    }

    public static void main(String[] args) {
    }
}
