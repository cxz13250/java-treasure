package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * @Date: Created in 2018/7/30
 * @Modified By:
 */
public class LeetCode200 {

    public int numIslands(char[][] grid) {
        int res=0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]=='1'){
                    res++;
                    check(grid,i,j);
                }
            }
        }
        return res;
    }

    public void check(char[][] grid,int i,int j){
        if (i<0||i>=grid.length||j<0||j>=grid[0].length){
            return;
        }
        if (grid[i][j]=='1'){
            grid[i][j]='2';
            check(grid,i-1,j);
            check(grid,i+1,j);
            check(grid,i,j-1);
            check(grid,i,j+1);
        }
    }
}
