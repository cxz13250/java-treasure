package leetcode;

/**
 * @Author ROKG
 * @Description 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * @Date: Created in 上午11:06 2018/6/18
 * @Modified By:
 */
public class LeetCode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
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
