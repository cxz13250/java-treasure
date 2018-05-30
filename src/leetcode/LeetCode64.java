package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * @Date: Created in 上午11:48 2018/5/24
 * @Modified By:
 */
public class LeetCode64 {

    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if (m==0&&n==0){
            return 0;
        }
        int[][] result=new int[m][n];
        result[0][0]=grid[0][0];
        for (int i=1;i<n;i++){
            result[0][i]=result[0][i-1]+grid[0][i];
        }
        for (int i=1;i<m;i++){
            result[i][0]=result[i-1][0]+grid[i][0];
        }
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                result[i][j]=Math.min(result[i-1][j],result[i][j-1])+grid[i][j];
            }
        }
        return result[m-1][n-1];
    }
}
