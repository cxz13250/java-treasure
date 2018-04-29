package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个未排序的数组，请判断这个数组中是否存在长度为3的递增的子序列。
 * @Date: Created in 下午1:09 2018/4/27
 * @Modified By:
 */
public class LeetCode334 {

    public static boolean increasingTriplet(int[] nums) {
        if(nums.length<3){
            return false;
        }
        int min=nums[0];
        int minS=-1;
        for(int i=1;i<nums.length;i++){
            if(min>nums[i]){
                min=nums[i];
            }
            else if(min<nums[i]){
                if(minS==-1||nums[i]<minS){
                    minS=nums[i];
                }else if(nums[i]>minS){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[]={2,5,1,6};
        System.out.println(increasingTriplet(nums));
    }
}
