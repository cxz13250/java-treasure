package leetcode;

import java.util.Arrays;

/**
 * @Author ROKG
 * @Description 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 * @Date: Created in 2018/9/12
 * @Modified By:
 */
public class LeetCode611 {

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res=0;
        for (int i=0;i<nums.length-2;i++){
            for (int j=i+1;j<nums.length-1;j++){
                for (int l=j+1;l<nums.length;l++){
                    if (l>j+1&&nums[l]==nums[l-1]){
                        continue;
                    }
                    if (nums[l]>=nums[i]+nums[j]){
                        break;
                    }
                    if (nums[l]>Math.abs(nums[i]-nums[j])){
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{2,2,3,4}));
    }
}
