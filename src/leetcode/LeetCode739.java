package leetcode;

import java.util.Arrays;

/**
 * @Author ROKG
 * @Description 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。如果之后都不会升高，请输入 0 来代替。
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的都是 [30, 100] 范围内的整数。
 * @Date: Created in 下午11:05 2018/9/17
 * @Modified By:
 */
public class LeetCode739 {

    public static int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] res=new int[n];
        res[n-1]=0;
        for (int i=n-1;i>0;i--){
            if (temperatures[i]>temperatures[i-1]){
                res[i-1]=1;
            }else if (temperatures[i]==temperatures[i-1]){
                res[i-1]=res[i]==0?0:res[i]+1;
            }else {
                if (res[i]==0){
                    res[i-1]=0;
                }else {
                    int j = i + 1;
                    while (j < n && temperatures[j] <= temperatures[i - 1]) {
                        j++;
                    }
                    if (j >= n) {
                        res[i - 1] = 0;
                    } else {
                        res[i - 1] = j - i + 1;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }
}