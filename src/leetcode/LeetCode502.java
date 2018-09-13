package leetcode;

import java.util.PriorityQueue;

/**
 * @Author ROKG
 * @Description 假设 LeetCode 即将开始其 IPO。为了以更高的价格将股票卖给风险投资公司，LeetCode希望在 IPO 之前开展一些项目以增加其资本。 由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 LeetCode 设计完成最多 k 个不同项目后得到最大总资本的方式。
 * 给定若干个项目。对于每个项目 i，它都有一个纯利润 Pi，并且需要最小的资本 Ci 来启动相应的项目。最初，你有 W 资本。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
 * 总而言之，从给定项目中选择最多 k 个不同项目的列表，以最大化最终资本，并输出最终可获得的最多资本。
 * @Date: Created in 2018/9/12
 * @Modified By: *
 */
public class LeetCode502 {

    // 先对所有项目按成本从低到高排序
    // 循环k次，每次从项目中选出满足资本的所有项目进入利润队列，选出利润最高的那个作为本轮的项目，将利润增加进资本中
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> capq=new PriorityQueue<>((a,b) -> a[0]-b[0]);
        PriorityQueue<int[]> proq=new PriorityQueue<>((a,b) -> b[1]-a[1]);
        for (int i=0;i<Profits.length;i++){
            capq.offer(new int[]{Capital[i],Profits[i]});
        }
        for (int i=0;i<k;i++){
            while (!capq.isEmpty()&&capq.peek()[0]<=W){
                proq.add(capq.poll());
            }
            if (proq.isEmpty()){
                break;
            }
            W+=proq.poll()[1];
        }
        return W;
    }
}
