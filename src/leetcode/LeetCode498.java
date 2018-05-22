package leetcode;

import dataStructure.array.Base;

/**
 * @Author ROKG
 * @Description 给定一个含有 M x N 个元素的矩阵（M行，N列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示
 * @Date: Created in 上午12:37 2018/5/1
 * @Modified By: *
 */
public class LeetCode498 {

    public static int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length==0){
            return new int[]{};
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int i=0;
        int j=0;
        int k=1;  //k为1表示向上，k为-1表示向下
        int result[]=new int[m*n];
        for(int index=0;index<m*n;index++){
            result[index]=matrix[i][j];
            int di,dj;
            if(k>0){
                di=i-1;
                dj=j+1;
            }else {
                di=i+1;
                dj=j-1;
            }
            if(di>=0&&di<m&&dj>=0&&dj<n){
                i=di;
                j=dj;
            }else {
                if(k>0){
                    if(j+1<n){
                        j++;
                    }else {
                        i++;
                    }
                }else {
                    if(i+1<m){
                        i++;
                    }else {
                        j++;
                    }
                }
                k=k*-1;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] nums=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        Base.print(findDiagonalOrder(nums));
    }
}
