package leetcode;

import java.util.Arrays;
import java.util.Properties;

/**
 * @Author ROKG
 * @Description 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间，包括 1 和 n ，可知至少存在一个重复的整数。
 * 假设只有一个重复的整数，找出这个重复的数。
 * @Date: Created in 下午7:32 2018/5/26
 * @Modified By: *
 */
public class LeetCode287 {

    public static int findDuplicate(int[] nums) {
        int l=0,r=nums.length-1;
        int mid;
        while (l<=r){
            mid=l+(r-l)/2;
            int count=0;
            for (int i:nums){
                if (i<=mid){
                    count++;
                }
            }
            if (count<=mid){
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int nums[]={1,1};
    }
}
