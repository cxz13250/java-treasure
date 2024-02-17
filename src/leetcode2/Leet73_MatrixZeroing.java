package leetcode2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author ROKG
 * @Description 矩阵置零
 * @Date: Created in 上午9:49 2024/2/17
 * @Modified By:
 */
public class Leet73_MatrixZeroing {

    // 引入O(m+n)空间
    public void setZeroes(int[][] matrix) {
        Set<Integer> rowNeedZero = new HashSet<>();
        Set<Integer> columnNeedZero = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowNeedZero.add(i);
                    columnNeedZero.add(j);
                }
            }
        }
        for (Integer row : rowNeedZero) {
            Arrays.fill(matrix[row], 0);
        }
        for (Integer column : columnNeedZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][column] = 0;
            }
        }
    }

    // 引入O(1)空间，思路是使用第一列的值来标记每一行是否出现0，第一行的值来标记每一列是否出现0
    // 引入两个常量来记录第一行和第一列原来是否存在0
    public void setZeroes2(int[][] matrix) {
        boolean flagRowZero = false;
        boolean flagColumnZero = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                flagColumnZero = true;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                flagRowZero = true;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (flagRowZero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if (flagColumnZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    // 引入O(1)空间，思路是使用第一列的值来标记每一行是否出现0，第一行的值来标记每一列是否出现0
    // 引入一个常量来记录第一列原来是否存在0，第一列的第一个元素标记第一行是否出现过0
    // 为防止每一列的第一个元素被提前更新，需要从最后一行开始倒序处理
    public void setZeroes3(int[][] matrix) {
        boolean flagColumnZero = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                flagColumnZero = true;
            }
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (flagColumnZero) {
                matrix[i][0] = 0;
            }
        }
    }
}
