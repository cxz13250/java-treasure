package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author ROKG
 * @Description 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1 。
 * @Date: Created in 2018/8/6
 * @Modified By: *
 */
public class LeetCode542 {

    //从0开始扩散，使用队列
    public int[][] updateMatrix(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] res=new int[m][n];
        Queue<int[]> queue=new LinkedList<>();
        for (int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]==0){
                    queue.offer(new int[]{i,j});
                }else {
                    res[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        int[][] direct=new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        while (!queue.isEmpty()){
            int pos[] = queue.poll();
            for (int[] d:direct){
                int nx=pos[0]+d[0];
                int ny=pos[1]+d[1];
                if (nx<0||nx>=m||ny<0||ny>=n){
                    continue;
                }
                if (res[nx][ny]<=res[pos[0]][pos[1]]+1){
                    continue;
                }
                queue.offer(new int[]{nx,ny});
                res[nx][ny]=res[pos[0]][pos[1]]+1;
            }
        }
        return res;
    }



    public static void main(String[] args) {
        LeetCode542 l=new LeetCode542();
        System.out.println(l.updateMatrix(new int[][]{{0,1,1,0,0},{0,1,1,0,0},{0,1,0,0,1},{1,1,1,1,0},{1,0,0,1,0}}));
    }
}
