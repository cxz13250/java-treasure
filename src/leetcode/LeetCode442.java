package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 * 找到所有出现两次的元素。你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 * @Date: Created in 上午12:34 2018/7/15
 * @Modified By: *
 */
public class LeetCode442 {

    //组内hash
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result=new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            int temp=Math.abs(nums[i])-1;
            if (nums[temp]<0){
                result.add(temp+1);
            }
            nums[temp]=-nums[temp];
        }
        return result;
    }
}
