package leetcode;

/**
 * @Author ROKG
 * @Description 假设你有一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。设计一个算法来找到最大的利润。你最多可以完成两笔交易。
 * 你不可同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @Date: Created in 下午11:32 2018/4/10
 * @Modified By: *
 */
public class LeetCode123 {

    public static int maxProfit(int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        int maxSum = 0;
        int[] maxProfit = new int[prices.length];
        int[] maxProfitRev = new int[prices.length];

        int max = 0;
        int min = prices[0];
        for (int i = 1 ; i < prices.length ; i ++){
            int diff = prices[i] - min;
            max = Math.max(diff, max);
            if (prices[i] < min){
                min = prices[i];
            }
            maxProfit[i] = max;
        }
        max = 0;
        int high = prices[prices.length - 1];
        for (int i = prices.length - 2 ; i >= 0 ; i--){
            int diff = high - prices[i];
            max = Math.max(max, diff);
            if (prices[i] > high){
                high = prices[i];
            }
            maxProfitRev[i] = max;
        }
        for (int i = 0 ; i < prices.length ; i ++){
            maxSum = Math.max(maxSum, maxProfit[i] + maxProfitRev[i]);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr={6,2,1,7,3,4,5,2,8};
        System.out.println(maxProfit(arr));
    }
}
