package leetcode;

import java.util.Arrays;

/**
 * @Author ROKG
 * @Description 已知一个 NxN 的国际象棋棋盘，棋盘的行号和列号都是从0开始。即最左上角的格子记为 (0, 0), 最右下角的记为 (N-1, N-1)。
 * 现有一个“马”（也译作“骑士”）位于 (r, c) ，并打算进行 K 次移动。
 * 如下图所示，国际象棋的“马”每一步先沿水平或垂直方向移动2个格子，然后向与之相垂直的方向再移动1个格子，共有8个可选的位置。
 * 现在“马”每一步都从可选的位置（包括棋盘外部的）中独立随机地选择一个进行移动，直到移动了 K 次或跳到了棋盘外面。
 * 求移动结束后，“马”仍留在棋盘上的概率。
 * @Date: Created in 2018/9/17
 * @Modified By: *
 */
public class LeetCode688 {

    int[][] moves={{-1,-2},{-2,-1},{-1,2},{-2,1},{1,-2},{2,-1},{1,2},{2,1}};

    // 可以使用三维数组，为了优化空间这里使用二维数组，
    // dp[i][j]表示从这点起跳有多少种合法路径，每次申请一个新的二维数组记录下本次移动后各点的计数覆盖dp
    public double knightProbability(int N, int K, int r, int c) {
        double[][] dp=new double[N][N];
        for (int i=0;i<N;i++){
            Arrays.fill(dp[i], 1);
        }
        for (int i=0;i<K;i++){
            double[][] temp=new double[N][N];
            for (int j=0;j<N;j++){
                for (int k=0;k<N;k++){
                    for (int[] move:moves){
                        int x=j+move[0];
                        int y=k+move[1];
                        if (x>=0&&x<N&&y>=0&&y<N){
                            temp[j][k]+=dp[x][y];
                        }
                    }
                }
            }
            dp=temp;
        }
        double res=dp[r][c]/Math.pow(8, K);
        return res;
    }



    public static void main(String[] args) {
        LeetCode688 l=new LeetCode688();
        System.out.println(l.knightProbability(8, 30, 6, 4));
    }
}
