package leetcode;

/**
 * @Author ROKG
 * @Description 假设你有一个数组，其中第 i 个元素是一支给定股票第 i 天的价格。
 * 如果您只能完成最多一笔交易（即买入和卖出一股股票），则设计一个算法来找到最大的利润。
 * @Date: Created in 下午11:04 2018/4/10
 * @Modified By:
 */
public class LeetCode121 {

    public static int maxProfit(int[] prices) {
        int max=0;
        if(prices.length==0){
            return 0;
        }
        int min=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]-min>max){
                max=prices[i]-min;
            }
            if(prices[i]<min){
                min=prices[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr={7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }
}
