package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * @Date: Created in 上午12:34 2018/5/4
 * @Modified By:
 */
public class LeetCode560 {

    // 累积和，sum[j]-sum[i]=k
    public int subarraySum(int[] nums, int k) {
        int result=0;
        int sum =0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for (int i=0;i<nums.length;i++){
            sum+=nums[i];
            if (map.containsKey(sum-k)){
                result+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return result;
    }
}
