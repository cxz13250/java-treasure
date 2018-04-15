package leetcode;

/**
 * @Author ROKG
 * @Description 假设有一个数组，它的第 i 个元素是一个给定的股票在第 i 天的价格。设计一个算法来找到最大的利润。你可以完成尽可能多的交易（多次买卖股票）。
 * 然而，你不能同时参与多个交易（你必须在再次购买前出售股票）。
 * @Date: Created in 下午11:18 2018/4/10
 * @Modified By:
 */
public class LeetCode122 {

    public static int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1 ; i < prices.length ; i ++){
            if (prices[i] > prices[i - 1]){
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr={6,2,1,7,3,4,5,2,8};
        System.out.println(maxProfit(arr));
    }
}
