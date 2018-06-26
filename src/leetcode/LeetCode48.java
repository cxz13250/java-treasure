package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * @Date: Created in 下午1:10 2018/6/25
 * @Modified By:
 */
public class LeetCode48 {

    public void rotate(int[][] matrix) {
        int m=matrix.length;
        if (m==0){
            return;
        }
        int n=matrix[0].length;
        if (n==0){
            return;
        }
        boolean[][] change=new boolean[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (change[i][j]){
                    continue;
                }
                int flag=matrix[i][j];
                int nextI=j;
                int nextJ=m-i-1;
                while (matrix[nextI][nextJ]>0){
                    int temp=matrix[nextI][nextJ];
                    matrix[nextI][nextJ]=flag;
                    change[nextI][nextJ]=true;
                    flag=temp;
                    i=nextI;
                    j=nextJ;
                    nextI=j;
                    nextJ=m-i-1;
                }
            }
        }
    }
}
