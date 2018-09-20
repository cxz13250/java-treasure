package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * @Date: Created in 2018/9/20
 * @Modified By: *
 */
public class LeetCode714 {

    // cash 表示手里的钱，初始为0
    // hold 表示手里持有的股票的成本，每次与之前的成本做对比
    public static int maxProfit(int[] prices, int fee) {
        int cash=0;
        int hold=-prices[0];
        for (int i=1;i<prices.length;i++){
            cash=Math.max(cash, hold+prices[i]-fee);
            hold=Math.max(hold, cash-prices[i]);
        }
        return cash;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
        System.out.println(maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));
    }
}
