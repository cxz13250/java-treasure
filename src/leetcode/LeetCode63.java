package leetcode;

/**
 * @Author ROKG
 * @Description 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * @Date: Created in 上午11:39 2018/4/28
 * @Modified By: *
 */
public class LeetCode63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        if(m==0){
            return 0;
        }
        int n=obstacleGrid[0].length;
        if(m==1&&n==1){
            if(obstacleGrid[0][0]==1){
                return 0;
            }else {
                return 1;
            }
        }
        int result[][]=new int[m][n];
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]==0){
                result[i][0]=1;
            }else {
                break;
            }
        }
        for(int i=0;i<n;i++){
            if(obstacleGrid[0][i]==0){
                result[0][i]=1;
            }else {
                break;
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==0){
                    result[i][j] = result[i][j - 1] + result[i - 1][j];
                }
            }
        }
        return result[m-1][n-1];
    }

    public static void main(String[] args) {

    }
}
