package leetcode2;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午2:14 2024/2/7
 * @Modified By:
 */
public class Leet560_SubArraysSumToK {

    public static int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i : nums) {
            pre += i;
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }


    public static void main(String[] args) {
//        System.out.println(subarraySum(new int[]{9, 1, 9, 1, 1}, 2));
//        System.out.println(subarraySum(new int[]{9, 1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
//        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
//        System.out.println(subarraySum(new int[]{-1, -1, 1}, 0));
//        System.out.println(subarraySum(new int[]{100, 1, 2, 3, 4}, 6));
//        System.out.println(subarraySum(new int[]{1, -1, 0}, 0));
    }
}
