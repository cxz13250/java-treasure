package leetcode;

/**
 * @Author ROKG
 * @Description 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * @Date: Created in 下午3:57 2018/5/31
 * @Modified By:*
 */
public class LeetCode221 {

    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        if (m==0){
            return 0;
        }
        int n=matrix[0].length;
        if (n==0){
            return 0;
        }
        int[][] dp=new int[m][n];
        for (int i=0;i<n;i++){
            dp[0][i]=matrix[0][i]-'0';
        }
        for (int i=0;i<m;i++){
            dp[i][0]=matrix[i][0]-'0';
        }
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                if (matrix[i][j]=='1'){
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
        int side=0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                side=Math.max(side,dp[i][j]);
            }
        }
        return side*side;
    }
}
