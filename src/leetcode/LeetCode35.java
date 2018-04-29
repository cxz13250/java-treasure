package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * @Date: Created in 下午10:30 2018/4/25
 * @Modified By:
 */
public class LeetCode35 {

    public int searchInsert(int[] nums, int target) {
        int i;
        for(i=0;i<nums.length;i++){
            if(nums[i]>=target){
                return i;
            }
        }
        return i;
    }
}
