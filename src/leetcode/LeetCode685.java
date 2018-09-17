package leetcode;

/**
 * @Author ROKG
 * @Description 在本问题中，有根树指满足以下条件的有向图。该树只有一个根节点，所有其他节点都是该根节点的后继。每一个节点只有一个父节点，除了根节点没有父节点。
 * 输入一个有向图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 * 结果图是一个以边组成的二维数组。 每一个边 的元素是一对 [u, v]，用以表示有向图中连接顶点 u and v和顶点的边，其中父节点u是子节点v的一个父节点。
 * 返回一条能删除的边，使得剩下的图是有N个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。
 * @Date: Created in 2018/9/17
 * @Modified By: *
 */
public class LeetCode685 {

    public static int[] findRedundantDirectedConnection(int[][] edges) {
        int s=edges.length;
        int[] begin=new int[s+1];
        int[] e1=null,e2=null;
        for (int[] edge:edges){
            if (begin[edge[1]]==0){
                begin[edge[1]]=edge[0];
            }else {
                e1=new int[]{begin[edge[1]],edge[1]};
                e2=new int[]{edge[0],edge[1]};
                edge[1]=0;
            }
        }
        for (int i=0;i<=s;i++){
            begin[i]=i;
        }
        for (int[] edge:edges){
            if (edge[1]==0){
                continue;
            }
            int x=getBegin(begin, edge[0]);
            int y=getBegin(begin, edge[1]);
            if (x==y){
                return e1==null?edge:e1;
            }
            begin[x]=y;
        }
        return e2;
    }

    public static int getBegin(int[] begin,int i){
        return i==begin[i]?i:getBegin(begin, begin[i]);
    }

    public static void main(String[] args) {
        int[] res=findRedundantDirectedConnection(new int[][]{{1,2},{1,3},{2,3}});
//        int[] res=findRedundantDirectedConnection(new int[][]{{1,2},{2,3},{3,4},{4,1},{1,5}});
        System.out.println(res[0]+" "+res[1]);
    }
}
