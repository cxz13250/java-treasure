package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * @Date: Created in 下午11:45 2018/6/4
 * @Modified By: *
 */
public class LeetCode90 {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        if (nums.length==0){
            return result;
        }
        Arrays.sort(nums);
        result.add(new ArrayList<>());
        List<List<Integer>> flags=new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            if (i==0||nums[i]!=nums[i-1]){
                flags.clear();
                for (int j=0;j<result.size();j++){
                    List<Integer> list=new ArrayList<>(result.get(j));
                    list.add(nums[i]);
                    flags.add(list);
                }
                result.addAll(flags);
            }else {
                List<List<Integer>> temp=new ArrayList<>();
                for (int j=0;j<flags.size();j++) {
                    List<Integer> list = new ArrayList<>(flags.get(j));
                    list.add(nums[i]);
                    temp.add(list);
                }
                result.addAll(temp);
                flags=temp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
    }
}
