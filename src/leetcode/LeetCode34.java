package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。你的算法时间复杂度必须是 O(log n) 级别。如果数组中不存在目标值，返回 [-1, -1]。
 * @Date: Created in 下午5:39 2018/5/8
 * @Modified By:
 */
public class LeetCode34 {

    public static int[] searchRange(int[] nums, int target) {
        int[] result=new int[2];
        result[0]=-1;
        result[1]=-1;
        int temp=-1;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==target){
                if (temp==-1){
                    temp=i;
                    result[0]=i;
                    result[1]=i;
                }else {
                    result[1]++;
                }
            }else if (nums[i]>target){
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        System.out.println(searchRange(nums,8));
    }
}
