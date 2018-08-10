package leetcode;

import java.util.Arrays;

/**
 * @Author ROKG
 * @Description 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * @Date: Created in 2018/8/10
 * @Modified By: *
 */
public class LeetCode85 {

    // 使用三个数组分别记录，当前元素所在的矩形左边界、右边界、高度。
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length==0 || matrix[0].length==0){
            return 0;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int[] lefts=new int[n];
        int[] rights=new int[n];
        int[] heights=new int[n];
        Arrays.fill(rights,n);
        int res=0;
        for (int i=0;i<m;i++){
            int curLeft=0,curRight=n;
            for (int j=0;j<n;j++){
                heights[j]=matrix[i][j]=='0'?0:heights[j]+1;
                if (heights[j]>0){
                    lefts[j]=Math.max(lefts[j],curLeft);
                }else {
                    lefts[j]=0;
                    curLeft=j+1;
                }
            }
            for (int j=n-1;j>=0;j--){
                if (heights[j]>0){
                    rights[j]=Math.min(rights[j],curRight);
                }else {
                    rights[j]=n;
                    curRight=j;
                }
            }
            for (int j=0;j<n;j++){
                res=Math.max(res,(rights[j]-lefts[j])*heights[j]);
            }
        }
        return res;
    }
}
