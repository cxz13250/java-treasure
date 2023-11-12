package leetcode2;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午1:48 2023/9/9
 * @Modified By:
 */
public class Leet123_SellStock3 {

    public static int maxProfit(int[] prices) {
        // sellOnceProfitUntilCurrent[i] 表示到i天时，只卖一次的最大利润
        int[] sellOnceProfitUntilCurrent = new int[prices.length];
        int minPrice = prices[0];
        sellOnceProfitUntilCurrent[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            sellOnceProfitUntilCurrent[i] = Math.max(sellOnceProfitUntilCurrent[i - 1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        // sellOnceProfitFromCurrent[i] 表示从i天开始到最后一天，只卖一次的最大利润
        int[] sellOnceProfitFromCurrent = new int[prices.length];
        int maxPrice = prices[prices.length - 1];
        sellOnceProfitFromCurrent[prices.length - 1] = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            sellOnceProfitFromCurrent[i] = Math.max(sellOnceProfitFromCurrent[i + 1], maxPrice - prices[i]);
            maxPrice = Math.max(maxPrice, prices[i]);
        }
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            res = Math.max(res, sellOnceProfitUntilCurrent[i] + sellOnceProfitFromCurrent[i]);
        }
        return res;
    }

    public static int maxProfit2(int[] prices) {
        int buy1 = -prices[0], sell1 = 0, buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < prices.length; i++) {
            // 第i天第一次买进的利润 buy1 =max(第i-1天买进的利润 buy1'，第i天买进的利润 -prices[i])
            // 第i天第一次卖出的利润 sell1 =max(第i-1天卖出的利润 sell1'，第i天卖出的利润 prices[i] + 第i-1天买进的利润 buy1')
            // 第i天第二次买出的利润 buy2 =max(第i-1天卖出进的利润 buy2'，第i天买进的利润 -prices[i] + 第i-1天第一次卖出的利润 sell1')
            // 第i天第二次卖出的利润 sell2 =max(第i-1天第二次卖出的利润 sell2'，第i天卖出的利润 prices[i] + 第i-1天第二次买进的利润 buy2')
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

    public static void main(String[] args) {
//        System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(maxProfit2(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }
}
