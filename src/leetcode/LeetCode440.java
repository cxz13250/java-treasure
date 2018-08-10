package leetcode;

/**
 * @Author ROKG
 * @Description 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
 * @Date: Created in 2018/8/9
 * @Modified By: *
 */
public class LeetCode440 {

    // 从1开始，1与2之间差1个数，然后每次将左右区间都*10，同时考虑你的大小，n与右区间取较小者，累加区间内数的个数。
    // 看是否超过k，没超过，则继续看2与3之间，k减去上一次区间内的个数。若超过了，就看10与11之间，同时k--（减去本身）
    public int findKthNumber(int n, int k) {
        int cur=1;
        k--;
        while (k>0){
            long step=0,first=cur,last=cur+1;
            while (first<=n){
                step+=Math.min(last,n+1)-first;
                first*=10;
                last*=10;
            }
            if (step<=k){
                cur++;
                k-=step;
            }else {
                cur*=10;
                k--;
            }
        }
        return cur;
    }
}
