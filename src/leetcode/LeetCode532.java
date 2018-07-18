package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description  给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
 * @Date: Created in 2018/7/18
 * @Modified By:
 */
public class LeetCode532 {

    public int findPairs(int[] nums, int k) {
        if (nums.length==0 || k<0){
            return 0;
        }
        int count=0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for (Map.Entry<Integer, Integer> entry:map.entrySet()){
            if (k==0){
                if (entry.getValue()>1){
                    count++;
                }
            }else {
                if (map.containsKey(entry.getKey()+k)){
                    count++;
                }
            }
        }
        return count;
    }
}
