package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 * @Date: Created in 2018/9/11
 * @Modified By: *
 */
public class LeetCode52 {

    int count=0;

    // 同51题，按行遍历矩阵，检验每一行的每一列是否满足，满足继续下一行，每次遍历完所有行count加一
    public int totalNQueens(int n) {
        int[] queen=new int[n];
        check(queen, 0, n);
        return count;
    }

    public void check(int[] queen,int row,int n){
        if (row==n){
            count++;
        }
        for (int i=0;i<n;i++){
            if (isValid(queen, row, i)){
                queen[row]=i;
                check(queen, row+1, n);
            }
        }
    }

    public boolean isValid(int[] queen,int row,int col){
        for (int i=0;i<row;i++){
            int pos=queen[i];
            if (pos==col||row-i==col-pos||pos-col==row-i){
                return false;
            }
        }
        return true;
    }
}
