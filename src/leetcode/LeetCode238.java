package leetcode;

/**
 * @Author ROKG
 * @Description 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * @Date: Created in 下午9:27 2018/5/31
 * @Modified By: *
 */
public class LeetCode238 {

    public int[] productExceptSelf(int[] nums) {
        int[] result=new int[nums.length];
        result[0]=1;
        for (int i=1;i<nums.length;i++){
            result[i]=result[i-1]*nums[i-1];
        }
        int temp=1;
        for (int i=nums.length-2;i>=0;i--){
            temp*=nums[i+1];
            result[i]*=temp;
        }
        return result;
    }
}
