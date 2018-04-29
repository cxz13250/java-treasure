package leetcode;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @Author ROKG
 * @Description 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使 nums [i] 和 nums [j] 的绝对差值最大为 t，并且 i 和 j 之间的绝对差值最大为 ķ。
 * @Date: Created in 下午5:12 2018/4/27
 * @Modified By:
 */
public class LeetCode220 {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> treeSet=new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            if((treeSet.floor(nums[i])!=null && (long)nums[i]-treeSet.floor(nums[i])<=t)||
                    (treeSet.ceiling(nums[i])!=null && treeSet.ceiling(nums[i])-nums[i]<=t)){
                return true;
            }
            treeSet.add(nums[i]);
            if(treeSet.size()>k){
                treeSet.remove(nums[i-k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[]={-1,2147483647};
        System.out.println(containsNearbyAlmostDuplicate(nums,1,2147483647));
    }
}
