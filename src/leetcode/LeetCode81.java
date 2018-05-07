package leetcode;

/**
 * @Author ROKG
 * @Description 假设按照升序排序的数组在预先未知的某个点上进行了旋转。( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * @Date: Created in 下午3:48 2018/5/5
 * @Modified By:
 */
public class LeetCode81 {

    public boolean search(int[] nums, int target) {
        if(nums.length<=0){
            return false;
        }
        if(nums.length==1){
            return nums[0]==target;
        }
        if(target==nums[0]){
            return true;
        }else if(target<nums[0]){
            int i=0;
            while (i<nums.length-1&&nums[i+1]>=nums[i]){
                i++;
            }
            if(i<nums.length-1){
                i++;
            }
            while (i<nums.length-1&&nums[i]<target){
                i++;
            }
            return nums[i]==target;
        }else {
            int i=0;
            while (i<nums.length-1&&nums[i]<target){
                i++;
            }
            return nums[i]==target;
        }
    }
}
