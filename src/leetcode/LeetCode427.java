package leetcode;

/**
 * @Author ROKG
 * @Description 我们想要使用一棵四叉树来储存一个 N x N 的布尔值网络。网络中每一格的值只会是真或假。树的根结点代表整个网络。
 * 对于每个结点, 它将被分等成四个孩子结点直到这个区域内的值都是相同的.
 * 每个结点还有另外两个布尔变量: isLeaf 和 val。isLeaf 当这个节点是一个叶子结点时为真。val 变量储存叶子结点所代表的区域的值。
 * @Date: Created in 下午10:06 2018/9/5
 * @Modified By:
 */
public class LeetCode427 {

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }

    public Node construct(int[][] grid) {
        return build(grid,0,0,grid.length);
    }

    public Node build(int[][] grid,int startx,int starty,int n){
        int temp=grid[startx][starty];
        boolean same=true;
        for (int i=startx;i<startx+n;i++){
            for (int j=starty;j<starty+n;j++){
                if (grid[i][j]!=temp){
                    same=false;
                }
            }
        }
        if (same){
            return new Node(temp==1,true,null,null,null,null);
        }else {
            Node node=new Node();
            node.val=temp==1;
            node.isLeaf=false;
            node.topLeft=build(grid,startx,starty,n/2);
            node.topRight=build(grid,startx,starty+n/2,n/2);
            node.bottomLeft=build(grid,startx+n/2,starty,n/2);
            node.bottomRight=build(grid,startx+n/2,starty+n/2,n/2);
            return node;
        }
    }
}
