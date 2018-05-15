package leetcode;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 上午12:22 2018/5/10
 * @Modified By:
 */
public class LeetCode222 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int getLeftHeight(TreeNode node){
        if (node==null){
            return 0;
        }else {
            int height=0;
            while (node!=null){
                height++;
                node=node.left;
            }
            return height;
        }
    }

    public int countNodes(TreeNode root) {
        if (root==null){
            return 0;
        }else {
            int count=0;
            TreeNode node=root;
            while (node!=null){
                int left=getLeftHeight(node.left);
                int right=getLeftHeight(node.right);
                if (left==right){
                    count+= ((1<<left)-1)+1;
                    node=node.right;
                }else if (left>right){
                    count+= ((1<<right)-1)+1;
                    node=node.left;
                }
            }
            return count;
        }
    }
}
