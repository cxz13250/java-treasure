package leetcode;

import java.util.Arrays;

/**
 * @Author ROKG
 * @Description 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 * 你需要返回给定数组中的重要翻转对的数量。
 * @Date: Created in 2018/8/16
 * @Modified By: *
 */
public class LeetCode493 {

    int cnt = 0;

    // 归并排序
    public int reversePairs(int[] nums) {
        if(nums.length==0) {
            return 0;
        }
        merge_sort(nums, 0, nums.length-1);
        return cnt;
    }

    public void merge(int[]nums, int start, int mid, int end){
        int left = start, right = mid + 1;
        while(left <= mid && right <= end){
            if((long)nums[left] <= (long)2 * nums[right]){
                left++;
            }else{
                cnt += mid - left + 1;
                right++;
            }
        }
        Arrays.sort(nums,start,end+1);
    }

    public void merge_sort(int[] nums, int start, int end){
        if(start >= end) {
            return;
        }
        int mid = start + (end-start)/2;
        merge_sort(nums, start, mid);
        merge_sort(nums, mid+1, end);
        merge(nums, start, mid, end);
    }

    public static void main(String[] args) {
        LeetCode493 code493 = new LeetCode493();
        System.out.println(code493.reversePairs(new int[]{1,2,3,2,1}));
        System.out.println(code493.reversePairs(new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647}));
    }
}
