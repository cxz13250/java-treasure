package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * @Date: Created in 下午11:30 2018/5/4
 * @Modified By:
 */
public class LeetCode448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums.length==0){
            return new ArrayList<>();
        }
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            int temp=Math.abs(nums[i])-1;
            if(nums[temp]>0){
                nums[temp]=-nums[temp];
            }
        }
        for (int i=0;i<nums.length;i++){
            if(nums[i]>0){
                list.add(i+1);
            }
        }
        return list;
    }
}
