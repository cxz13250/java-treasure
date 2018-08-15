package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个矩阵 A， 返回 A 的转置矩阵。
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * @Date: Created in 上午12:04 2018/8/14
 * @Modified By:
 */
public class LeetCode867 {

    public static int[][] transpose(int[][] A) {
        int m=A.length;
        if (m==0){
            return new int[0][];
        }
        int n=A[0].length;
        if (n==0){
            return new int[0][];
        }
        int[][] res=new int[n][m];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                res[j][i]=A[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] i={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(transpose(i));
    }
}
