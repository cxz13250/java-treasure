package leetcode2;

import java.util.Arrays;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午12:22 2024/1/27
 * @Modified By:
 */
public class Leet2974_MinimunNumber {

    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i+1] = temp;
        }
        return nums;
    }
}
