package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Description 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 * @Date: Created in 2018/7/27
 * @Modified By:
 */
public class LeetCode491 {

    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> list=new ArrayList<>();
        check(list,0,nums);
        return result;
    }

    public void check(List<Integer> list,int index,int[] nums){
        if (list.size()>=2){
            result.add(new ArrayList<>(list));
        }
        if (index>=nums.length){
            return;
        }
        Set<Integer> set=new HashSet<>();
        for (int i=index;i<nums.length;i++){
            if ((list.size()==0||nums[i]>=list.get(list.size()-1))&&!set.contains(nums[i])){
                set.add(nums[i]);
                list.add(nums[i]);
                check(list,i+1,nums);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode491 l=new LeetCode491();
        int[] nums={4, 6, 7, 7};
        System.out.println(l.findSubsequences(nums));
    }
}
