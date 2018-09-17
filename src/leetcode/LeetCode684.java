package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ROKG
 * @Description 在本问题中, 树指的是一个连通且无环的无向图。
 * 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 * 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
 * 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
 * @Date: Created in 2018/9/17
 * @Modified By: *
 */
public class LeetCode684 {

    // begin[i] 表示到达点i的路径起点
    // 只要有新的边(x,y)加入进来，检验是否出现环（begin[x]==begin[y]）
    // 如果无环则用begin[x]来更新所有跟y点相同起点的点的begin
    public static int[] findRedundantConnection(int[][] edges) {
        int s=2001;
        int[] begin=new int[s];
        for (int i=0;i<s;i++){
            begin[i]=i;
        }
        for (int i=0;i<edges.length;i++){
            int x=edges[i][0];
            int y=edges[i][1];
            if (begin[x]==begin[y]){
                return new int[]{x,y};
            }
            int update=begin[y];
            for (int j=0;j<s;j++){
                if (begin[j]==update){
                    begin[j]=begin[x];
                }
            }
        }
        return edges[0];
    }

    public static void main(String[] args) {
        int[] res=findRedundantConnection(new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}});
        System.out.println(res[0]+" "+res[1]);
    }
}
