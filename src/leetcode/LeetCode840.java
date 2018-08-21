package leetcode;

/**
 * @Author ROKG
 * @Description 3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
 * 给定一个由整数组成的 N × N 矩阵，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
 * @Date: Created in 2018/8/21
 * @Modified By:
 */
public class LeetCode840 {

    public int numMagicSquaresInside(int[][] grid) {
        if (grid.length<3 || grid[0].length<3){
            return 0;
        }
        int res=0;
        for (int i=0;i<grid.length-2;i++){
            for (int j=0;j<grid[0].length-2;j++){
                if (check(grid, i, j)){
                    res++;
                }
            }
        }
        return res;
    }

    public boolean check(int[][] grid,int x,int y){
        if (x+2>=grid.length || y+2>=grid[0].length){
            return false;
        }
        int row1=grid[x][y]+grid[x][y+1]+grid[x][y+2];
        int row2=grid[x+1][y]+grid[x+1][y+1]+grid[x+1][y+2];
        if (row1!=row2){
            return false;
        }
        int row3=grid[x+2][y]+grid[x+2][y+1]+grid[x+2][y+2];
        if (row1!=row3){
            return false;
        }
        int col1=grid[x][y]+grid[x+1][y]+grid[x+2][y];
        if (row1!=col1){
            return false;
        }
        int col2=grid[x][y+1]+grid[x+1][y+1]+grid[x+2][y+1];
        if (row1!=col2){
            return false;
        }
        int col3=grid[x][y+2]+grid[x+1][y+2]+grid[x+2][y+2];
        if (row1!=col3){
            return false;
        }
        int val1=grid[x][y]+grid[x+1][y+1]+grid[x+2][y+2];
        if (row1!=val1){
            return false;
        }
        int val2=grid[x][y+2]+grid[x+1][y+1]+grid[x+2][y];
        if (row1!=val2){
            return false;
        }
        return true;
    }
}
