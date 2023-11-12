package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * @Date: Created in 下午4:06 2018/5/22
 * @Modified By: *
 */
public class LeetCode309 {

    public static int maxProfit(int[] prices) {

        // sell 表示到今天为止最后一次操作时卖出所获得的收益
        // buy 表示到今天为止最后一次操作时买入所获得的收益
        // cooldown 表示到今天为止最后一次操作时冷冻所获得收益
        int last_sell = 0, last_buy = Integer.MIN_VALUE, last_cooldown = 0, sell = 0, buy = 0, cooldown = 0;
        for(int price:prices) {
            buy = Math.max(last_buy, last_cooldown - price);
            sell = Math.max(last_sell, last_buy + price);
            cooldown = Math.max(last_cooldown, last_sell);
            last_buy = buy;
            last_sell = sell;
            last_cooldown = cooldown;
        }
        return sell;
    }

    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][3];
        //dp[i][x]第i天结束时进入(处于)x状态（0.不持股，1.持股，2.冷冻期）
        //不持股
        dp[0][0] = 0;
        //持股
        dp[0][1] = -prices[0];
        //冷冻期
        dp[0][2] = 0;
        for(int i = 1;i < prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
            dp[i][2] = dp[i-1][1] + prices[i];
        }
        return Math.max(dp[prices.length-1][0], dp[prices.length-1][2]);
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,0,2};
        System.out.println(maxProfit(nums));
    }
}
