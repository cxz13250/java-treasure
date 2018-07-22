package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Description 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
 * 注意：
 * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
 * @Date: Created in 下午2:51 2018/7/21
 * @Modified By:
 */
public class LeetCode398 {

    class Solution {

        Map<Integer,List<Integer>> map =new HashMap<>();

        public Solution(int[] nums) {
            for (int i=0;i<nums.length;i++){
                if (map.containsKey(nums[i])){
                    map.get(nums[i]).add(i);
                }else {
                    List<Integer> list=new ArrayList<>();
                    list.add(i);
                    map.put(nums[i],list);
                }
            }
        }

        public int pick(int target) {
            if (!map.containsKey(target)){
                return -1;
            }
            List<Integer> list=map.get(target);
            return list.get(new Random().nextInt(list.size()));
        }
    }
}
