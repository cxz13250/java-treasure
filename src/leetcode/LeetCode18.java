package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午11:54 2018/4/16
 * @Modified By:
 */
public class LeetCode18 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            while (i>1&&nums[i]==nums[i-1]&&i<nums.length-2){
                i++;
            }
            result.addAll(combine(nums[i],threeSum(nums,i+1,target-nums[i])));
        }
        return result.stream().distinct().collect(Collectors.toList());
    }

    public static List<List<Integer>> threeSum(int[] nums, int start, int target) {
        List<List<Integer>> ins=new ArrayList<>();

        for(int i=start;i<nums.length-2;i++){
            while (i>start&&nums[i]==nums[i-1]&&i<nums.length-2){
                i++;
            }
            int j=i+1;
            int k=nums.length-1;
            while (j<k) {
                int a = nums[i];
                int b = nums[j];
                int c = nums[k];
                int sum = a + b + c;
                if (sum == target) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(a);
                    temp.add(b);
                    temp.add(c);
                    ins.add(temp);
                    j++;
                    k--;
                    while (j<k&&nums[k]==nums[k+1]){
                        k--;
                    }
                    while (j<k&&nums[j]==nums[j-1]){
                        j++;
                    }
                } else if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return ins.stream().distinct().collect(Collectors.toList());
    }

    public static List<List<Integer>> combine(int first, List<List<Integer>> lists){
        List<List<Integer>> newList = new ArrayList<List<Integer>>();
        for (List<Integer> oldItem : lists){
            List<Integer> newItem = new ArrayList<Integer>();
            newItem.add(first);
            newItem.addAll(oldItem);
            newList.add(newItem);
        }
        return newList;
    }

    public static void main(String[] args) {
        int[] nums={-1,0,1,2,-1,-4};
        int target=-1;
        System.out.println(fourSum(nums,target));
    }
}
