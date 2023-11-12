package leetcode2;

import java.util.Arrays;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午4:28 2023/10/6
 * @Modified By:
 */
public class Leet16_NearestSumOfThree {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 1 && i < nums.length - 2 && nums[i] == nums[i - 1]) {
                i++;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int a = nums[i];
                int b = nums[left];
                int c = nums[right];
                int sum = a + b + c;
                if (Math.abs(sum - target) < diff) {
                    diff = Math.abs(sum - target);
                    result = sum;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
