package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个表示分数的非负整数数组。 玩家1从数组任意一端拿取一个分数，随后玩家2继续从剩余数组任意一端拿取分数，然后玩家1拿，……。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 * 示例 1:
 * @Date: Created in 2018/7/30
 * @Modified By:
 */
public class LeetCode486 {

    //递归，玩家1选一个数视为+，玩家2选一个数视为-，看最终结果是否》=0
    public boolean PredictTheWinner(int[] nums) {
        return check(nums,0,nums.length-1)>=0;
    }

    public int check(int[] nums,int start,int end){
        if (start==end){
            return nums[start];
        }else {
            return Math.max(nums[start]-check(nums,start+1,end),nums[end]-check(nums,start,end-1));
        }
    }

    //动态规划,res[i][j]表示从i开始j结束两人结果差
    public boolean PredictTheWinner2(int[] nums) {
        int n=nums.length;
        int[][] res=new int[n][n];
        for (int i=0;i<n;i++){
            res[i][i]=nums[i];
        }
        for (int i=n-2;i>=0;i--){
            for (int j=i+1;j<n;j++){
                res[i][j]=Math.max(nums[i]-res[i+1][j],nums[j]-res[i][j-1]);
            }
        }
        return res[0][n-1]>=0;
    }
}
