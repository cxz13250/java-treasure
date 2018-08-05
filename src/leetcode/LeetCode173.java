package leetcode;

import java.util.Stack;

/**
 * @Author ROKG
 * @Description 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 * 注意: next() 和hasNext() 操作的时间复杂度是O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * @Date: Created in 下午11:29 2018/8/2
 * @Modified By:
 */
public class LeetCode173 {

    public class BSTIterator {

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
        }

        Stack<TreeNode> stack=new Stack<>();

        public BSTIterator(TreeNode root) {
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /** @return the next smallest number */
        public int next() {
            if (stack.isEmpty()){
                return -1;
            }
            TreeNode node=stack.pop();
            int result=node.val;
            node=node.right;
            while (node!=null){
                stack.push(node);
                node=node.left;
            }

            return result;
        }
    }
}
