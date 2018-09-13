package leetcode;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午9:38 2018/9/12
 * @Modified By:
 */
public class LeetCode558 {

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

    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf){
            return quadTree1.val?quadTree1:quadTree2;
        } else if (quadTree2.isLeaf){
            return quadTree2.val?quadTree2:quadTree1;
        } else {
            Node topLeft=intersect(quadTree1.topLeft,quadTree2.topLeft);
            Node topRight=intersect(quadTree1.topRight,quadTree2.topRight);
            Node bottomLeft=intersect(quadTree1.bottomLeft,quadTree2.bottomLeft);
            Node bottomRight=intersect(quadTree1.bottomRight,quadTree2.bottomRight);
            if (topLeft.isLeaf&&topRight.isLeaf&&bottomRight.isLeaf&&bottomLeft.isLeaf&&
                    topLeft.val==topRight.val==bottomLeft.val==bottomRight.val){
                return new Node(topLeft.val,true,null,null,null,null);
            }else {
                quadTree1.val=false;
                quadTree1.topLeft=topLeft;
                quadTree1.topRight=topRight;
                quadTree1.bottomLeft=bottomLeft;
                quadTree1.bottomRight=bottomRight;
                return quadTree1;
            }
        }
    }

    public static void main(String[] args) {

    }
}
