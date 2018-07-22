package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 * @Date: Created in 下午2:22 2018/7/21
 * @Modified By:
 */
public class LeetCode304 {

    static class NumMatrix {

        int[][] matrix;

        public NumMatrix(int[][] matrix) {
            int m=matrix.length;
            if (m==0){
                this.matrix=new int[1][1];
            }else {
                int n = matrix[0].length;
                this.matrix = new int[m][n];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i == 0 && j == 0) {
                            this.matrix[i][j] = matrix[i][j];
                        } else if (i == 0 && j > 0) {
                            this.matrix[i][j] = this.matrix[i][j - 1] + matrix[i][j];
                        } else if (i > 0 && j == 0) {
                            this.matrix[i][j] = this.matrix[i - 1][j] + matrix[i][j];
                        } else if (i > 0 && j > 0) {
                            this.matrix[i][j] = this.matrix[i - 1][j] + this.matrix[i][j - 1] - this.matrix[i - 1][j - 1] + matrix[i][j];
                        }
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (row2>matrix.length){
                return 0;
            }
            if (col2>matrix[0].length){
                return 0;
            }
            if (matrix.length==1&&matrix[0].length==1){
                return matrix[0][0];
            }
            if (row1>0&&col1>0) {
                return matrix[row2][col2] + matrix[row1-1][col1-1] - matrix[row2][col1-1] - matrix[row1-1][col2];
            }else if (row1==0&&col1>0){
                return matrix[row2][col2] - matrix[row2][col1-1];
            }else if (row1>0&&col1==0){
                return matrix[row2][col2] - matrix[row1-1][col2];
            }else {
                return matrix[row2][col2];
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums={{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};

        NumMatrix n=new NumMatrix(nums);
        System.out.println(n.sumRegion(2,1,4,3));
        System.out.println(n.sumRegion(1,1,2,2));
        System.out.println(n.sumRegion(1,2,2,4));
    }
}
