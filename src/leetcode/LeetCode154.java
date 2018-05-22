package leetcode;

/**
 * @Author ROKG
 * @Description 假设按照升序排序的数组在预先未知的某个点上进行了旋转。( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。注意数组中可能存在重复的元素。
 * @Date: Created in 下午2:17 2018/5/22
 * @Modified By:
 */
public class LeetCode154 {

    public int findMin(int[] nums) {
        if (nums.length==0){
            return -1;
        }
        if (nums.length==1){
            return nums[0];
        }
        int min=nums[0];
        int i=1;
        while (i<nums.length&&nums[i]>=min){
            i++;
        }
        if (i<nums.length) {
            return min < nums[i] ? min : nums[i];
        }else {
            return min;
        }
    }
}
