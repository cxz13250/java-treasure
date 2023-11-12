package leetcode2;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午1:16 2023/9/9
 * @Modified By:
 */
public class Leet122_SellStock2 {

    public int maxProfit(int[] prices) {
        // 记录到前一天为止卖出股票累计的利润
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int pre = prices[i - 1];
            int cur = prices[i];
            profit = Math.max(profit, profit + cur - pre);
        }
        return profit;
    }
}
