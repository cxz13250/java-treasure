package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组。
 * @Date: Created in 下午9:51 2018/5/2
 * @Modified By:
 */
public class LeetCode525 {

    public int findMaxLength(int[] nums) {
        if(nums.length<2){
            return 0;
        }
        int result=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                sum++;
            }else {
                sum--;
            }
            if(map.containsKey(sum)){
                result=Math.max(result,i-map.get(sum));
            }else {
                map.put(sum,i);
            }
        }
        return result;
    }

}
