package leetcode;

import java.util.Arrays;

/**
 * @Author ROKG
 * @Description 在一个大小在 (0, 0) 到 (N-1, N-1) 的2D网格 grid 中，除了在 mines 中给出的单元为 0，其他每个单元都是 1。网格中包含 1 的最大的轴对齐加号标志是多少阶？返回加号标志的阶数。如果未找到加号标志，则返回 0。
 * 一个 k" 阶由 1 组成的“轴对称”加号标志具有中心网格  grid[x][y] = 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，由 1 组成的臂。下面给出 k" 阶“轴对称”加号标志的示例。注意，只有加号标志的所有网格要求为 1，别的网格可能为 0 也可能为 1。
 * @Date: Created in 2018/9/25
 * @Modified By: *
 */
public class LeetCode764 {

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] grid = new int[N][N];
        for(int[] m:grid) {
            Arrays.fill(m, N);//初始化为较大值
        }
        for(int[] m:mines) {
            grid[m[0]][m[1]] = 0;
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0, k = N - 1, l = 0, r = 0, u = 0, d = 0; j < N; j++, k--) {
                grid[i][j] = Math.min(grid[i][j], l = (grid[i][j] == 0 ? 0 : l + 1));//由左至右
                grid[i][k] = Math.min(grid[i][k], r = (grid[i][k] == 0 ? 0 : r + 1));//由右至左
                grid[j][i] = Math.min(grid[j][i], u = (grid[j][i] == 0 ? 0 : u + 1));//由上至下
                grid[k][i] = Math.min(grid[k][i], d = (grid[k][i] == 0 ? 0 : d + 1));//由下至上
            }
        }
        int res = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                res = Math.max(res, grid[i][j]);
            }
        }
        return res;
    }
}
