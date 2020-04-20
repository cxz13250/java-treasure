package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ROKG
 * @Description 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组
 * @Date: Created in 下午8:45 2018/4/16
 * @Modified By:
 */
public class LeetCode15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]>0){
                break;
            }
            if(i == 0 || (i>0&&nums[i]!=nums[i-1])){
                int l = i+1,r=nums.length-1,sum=0-nums[i];
                while(l<r){
                    if(nums[l]+ nums[r]==0-nums[i]){
                        result.add(Arrays.asList(nums[i],nums[l],nums[r]));
                        while(l<r&&nums[l]==nums[l+1]){
                            l++;
                        }
                        while(l<r&&nums[r]==nums[r-1]){
                            r--;
                        }
                        l++;
                        r--;
                    }else if(nums[l]+ nums[r]<0-nums[i]){
                        while(l<r&&nums[l]==nums[l+1]){
                            l++;
                        }
                        l++;
                    }else{
                        while(l<r&&nums[r]==nums[r-1]){
                            r--;
                        }
                        r--;
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        List<List<Integer>> res=new ArrayList<>();
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        if (map.get(0)>=3){
            List<Integer> list=new ArrayList<>();
            list.add(0);
            list.add(0);
            list.add(0);
            res.add(list);
        }
        for (int i:map.keySet()){
            for (int j:map.keySet()){
                if (i!=j){
                    map.put(i,map.get(i)-1);
                    map.put(j,map.get(j)-1);
                    int temp=0-(i+j);
                    if (map.get(temp)!=null&&map.get(temp)>0){
                        List<Integer> list=new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        list.add(temp);
                        res.add(list);
                    }
                    map.put(i,map.get(i)+1);
                    map.put(j,map.get(j)+1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
