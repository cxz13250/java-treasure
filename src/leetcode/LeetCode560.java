package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * @Date: Created in 上午12:34 2018/5/4
 * @Modified By:
 */
public class LeetCode560 {

    public int subarraySum(int[] nums, int k) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j=i;j<nums.length;j++){
                count+=nums[j];
                if(count==k){
                    result++;
                }
            }
        }
        return result;
    }
}
