package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，
 * 你都可以从 + 或 -中选择一个符号添加在前面。返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * @Date: Created in 下午4:56 2018/4/30
 * @Modified By:
 */
public class LeetCode494 {

    //递归求解，时间复杂度O(2^n)
    private static int result;

    public int findTargetSumWays(int[] nums, int S) {
        result=0;
        check(nums,0,0,S);
        return result;
    }

    public void check(int nums[],int index,int sum,int S){
        if(index==nums.length){
            if(sum==S){
                result++;
            }
            return;
        }
        check(nums,index+1,sum-nums[index],S);
        check(nums,index+1,sum+nums[index],S);
    }

    /**
     * 动态规划， result[i]表示子集合元素之和等于当前目标值的方案个数
     * 详见：https://blog.csdn.net/mine_song/article/details/70216562
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays2(int[] nums, int S){
        int sum=0;
        for (int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(S>sum || (sum+S)%2==1) {
            return 0;
        }
        int[] result=new int[(sum+S)/2+1];
        for (int i=0;i<nums.length;i++){
            for (int j=S;j>=nums[i];j--){
                result[j]+=result[j-nums[i]];
            }
        }
        return result[(sum+S)/2+1];
    }

    public static void main(String[] args) {

    }
}
