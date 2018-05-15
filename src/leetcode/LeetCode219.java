package leetcode;

import java.util.TreeSet;

/**
 * @Author ROKG
 * @Description 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * @Date: Created in 上午11:39 2018/5/9
 * @Modified By:
 */
public class LeetCode219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        TreeSet<Integer> treeSet=new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            if(treeSet.contains(nums[i])){
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
        String str1 = "droid";
        String str2 = "droid";
        System.out.println(str1 == str2);
        String str3 = new String("droid");
        System.out.println(str1 == str3);
        String str4 = str3.intern();
        System.out.println(str4 == str1);
    }
}
