package leetcode;

/**
 * @Author ROKG
 * @Description峰值元素是指其值大于左右相邻值的元素。给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * @Date: Created in 下午12:19 2018/5/27
 * @Modified By:
 */
public class LeetCode162 {

    public static int findPeakElement(int[] nums) {
        if (nums.length==1){
            return 0;
        }
        if (nums.length==2){
            return nums[0]>nums[1]?0:1;
        }
        if (nums[0]>nums[1]){
            return 0;
        }
        for (int i=1;i<nums.length-1;i++){
            if (nums[i]<=nums[i-1]){
                if (nums[i+1]>nums[i]){
                    continue;
                }else {
                    i++;
                }
            }else {
                if (nums[i+1]<nums[i]){
                    return i;
                }
            }
        }
        if (nums[nums.length-1]>nums[nums.length-2]){
            return nums.length-1;
        }
        return -1;
    }

    //二分找最大值，最大的那个值一定是峰值
    public static int findPeakElement2(int[] nums){
        int l=0;
        int r=nums.length-1;
        while (l<r){
            int mid=l+(r-l)/2;
            if (nums[mid]>nums[mid+1]){
                r=mid;
            }else {
                l=mid+1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums={1,2,6,6};
        System.out.println(findPeakElement(nums));
    }
}
