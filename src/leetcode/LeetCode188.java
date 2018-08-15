package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @Date: Created in 上午9:50 2018/8/15
 * @Modified By: *
 */
public class LeetCode188 {

    //local[i][j]表示前i天交易j次并且第j次交易是在第天的利润，global[i][j]表示前i天交易j次最大利润
    public static int maxProfit(int k, int[] prices) {
       int n=prices.length;
       if (k<=0 || n==0){
           return 0;
       }
       if (k>=n){
           int res=0;
           for (int i=1;i<prices.length;i++){
               if (prices[i]-prices[i-1]>0){
                   res+=prices[i]-prices[i-1];
               }
           }
           return res;
       }
       int[][] local=new int[n][k+1];
       int[][] global=new int[n][k+1];
       for (int j=1;j<=k;j++){
           for (int i=1;i<n;i++){
               local[i][j]=Math.max(local[i-1][j]+prices[i]-prices[i-1],global[i-1][j-1]+Math.max(0,prices[i]-prices[i-1]));
               global[i][j]=Math.max(local[i][j],global[i-1][j]);
           }
       }
       return global[n-1][k];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(2,new int[]{1,2,4,2,5,7,2,4,9,0}));
    }
}
