package leetcode;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午7:17 2018/5/1
 * @Modified By:
 */
public class LeetCode453 {

    public static int minMoves(int[] nums) {
        int min=nums[0];
        for(int i=1;i<nums.length;i++){
            min=Math.min(min,nums[i]);
        }
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=(nums[i]-min);
        }
        return sum;
    }

    public static void main(String[] args) {
    }
}
