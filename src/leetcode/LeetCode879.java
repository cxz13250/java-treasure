package leetcode;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author ROKG
 * @Description 帮派里有 G 名成员，他们可能犯下各种各样的罪行。
 * 第 i 种犯罪会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。
 * 让我们把这些犯罪的任何子集称为盈利计划，该计划至少产生 P 的利润。
 * 有多少种方案可以选择？因为答案很大，所以返回它模 10^9 + 7 的值。
 * @Date: Created in 2018/8/7
 * @Modified By: **
 */
public class LeetCode879 {

    // 二维01背包问题
    // 动态规划，res[i][j][k]表示前i种犯罪使用k个人得到j利润得方法，
    // res[i][j][k]=res[i-1][j][k](前i-1种犯罪就达到j利润的方法)+res[i-1][j-profit[i]][k-group[i]](前i-1种犯罪达到j-profit[i]利润的方法)，
    // 在这里如果j<profit[i]要当作0处理，表示前i-1种犯罪都没有采用，所以利润是0。
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int M=1000000007;
        int[][][] res=new int[group.length+1][P+1][G+1];
        res[0][0][0]=1;
        for (int i=1;i<=group.length;i++){
            int np=profit[i-1];
            int ng=group[i-1];
            for (int j=0;j<=P;j++){
                for (int k=0;k<=G;k++){
                    res[i][j][k]=(res[i-1][j][k]+ (k<ng ? 0: res[i-1][Math.max(0,j-np)][k-ng]))%M;
                }
            }
        }
        int result=0;
        for (int i=0;i<=G;i++){
            result = (result + res[group.length][P][i])%M;
        }
        return result;
    }

    //滚动数组
    public int profitableSchemes2(int G, int P, int[] group, int[] profit) {
        int M = 1000000007;
        int[][] res=new int[P+1][G+1];
        res[0][0]=1;
        for (int i=0;i<group.length;i++){
            int np=profit[i];
            int ng=group[i];
            for (int j= P;j>=0;j--){
                int min=Math.min(P,j+np);
                for (int k=G-ng;k>=0;k--){
                    res[min][k+ng]=(res[min][k+ng]+res[j][k])%M;
                }
            }
        }
        int result=0;
        for (int i=0;i<=G;i++){
            result = (result + res[P][i])%M;
        }
        return result;
    }

    public static void main(String[] args) {
    }
}
