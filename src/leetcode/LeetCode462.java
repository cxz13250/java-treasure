package leetcode;

import java.util.Arrays;

/**
 * @Author ROKG
 * @Description 给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一个元素加1或减1。 您可以假设数组的长度最多为10000。
 * @Date: Created in 上午2:40 2018/8/5
 * @Modified By:
 */
public class LeetCode462 {

    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int res=0;
        int i=0,j=nums.length-1;
        while (i<j){
            res+=nums[j--]-nums[i++];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(minMoves2(new int[]{1,2,3}));
    }
}
