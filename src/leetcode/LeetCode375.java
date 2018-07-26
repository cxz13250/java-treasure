package leetcode;

/**
 * @Author ROKG
 * @Description
 * 我们正在玩一个猜数游戏，游戏规则如下：
 * 我从 1 到 n 之间选择一个数字，你来猜我选了哪个数字。
 * 每次你猜错了，我都会告诉你，我选的数字比你的大了或者小了。
 * 然而，当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。直到你猜到我选的数字，你才算赢得了这个游戏。
 * @Date: Created in 下午5:00 2018/7/26
 * @Modified By: *
 */
public class LeetCode375 {

    //dp[i][j]表示猜范围在i~j之间的数能保证赢花的钱，在1~n个数里，我们任意猜一个数i，保证获胜花的钱为i+max(dp[1][i-1],dp[i+1][n]);
    public int getMoneyAmount(int n) {
        int[][] dp=new int[n+1][n+1];
        return check(dp,1,n);
    }

    public int check(int[][] dp,int start,int end){
        int min=Integer.MAX_VALUE;
        if (start>=end){
            return 0;
        }
        if (dp[start][end]!=0){
            return dp[start][end];
        }
        for (int i=start;i<end+1;i++){
            int temp=i+Math.max(check(dp,start,i-1),check(dp,i+1,end));
            if (temp<min){
                min=temp;
            }
        }
        dp[start][end]=min;
        return min;
    }
}
