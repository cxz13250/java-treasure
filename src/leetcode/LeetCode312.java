package leetcode;

/**
 * @Author ROKG
 * @Description
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 * 求所能获得硬币的最大数量。
 * @Date: Created in 下午12:54 2018/8/20
 * @Modified By: *
 */
public class LeetCode312 {

    int res=0;

    // res[left][right]表示从left到right的气球能够达到的最大分数，i表示最后一个踩破的气球i
    // res[left][right]=max(res[left][right],arr[left]*arr[i]*arr[right]+res[left][i]+res[i][right]); 这一步使用分治
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[][] res=new int[n+2][n+2];
        int[] arr=new int[n+2];
        for (int i=1;i<=n;i++){
            arr[i]=nums[i-1];
        }
        arr[0]=arr[n+1]=1;
        for (int k=2;k<n+2;k++){
            for (int left=0;left<n+2-k;left++){
                int right=left+k;
                for (int i=left+1;i<right;i++){
                    res[left][right]=Math.max(res[left][right],arr[left]*arr[i]*arr[right]+res[left][i]+res[i][right]);
                }
            }
        }
        return res[0][n+1];
    }

    public static void main(String[] args) {
        LeetCode312 l=new LeetCode312();
        System.out.println(l.maxCoins(new int[]{7,9,8,0,7,1,3,5,5,2,3}));
    }
}
