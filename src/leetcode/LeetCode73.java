package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * @Date: Created in 下午10:56 2018/6/3
 * @Modified By:
 */
public class LeetCode73 {

    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int row=0,col=0;
        for (int i=0;i<m;i++){
            if (matrix[i][0]==0){
                col=1;
                break;
            }
        }
        for (int j=0;j<n;j++){
            if (matrix[0][j]==0){
                row=1;
                break;
            }
        }
        for (int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for (int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if (row==1){
            for (int j = 0; j < n; j++) {
                matrix[0][j]=0;
            }
        }
        if (col==1){
            for (int i=0;i<m;i++) {
                matrix[i][0]=0;
            }
        }
    }
}
