package leetcode;

/**
 * @Author ROKG
 * @Description 根据一棵树的前序遍历与中序遍历构造二叉树。
 * @Date: Created in 下午8:07 2018/6/4
 * @Modified By:
 */
public class LeetCode105 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode build(int[] preorder,int startPre,int endPre, int[] inorder,int startIn, int endIn){
        if (startPre>endPre||startIn>endIn){
            return null;
        }
        int val=preorder[startPre];
        TreeNode node=new TreeNode(val);
        for (int i=startIn;i<=endIn;i++){
            if (inorder[i]==val){
                int len=i-startIn;
                node.left=build(preorder,startPre+1,startPre+len,inorder,startIn,i-1);
                node.right=build(preorder,startPre+len+1,endPre,inorder,i+1,endIn);
            }
        }
        return node;
    }
}
