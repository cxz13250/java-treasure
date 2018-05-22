package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Description 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * @Date: Created in 下午4:08 2018/5/18
 * @Modified By:
 */
public class LeetCode697 {

    public static int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int max=0;
        for (Integer i:map.values()){
            max=Math.max(max,i);
        }
        List<Integer> list=new ArrayList<>();
        for (Integer i:map.keySet()){
            if (map.get(i)==max){
                list.add(i);
            }
        }
        int result=Integer.MAX_VALUE;
        for (int i=0;i<list.size();i++){
            int l=0;
            while (nums[l]!=list.get(i)){
                l++;
            }
            int r=nums.length-1;
            while (nums[r]!=list.get(i)){
                r--;
            }
            result=Math.min(result,r-l+1);
        }
        return result;
    }

    public static int findShortestSubArray2(int[] num){
        Map<Integer,List<Integer>> map=new HashMap<>();
        for (int i=0;i<num.length;i++){
            if (map.containsKey(num[i])){
                map.get(num[i]).add(i);
            }else {
                List<Integer> list=new ArrayList<>();
                list.add(i);
                map.put(num[i],list);
            }
        }
        int length=0;
        for (List<Integer> list:map.values()){
            length=Math.max(length,list.size());
        }
        int result=Integer.MAX_VALUE;
        for (Integer i:map.keySet()){
            if (map.get(i).size()==length) {
                List<Integer> list = map.get(i);
                result = Math.min(result, list.get(list.size() - 1) - list.get(0) + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={1,2,2,3,1};
        System.out.println(findShortestSubArray(nums));
    }
}
