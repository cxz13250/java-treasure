package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个整数数列，找出其中和为特定值的那两个数。
 * @Date: Created in 下午10:10 2018/4/10
 * @Modified By:
 */
public class LeetCode1 {

    public static int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    result[0]=i;
                    result[1]=j;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[]={2, 7, 11, 15};
        int target=9;
        int[] result=twoSum(nums,target);
        System.out.print("[");
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]);
        }
        System.out.println("]");
    }
}
