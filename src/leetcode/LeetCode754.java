package leetcode;

/**
 * @Author ROKG
 * @Description
 * 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
 * 每次你可以选择向左或向右移动。第 n 次移动（从 1 开始），可以走 n 步。
 * 返回到达终点需要的最小移动次数。
 * @Date: Created in 2018/9/18
 * @Modified By: *
 */
public class LeetCode754 {

    // 从1开始累加到sum，i+1时超过target绝对值，
    // 检验sum-target绝对值，差 diff 为偶数，只要diff/2时向左，就能刚好到target处，所以答案为i
    // 差diff为奇数，若n为偶数，1到n中一个数向左，再加上n+1，就能刚好到target处，所以答案为i+1
    // 如果n为奇数，1到n中一个数向左，再加上n+1，n+2，就能刚好到target处，所以答案为i+2
    public int reachNumber(int target) {
        int i=1;
        int sum=0;
        while (sum<Math.abs(target)){
            i++;
            sum+=i;
        }
        if (Math.abs(sum-Math.abs(target))%2==0){
            return i;
        }else {
            i--;
            if (i%2==0){
                return i+1;
            }else {
                return i+2;
            }
        }
    }
}
