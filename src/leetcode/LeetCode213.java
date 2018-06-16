package leetcode;

/**
 * @Author ROKG
 * @Description 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * @Date: Created in 下午3:17 2018/6/1
 * @Modified By:
 */
public class LeetCode213 {

    public static int rob(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        int[] temp1=new int[nums.length];
        int[] temp2=new int[nums.length];
        temp1[0]=nums[0];
        temp1[1]=nums[0];
        for (int i=2;i<nums.length;i++){
            if (i==nums.length-1){
                temp1[i]=temp1[i-1];
            }else {
                temp1[i] = Math.max(temp1[i - 1], temp1[i - 2] + nums[i]);
            }
        }
        temp2[0]=0;
        temp2[1]=nums[1];
        for (int i=2;i<nums.length;i++){
            temp2[i]=Math.max(temp2[i-1],temp2[i-2]+nums[i]);
        }
        return Math.max(temp1[nums.length-1],temp2[nums.length-1]);
    }

    public static void main(String[] args) {
        int[] nums={2,3,2};
        System.out.println(rob(nums));
    }
}
