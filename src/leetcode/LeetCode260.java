package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其他所有元素均出现两次。 找出只出现一次的那两个元素。
 * @Date: Created in 下午4:19 2018/5/4
 * @Modified By:
 */
public class LeetCode260 {

    public int[] singleNumber(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int[] result=new int[2];
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])){
                list.remove(Integer.valueOf(nums[i]));
            }else {
                list.add(nums[i]);
            }
        }
        for (int i=0;i<2;i++){
            result[i]=list.get(i);
        }
        return result;
    }
}
