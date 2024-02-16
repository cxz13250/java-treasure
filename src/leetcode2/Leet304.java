package leetcode2;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午1:00 2023/11/19
 * @Modified By:
 */
public class Leet304 {

    static class NumMatrix {

        int[][] sumMatrix;

        public NumMatrix(int[][] matrix) {
            sumMatrix = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (i == 0 && j == 0) {
                        sumMatrix[i][j] = matrix[i][j];
                    } else if (i == 0) {
                        sumMatrix[i][j] = sumMatrix[i][j - 1] + matrix[i][j];
                    } else if (j == 0) {
                        sumMatrix[i][j] = sumMatrix[i - 1][j] + matrix[i][j];
                    } else {
                        sumMatrix[i][j] = sumMatrix[i - 1][j] + sumMatrix[i][j - 1] - sumMatrix[i - 1][j - 1] + matrix[i][j];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            // 0,0,2,2
            if (row1 == 0 && col1 == 0) {
                return sumMatrix[row2][col2];
            }
            // 0,1,2,2
            if (row1 == 0 && row2 != 0) {
                return sumMatrix[row2][col2] - sumMatrix[row2][col1-1];
            }
            // 1,0,2,2
            if (col1 == 0 && col2 != 0) {
                return sumMatrix[row2][col2] - sumMatrix[row1-1][col2];
            }
            // 0,1,0,2
            if (row2 == 0) {
                return sumMatrix[row2][col2] - sumMatrix[row1][col1 - 1];
            }
            // 1,0,2,0
            if (col2 == 0) {
                return sumMatrix[row2][col2] - sumMatrix[row1 - 1][col1];
            }
            // 1,1,2,2
            return sumMatrix[row2][col2] - sumMatrix[row1 - 1][col2] - sumMatrix[row2][col1 - 1] + sumMatrix[row1 - 1][col1 - 1];
        }

    }

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{{-4,-5}});
        System.out.println(numMatrix.sumRegion(0,0,0,1));
    }
}
