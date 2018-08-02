package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 * @Date: Created in 2018/8/2
 * @Modified By: *
 */
public class LeetCode417 {

    int[] positionX={0,1,0,-1};
    int[] positionY={1,0,-1,0};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result=new ArrayList<>();
        int m=matrix.length;
        if (m==0){
            return result;
        }
        int n=matrix[0].length;
        if (n==0){
            return result;
        }
        boolean[][] Pacific=new boolean[m][n];
        boolean[][] Atlantic=new boolean[m][n];
        for (int i=0;i<m;i++){
            check(Pacific,matrix,i,0);
            check(Atlantic,matrix,i,n-1);
        }
        for (int i=0;i<n;i++){
            check(Pacific,matrix,0,i);
            check(Atlantic,matrix,m-1,i);
        }
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (Pacific[i][j]&&Atlantic[i][j]){
                    result.add(new int[]{i,j});
                }
            }
        }
        return result;
    }

    public void  check(boolean[][] visited,int[][] matrix,int x,int y){
        visited[x][y]=true;
        for (int i=0;i<4;i++){
            int nx=x+positionX[i];
            int ny=y+positionY[i];
            if (nx>=0&&nx<visited.length&&ny>=0&&ny<visited[0].length){
                if (!visited[nx][ny]&&matrix[nx][ny]>=matrix[x][y]){
                    check(visited,matrix,nx,ny);
                }
            }
        }
    }
}
