package leetcode;

/**
 * @Author ROKG
 * @Description 包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，
 * 平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
 * @Date: Created in 上午12:58 2018/7/21
 * @Modified By:
 */
public class LeetCode661 {

    public static int[][] imageSmoother(int[][] M) {
        int m=M.length;
        if (m==0){
            return M;
        }
        int n=M[0].length;
        int[][] res=new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                int count=0;
                int sum=0;
                sum+=M[i][j];
                count++;
                if (i>0){
                    count++;
                    sum+=M[i-1][j];
                    if (j>0){
                        count++;
                        sum+=M[i-1][j-1];
                    }
                    if (j<n-1){
                        count++;
                        sum+=M[i-1][j+1];
                    }
                }
                if (i<m-1){
                    count++;
                    sum+=M[i+1][j];
                    if (j>0){
                        count++;
                        sum+=M[i+1][j-1];
                    }
                    if (j<n-1){
                        count++;
                        sum+=M[i+1][j+1];
                    }
                }
                if (j>0){
                    count++;
                    sum+=M[i][j-1];
                }
                if (j<n-1){
                    count++;
                    sum+=M[i][j+1];
                }
                res[i][j]=sum/count;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] s={{1,1,1},{1,0,1},{1,1,1}};
        imageSmoother(s);
    }
}
