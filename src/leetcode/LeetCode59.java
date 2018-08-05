package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * @Date: Created in 下午4:05 2018/7/29
 * @Modified By:
 */
public class LeetCode59 {

    public int[][] generateMatrix(int n) {
        int count=1;
        int[][] res=new int[n][n];
        if (n==1){
            res[0][0]=count;
            return res;
        }
        int i=0,j=0,flag=1;   //flag为1向右，为-1向左，为2向上，为-2向下
        while (count<=n*n){
            res[i][j]=count++;
            if (flag==1){
                j++;
                if (j==n||res[i][j]!=0){
                    flag=-2;
                    j--;
                    i++;
                }
            }else if (flag==-1){
                j--;
                if (j==-1||res[i][j]!=0){
                    flag=2;
                    j++;
                    i--;
                }
            }else if (flag==2){
                i--;
                if (i==-1||res[i][j]!=0){
                    flag=1;
                    i++;
                    j++;
                }
            }else {
                i++;
                if (i==n||res[i][j]!=0){
                    flag=-1;
                    i--;
                    j--;
                }
            }
        }
        return res;
    }
}
