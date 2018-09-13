package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ROKG
 * @Description 对于一个具有树特征的无向图，我们可选择任何一个节点作为根。图因此可以成为树，在所有可能的树中，具有最小高度的树被称为最小高度树。
 * 给出这样的一个图，写出一个函数找到所有的最小高度树并返回他们的根节点。
 * @Date: Created in 下午4:45 2018/9/9
 * @Modified By: *
 */
public class LeetCode310 {

    class Node{
        int id=-1;
        int dist=Integer.MIN_VALUE;
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>[] graph=new List[n];
        for (int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for (int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] pre=new int[n];
        Arrays.fill(pre,-1);
        Node node1=new Node();
        find(0,0,node1,graph,pre);
        Arrays.fill(pre,-1);
        Node node2=new Node();
        find(node1.id,0,node2,graph,pre);
        List<Integer> res=new ArrayList<>();
        int id=node2.id;
        for (int i=0;i<node2.dist/2;i++){
            id=pre[id];
        }
        res.add(id);
        if (node2.dist%2==1){
            res.add(pre[id]);
        }
        return res;
    }

    // 找到最长的那条路径，取中间点即可
    public void find(int cur,int dist,Node max,List<Integer>[] graph,int[] pre){
        if (dist>=max.dist){
            max.dist=dist;
            max.id=cur;
        }
        for (int i=0;i<graph[cur].size();i++){
            int next=graph[cur].get(i);
            if (next==pre[cur]){
                continue;
            }
            pre[next]=cur;
            find(next,dist+1,max,graph,pre);
        }
    }

    public static void main(String[] args) {
        LeetCode310 l=new LeetCode310();
        System.out.println(l.findMinHeightTrees(4,new int[][]{{1,0},{1,2},{1,3}}));
    }
}
