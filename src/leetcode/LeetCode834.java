package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个无向、连通的树。树中有 N 个标记为 0...N-1 的节点以及 N-1 条边 。
 * 第 i 条边连接节点 edges[i][0] 和 edges[i][1] 。
 * 返回一个表示节点 i 与其他所有节点距离之和的列表 ans。
 * @Date: Created in 下午4:46 2018/6/25
 * @Modified By: *
 */
public class LeetCode834 {

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        int[][] dist=new int[N][N];
        int[] result=new int[N];
        for (int i=0;i<N;i++){
            int[] temp=edges[i];
            dist[temp[0]][temp[1]]=1;
            dist[temp[1]][temp[0]]=1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(1^2);
    }
}
