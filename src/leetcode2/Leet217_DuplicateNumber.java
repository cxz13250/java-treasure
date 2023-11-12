package leetcode2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午4:12 2023/11/4
 * @Modified By:
 */
public class Leet217_DuplicateNumber {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> tmp = new HashSet<>();
        for (int i : nums) {
            if (tmp.contains(i)) {
                return true;
            }
            tmp.add(i);
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
