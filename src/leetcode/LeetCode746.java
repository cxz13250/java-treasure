package leetcode;

/**
 * @Author ROKG
 * @Description 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 * @Date: Created in 下午7:09 2018/5/26
 * @Modified By:
 */
public class LeetCode746 {

    public static int minCostClimbingStairs(int[] cost) {
        int[] nums=new int[cost.length+2];
        nums[0]=0;
        nums[1]=0;
        nums[2]=0;
        for (int i=3;i<nums.length;i++){
            nums[i]=Math.min(nums[i-1]+cost[i-2],nums[i-2]+cost[i-3]);
        }
        return nums[nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums={10, 15, 20};
        System.out.println(minCostClimbingStairs(nums));
    }
}
