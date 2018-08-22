package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个整数矩阵，找出最长递增路径的长度。
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 * @Date: Created in 下午11:59 2018/8/21
 * @Modified By: *
 */
public class LeetCode329 {

    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length;
        if (m==0){
            return 0;
        }
        int n=matrix[0].length;
        if (n==0){
            return 0;
        }
        int max=0;
        int[][] flag=new int[matrix.length][matrix[0].length];
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                max=Math.max(max,check(matrix,flag,i,j));
            }
        }
        return max;
    }

    public int check(int[][] martix,int[][] flag,int x,int y){
        int m=martix.length,n=martix[0].length;
        int max=1;
        if (flag[x][y]>0){
            return flag[x][y];
        }
        int num=martix[x][y];
        flag[x][y]=1;
        if (x-1>=0&&num<martix[x-1][y]){
            max=Math.max(check(martix,flag,x-1,y)+1,max);
        }
        if (x+1<m&&num<martix[x+1][y]){
            max=Math.max(check(martix,flag,x+1,y)+1,max);
        }
        if (y-1>=0&&num<martix[x][y-1]){
            max=Math.max(check(martix,flag,x,y-1)+1,max);
        }
        if (y+1<n&&num<martix[x][y+1]){
            max=Math.max(check(martix,flag,x,y+1)+1,max);
        }
        flag[x][y]=max;
        return max;
    }

    public static void main(String[] args) {
        LeetCode329 l=new LeetCode329();
        System.out.println(l.longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}}));
    }
}
