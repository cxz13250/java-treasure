package leetcode;

/**
 * @Author ROKG
 * @Description 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * 返回尽可能高的分数。
 * @Date: Created in 下午11:52 2018/7/18
 * @Modified By: *
 */
public class LeetCode861 {

    public static int matrixScore(int[][] A) {
        if (A.length==0||A[0].length==0){
            return 0;
        }
        for (int i=0;i<A.length;i++){
            if (A[i][0]==0){
                for (int j=0;j<A[0].length;j++){
                    A[i][j]=1-A[i][j];
                }
            }
        }
        for (int i=0;i<A[0].length;i++){
            int zero=0,one=0;
            for (int j=0;j<A.length;j++){
                if (A[j][i]==1) {
                    one++;
                }else if (A[j][i]==0){
                    zero++;
                }
            }
            if (zero>one){
                for (int j=0;j<A.length;j++){
                    A[j][i]=1-A[j][i];
                }
            }
        }
        int result=0;
        for (int i=0;i<A.length;i++){
            int temp=0;
            for (int j=0;j<A[0].length;j++){
                temp=(temp<<1)+A[i][j];
                //result+=A[i][j]*Math.pow(2,A[0].length-j-1);
            }
            result+=temp;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] nums={{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(matrixScore(nums));
    }
}
