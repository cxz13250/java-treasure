package leetcode;

/**
 * @Author ROKG
 * @Description 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * @Date: Created in 上午11:37 2018/5/24
 * @Modified By:
 */
public class LeetCode62 {

    public int uniquePaths(int m, int n) {
        if (m==0&&n==0){
            return 0;
        }
        int[][] result=new int[m][n];
        for (int i=0;i<n;i++){
            result[0][i]=1;
        }
        for (int i=0;i<m;i++){
            result[i][0]=1;
        }
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                result[i][j]=result[i-1][j]+result[i][j-1];
            }
        }
        return result[m-1][n-1];
    }
}
