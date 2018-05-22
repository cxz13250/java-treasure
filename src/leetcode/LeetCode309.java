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

    public static void main(String[] args) {
        int[] nums={1,2,3,0,2};
        System.out.println(maxProfit(nums));
    }
}
