package leetcode;

/**
 * @Author ROKG
 * @Description 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * @Date: Created in 下午4:15 2018/5/5
 * @Modified By:
 */
public class LeetCode198 {

    public static int rob(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        int[] sums=new int[nums.length];
        sums[0]=nums[0];
        sums[1]=Math.max(nums[0],nums[1]);
        for (int i=2;i<nums.length;i++){
            sums[i]=Math.max(sums[i-2]+nums[i],sums[i-1]);
        }
        return sums[nums.length-1];
    }

    public static void main(String[] args) {
        int[] num={1,1,1};
        System.out.println(rob(num));
    }
}
