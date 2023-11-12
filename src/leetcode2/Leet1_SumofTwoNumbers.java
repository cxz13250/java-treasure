package leetcode2;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 上午11:18 2023/7/29
 * @Modified By:
 */
public class Leet1_SumofTwoNumbers {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = valueIndexMap.get(target - nums[i]);
            if (index != null) {
                return new int[]{i, index};
            } else {
                valueIndexMap.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{3, 2, 4}, 6));
    }
}
