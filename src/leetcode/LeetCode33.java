package leetcode;

/**
 * @Author ROKG
 * @Description 假设按照升序排序的数组在预先未知的某个点上进行了旋转。( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。算法时间复杂度必须是 O(log n) 级别。
 * @Date: Created in 下午2:25 2018/5/2
 * @Modified By:
 */
public class LeetCode33 {

    public int search(int[] nums, int target) {
        if(nums.length<=0){
            return -1;
        }
        if(nums.length==1){
            return nums[0]==target?0:-1;
        }
        if(target==nums[0]){
            return 0;
        }else if(target<nums[0]){
            int i=0;
            while (i<nums.length-1&&nums[i+1]>nums[i]){
                i++;
            }
            if(i<nums.length-1){
                i++;
            }
            while (i<nums.length-1&&nums[i]<target){
                i++;
            }
            if(nums[i]==target){
                return i;
            }else {
                return -1;
            }
        }else {
            int i=0;
            while (i<nums.length-1&&nums[i]<target){
                i++;
            }
            if(nums[i]==target){
                return i;
            }else {
                return -1;
            }
        }
    }
}
