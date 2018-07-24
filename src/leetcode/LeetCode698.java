package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * @Date: Created in 2018/7/24
 * @Modified By:
 */
public class LeetCode698 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length==0){
            return false;
        }
        int sum=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i:nums){
            sum+=i;
            map.put(i,map.getOrDefault(i,0)+1);
        }
        if (sum%k!=0){
            return false;
        }
        int partition=sum/k;
        boolean[] visit=new boolean[nums.length];
        return dfs(nums,k,0,partition,0,visit);
    }

    public boolean dfs(int[] nums,int k,int start,int target,int cur,boolean[] visited ){
        if (k==1){
            return true;
        }else if (cur>target){
            return false;
        }else if (cur==target){
            return dfs(nums,k-1,0,target,0,visited);
        }else {
            for (int i=start;i<nums.length;i++){
                if (visited[i]==false){
                    visited[i]=true;
                    if (dfs(nums,k,i+1,target,cur+nums[i],visited)){
                        return true;
                    }
                    visited[i]=false;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
    }
}
