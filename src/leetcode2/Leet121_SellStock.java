package leetcode2;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午12:52 2023/9/9
 * @Modified By:
 */
public class Leet121_SellStock {

    public int maxProfit(int[] prices) {
        int profit = 0;
        // 记录历史最低价
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return profit;
    }
}
