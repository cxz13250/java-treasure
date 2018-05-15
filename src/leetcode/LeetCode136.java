package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * @Date: Created in 下午3:42 2018/5/11
 * @Modified By:
 */
public class LeetCode136 {

    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            map.put(nums[i],map.containsKey(nums[i])?map.get(nums[i])+1:1);
        }
        int result=0;
        for (Integer i:map.keySet()){
            if (map.get(i)==1){
                result=i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
