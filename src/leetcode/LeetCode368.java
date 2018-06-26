package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给出一个由无重复的正整数组成的集合, 找出其中最大的整除子集, 子集中任意一对 (Si, Sj) 都要满足: Si % Sj = 0 或 Sj % Si = 0。
 * 如果有多个目标子集，返回其中任何一个均可。
 * @Date: Created in 下午1:16 2018/6/21
 * @Modified By: *
 */
public class LeetCode368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result=new ArrayList<>();
        Arrays.sort(nums);

        List[] lists=new List[nums.length];
        for (int i=0;i<nums.length;i++){
            lists[i]=new ArrayList<>();
            lists[i].add(nums[i]);
            for (int j=0;j<i;j++){
                if (nums[i]%nums[j]==0){
                    if (lists[j].size()>lists[i].size()){
                        lists[i]=new ArrayList<>(lists[j]);
                        lists[i].add(nums[i]);
                    }
                }
            }
            if (result.size()<lists[i].size()){
                result=new ArrayList<>(lists[i]);
            }
        }
        return result;
    }
}
