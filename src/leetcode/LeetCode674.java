package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 * @Date: Created in 下午3:57 2018/5/19
 * @Modified By:
 */
public class LeetCode674 {

    public int findLengthOfLCIS(int[] nums) {
        int result=0;
        for (int i=0;i<nums.length;i++){
            int count=1;
            while (i<nums.length-1&&nums[i]<nums[i+1]){
                i++;
                count++;
            }
            result=Math.max(count,result);
        }
        return result;
    }
}
