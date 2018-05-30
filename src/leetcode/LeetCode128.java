package leetcode;

import java.util.TreeSet;

/**
 * @Author ROKG
 * @Description 给定一个未排序的整数数组，找出最长连续序列的长度。要求算法的时间复杂度为 O(n)。
 * @Date: Created in 下午12:36 2018/5/27
 * @Modified By:
 */
public class LeetCode128 {

    public static int longestConsecutive(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        TreeSet<Integer> set=new TreeSet<>();
        for (int i:nums){
            set.add(i);
        }
        int result=1;
        int len=set.size();
        int pre=set.pollFirst();
        int count=1;
        for (int i=1;i<len;i++){
            int temp=set.pollFirst();
            if (temp==(++pre)){
                count++;
            }else {
                result=Math.max(result,count);
                pre=temp;
                count=1;
            }
        }
        result=Math.max(result,count);
        return result;
    }

    public static void main(String[] args) {
        int[] nums={0,-1};
        System.out.println(longestConsecutive(nums));
    }
}
