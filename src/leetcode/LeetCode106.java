package leetcode;

/**
 * @Author ROKG
 * @Description 根据一棵树的中序遍历与后序遍历构造二叉树。
 * @Date: Created in 下午8:29 2018/6/4
 * @Modified By:
 */
public class LeetCode106 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    public TreeNode build(int[] inorder,int startIn,int endIn, int[] postorder,int startPost, int endPost){
        if (startIn>endIn){
            return null;
        }
        int val=postorder[endPost];
        TreeNode node=new TreeNode(val);
        for (int i=startIn;i<=endIn;i++){
            if (inorder[i]==val){
                int len=i-startIn;
                node.left=build(inorder,startIn,i-1,postorder,startPost,startPost+len-1);
                node.right=build(inorder,i+1,endIn,postorder,startPost+len,endPost);
            }
        }
        return node;
    }
}
