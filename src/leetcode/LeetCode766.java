package leetcode;

/**
 * @Author ROKG
 * @Description 如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
 * 给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
 * @Date: Created in 下午6:35 2018/5/7
 * @Modified By:
 */
public class LeetCode766 {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int m=matrix.length;
        if(m==0){
            return true;
        }
        int n=matrix[0].length;
        if(n==0){
            return false;
        }
        if(m==1&&n==1){
            return true;
        }
        for (int i=0;i<n;i++){
            int temp=matrix[0][i];
            int j=1;
            int k=i+1;
            while(j<m&&k<n){
                if(matrix[j][k]!=temp){
                    return false;
                }
                j++;
                k++;
            }
        }
        for (int i=1;i<m;i++){
            int temp=matrix[i][0];
            int j=i+1;
            int k=1;
            while(j<m&&k<n){
                if(matrix[j][k]!=temp){
                    return false;
                }
                j++;
                k++;
            }
        }
        return true;
    }
}
