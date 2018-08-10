package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * @Date: Created in 2018/8/8
 * @Modified By: ***
 */
public class LeetCode324 {

    public void wiggleSort(int[] nums) {
        if (nums.length<=1){
            return;
        }
        int mid=new LeetCode215().findKthLargest2(nums, (nums.length+1)/2);
        int n=nums.length;
        int l=0,r=nums.length-1;
        int i=0;
        while (i<=r){
            if (nums[newIndex(i,n)]>mid){
                swap(nums,newIndex(i++,n),newIndex(l++,n));
            }else if (nums[newIndex(i,n)]<mid){
                swap(nums,newIndex(i,n),newIndex(r--,n));
            }else {
                i++;
            }
        }
    }

    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public int newIndex(int i,int n){
        return (1+2*i)%(n|1);
    }

    public static void main(String[] args) {
        LeetCode324 l =new LeetCode324();
        l.wiggleSort(new int[]{1,5,1,1,6,4});
    }
}
