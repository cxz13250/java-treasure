package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Description 有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到从 src 到 dst 最多经过 k 站中转的最便宜的价格。 如果没有这样的路线，则输出 -1。
 * @Date: Created in 2018/9/28
 * @Modified By: *
 */
public class LeetCode787 {

    // Bellman-Ford算法，res[i]表示到达i点需要的最小价格，循环K+1次，初始除了到达src为0，其余都是max
    // 执行K + 1次遍历：对于图中的每条边，如果起点u的距离d加上边的权值w小于终点v的距离d，则更新终点v的距离值d
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] res=new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[src]=0;
        for (int i=0;i<=K;i++){
            int[] tmp=Arrays.copyOf(res, n);
            for (int[] ii:flights){
                if (res[ii[0]]<Integer.MAX_VALUE){
                    tmp[ii[1]]=Math.min(tmp[ii[1]], res[ii[0]]+ii[2]);
                }
            }
            res=tmp;
        }
        return res[dst]==Integer.MAX_VALUE?-1:res[dst];
    }
}
