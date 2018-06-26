package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * @Date: Created in 下午10:48 2018/6/22
 * @Modified By: *
 */
public class LeetCode54 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        int m=matrix.length;
        if (m==0){
            return list;
        }
        int n=matrix[0].length;
        if (n==0){
            return list;
        }
        for (int i=0,j=0;i<m&&j<n;i++,j++){
            for (int k=j;k<n;k++){
                list.add(matrix[i][k]);
            }
            for (int k=i+1;k<m;k++){
                list.add(matrix[k][n-1]);
            }
            for (int k=n-2;k>=j&&i!=m-1;k--){
                list.add(matrix[m-1][k]);
            }
            for (int k=m-2;k>i&&j!=n-1;k--){
                list.add(matrix[k][j]);
            }
            m--;
            n--;
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }
}
