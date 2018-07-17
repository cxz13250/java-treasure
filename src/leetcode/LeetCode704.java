package leetcode;

/**
 * @Author ROKG
 * @Description Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.
 * @Date: Created in 2018/7/17
 * @Modified By:
 */
public class LeetCode704 {

    public int search(int[] nums, int target) {
        if (nums.length==1){
            return nums[0]==target?0:-1;
        }
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]<target){
                left=mid+1;
            }else if (nums[mid]>target){
                right=mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
