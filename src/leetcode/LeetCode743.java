package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author ROKG
 * @Description 有 N 个网络节点，标记为 1 到 N。
 * 给定一个列表 times，表示信号经过有向边的传递时间。 times[i] = (u, v, w)，其中 u 是源节点，v 是目标节点， w 是一个信号从源节点传递到目标节点的时间。
 * 现在，我们向当前的节点 K 发送了一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1。
 * @Date: Created in 2018/9/25
 * @Modified By: *
 */
public class LeetCode743 {

    // pre[i]表示到达i点需要的最小时间
    // 111ms
    public static int networkDelayTime(int[][] times, int N, int K) {
        int[] pre=new int[N+1];
        Arrays.fill(pre, -1);
        pre[K]=0;
        int[] visitedCount=new int[N+1];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int cur;
        queue.add(new int[]{K,0});
        while (!queue.isEmpty()) {
            cur=queue.poll()[0];
            if (visitedCount[cur]==1){
                continue;
            }
            visitedCount[cur]=1;
            for (int i=0;i<times.length;i++){
                if (times[i][0]==cur){
                    int next=times[i][1];
                    if (pre[next]==-1){
                        pre[next]=times[i][2]+pre[cur];
                    }else {
                        pre[next]=Math.min(pre[next],times[i][2]+pre[cur]);
                    }
                    queue.offer(new int[]{next,pre[next]});
                }
            }
        }
        int res=0;
        for (int i=1;i<visitedCount.length;i++){
            if (visitedCount[i]==0){
                return -1;
            }
            res=Math.max(res, pre[i]);
        }
        return res;
    }

    // 40ms
    public static int networkDelayTime2(int[][] times, int N, int K) {
        int[] dist=new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K]=0;
        for (int i=0;i<N;i++){
            for (int[] t:times){
                int from=t[0],to=t[1],val=t[2];
                if (dist[from]!=Integer.MAX_VALUE&&dist[to]>dist[from]+val){
                    dist[to]=dist[from]+val;
                }
            }
        }
        int max=0;
        for (int i=1;i<=N;i++){
            max=Math.max(max, dist[i]);
        }
        return max==Integer.MAX_VALUE?-1:max;
    }

    public static void main(String[] args) {
        System.out.println(networkDelayTime(new int[][]{{4,2,76},{1,3,79},{3,1,81},{4,3,30},{2,1,47},{1,5,61},{1,4,99},{3,4,68},{3,5,46},{4,1,6},{5,4,7},{5,3,44},{4,5,19},{2,3,13},{3,2,18},{1,2,0},{5,1,25},{2,5,58},{2,4,77},{5,2,74}}, 5, 3));
    }
}
