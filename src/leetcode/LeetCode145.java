package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author ROKG
 * @Description 给定一个二叉树，返回它的 后序 遍历。
 * @Date: Created in 下午3:29 2018/5/3
 * @Modified By:
 */
public class LeetCode145 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //递归
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        check(root,list);
        return list;
    }

    public void check(TreeNode node, List<Integer> list){
        if(node!=null){
            check(node.left,list);
            check(node.right,list);
            list.add(node.val);
        }
    }

    //非递归
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        TreeNode last=null;
        while (cur!=null){
            stack.push(cur);
            cur=cur.left;
        }
        while (!stack.isEmpty()){
            cur=stack.pop();
            if(cur.right==null||cur.right==last){
                list.add(cur.val);
                last=cur;
            }else {
                stack.push(cur);
                cur= cur.right;
                while (cur!=null){
                    stack.push(cur);
                    cur=cur.left;
                }
            }
        }
        return list;
    }
}
