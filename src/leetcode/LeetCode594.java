package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 * @Date: Created in 下午1:24 2018/5/9
 * @Modified By:
 */
public class LeetCode594 {

    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int result=0;
        while (i<nums.length){
            int temp=nums[i];
            int count=0;
            while (i<nums.length&&nums[i]==temp){
                count++;
                i++;
            }
            if (i<nums.length&&nums[i]==temp+1){
                int flag=i;
                while (i<nums.length&&nums[i]==temp+1){
                    i++;
                    count++;
                }
                result=Math.max(result,count);
                i=flag;
            }else {
                continue;
            }
        }
        return result;
    }

    public int findLHS2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for (int num : map.keySet()) {
            if (map.containsKey(num + 1)) {
                int tmp = map.get(num) + map.get(num + 1);
                max = Math.max(max, tmp);
            }
        }
        return max;
    }
}
