package leetcode2;

/**
 * @Author ROKG
 * @Description 搜索二维矩阵
 * @Date: Created in 下午8:45 2024/2/16
 * @Modified By:
 */
public class LeetCode74_SearchTwoDimensionalMatrices {

    // 先定位在哪一行（和每行首个元素比大小），再对这行进行二分查找
    public boolean searchMatrix(int[][] matrix, int target) {
        // 比第一行的第一个元素还小 或者 比最后一行的最后一个元素还答
        if (matrix[0][0] > target || matrix[matrix.length - 1][matrix[0].length - 1] < target) {
            return false;
        }
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == target) {
                return true;
            }
            if (matrix[i][0] > target) {
                break;
            }
            index = i;
        }
        int i = 0, j = matrix[0].length - 1;
        while (i <= j) {
            int pos = (i + j) / 2;
            if (matrix[index][pos] == target) {
                return true;
            } else if (matrix[index][pos] < target ) {
                i = pos + 1;
            } else {
                j = pos - 1;
            }
        }
        return false;
    }

    // 先定位在哪一行（和每行最后一个元素比大小），再对这行进行二分查找
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length==0) {
            return false;
        }
        int i=0,j=matrix[0].length-1;
        while (i<matrix.length&&j>=0){
            int temp=matrix[i][j];
            if (temp<target){
                i++;
            }else if (temp>target){
                j--;
            }else {
                return true;
            }
        }
        return false;
    }
}
