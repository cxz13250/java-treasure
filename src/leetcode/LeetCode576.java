package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个 m × n 的网格和一个球。球的起始坐标为 (i,j) ，你可以将球移到相邻的单元格内，或者往上、下、左、右四个方向上移动使球穿过网格边界。
 * 但是，你最多可以移动 N 次。找出可以将球移出边界的路径数量。答案可能非常大，返回 结果 mod 109 + 7 的值。
 * @Date: Created in 2018/8/16
 * @Modified By: *
 */
public class LeetCode576 {

    //res[i][j][step]表示从i,j出发走step步到边际path数，res[i][j][step]=res[i-1][j][step-1]+res[i][j-1][step-1]+res[i][j+1][step-1]+res[i+1][j][step-1];
    public int findPaths(int m, int n, int N, int i, int j) {
        int mod=1000000009;
        int[][][] res=new int[m][n][N+1];
        for (int step=1;step<=N;step++){
            for (int x=0;x<m;x++){
                for (int y=0;y<n;y++){
                    res[x][y][step]=((((x==0?1:res[x-1][y][step-1])+(y==0?1:res[x][y-1][step-1]))%mod+(x==m-1?1:res[x+1][y][step-1]))%mod+(y==n-1?1:res[x][y+1][step-1]))%mod;
                }
            }
        }
        return res[i][j][N];
    }
}
