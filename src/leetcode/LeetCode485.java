package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个二进制数组， 计算其中最大连续1的个数。
 * @Date: Created in 下午9:03 2018/5/2
 * @Modified By:
 */
public class LeetCode485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int result=0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]==1) {
                int count=1;
                while (i < nums.length - 1 && nums[i+1]==1){
                    i++;
                    count++;
                }
                result=Math.max(result,count);
            }
        }
        return result;
    }
}
