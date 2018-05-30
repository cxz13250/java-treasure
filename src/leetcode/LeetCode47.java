package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ROKG
 * @Description 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * @Date: Created in 下午10:11 2018/5/24
 * @Modified By:
 */
public class LeetCode47 {

    Map<Integer,Integer> map=new HashMap<>();

    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        for (int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        check(new ArrayList<>(),nums);
        return result;
    }

    public void check(List<Integer> list,int[] nums){
        if (list.size()==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (map.get(nums[i])<=0){
                continue;
            }
            list.add(nums[i]);
            map.put(nums[i],map.get(nums[i])-1);
            check(list,nums);
            list.remove(list.size()-1);
            map.put(nums[i],map.get(nums[i])+1);
            while (i<nums.length-1&&nums[i]==nums[i+1]){
                i++;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode47 l=new LeetCode47();
        int[] nums={3,3,0,3};
        System.out.println(l.permuteUnique(nums));
    }
}
