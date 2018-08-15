package leetcode;

import java.util.Arrays;

/**
 * @Author ROKG
 * @Description 给定一个32位正整数 n，你需要找到最小的32位整数，其与 n 中存在的位数完全相同，并且其值大于n。如果不存在这样的32位整数，则返回-1。
 * @Date: Created in 下午12:09 2018/8/15
 * @Modified By: *
 */
public class LeetCode556 {

    public static int nextGreaterElement(int n) {
        if (n<10){
            return -1;
        }
        String value=String.valueOf(n);
        int[] nums=new int[value.length()];
        for (int i=0;i<value.length();i++){
            nums[i]=value.charAt(i)-'0';
        }
        int targetIndex=-1,swpIndex=0;
        for (int i=nums.length-2;i>=0;i--){
            if (nums[i+1]>nums[i]){
                targetIndex=i;
                break;
            }
        }
        if (targetIndex<0){
            return -1;
        }
        for (int i=nums.length-1;i>targetIndex;i--){
            if (nums[i]>nums[targetIndex]){
                swpIndex=i;
                break;
            }
        }
        int temp=nums[targetIndex];
        nums[targetIndex]=nums[swpIndex];
        nums[swpIndex]=temp;
        Arrays.sort(nums,targetIndex+1,nums.length);
        long res=0;
        for (int i=0;i<nums.length;i++){
            res=res*10+nums[i];
        }
        return res>Integer.MAX_VALUE?-1:(int)res;
    }

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(12));
        System.out.println(nextGreaterElement(21));
    }
}
