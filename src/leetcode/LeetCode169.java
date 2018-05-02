package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * @Date: Created in 下午3:39 2018/5/1
 * @Modified By:
 */
public class LeetCode169 {

    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        for (Integer integer:map.keySet()){
            if(map.get(integer)> nums.length/2){
                return integer;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
