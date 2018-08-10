package leetcode;

import java.util.Stack;

/**
 * @Author ROKG
 * @Description 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * 设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * @Date: Created in 2018/8/9
 * @Modified By: *
 */
public class LeetCode449 {

     static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

     static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            StringBuilder sb=new StringBuilder();
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                if (node!=null){
                    sb.append(node.val);
                    sb.append(",");
                    stack.push(node.right);
                    stack.push(node.left);
                }
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length()==0){
                return null;
            }
            String[] ss=data.split(",");
            String s=ss[0];
            TreeNode root=new TreeNode(Integer.valueOf(s));
            Stack<TreeNode> stack=new Stack<>();
            TreeNode pre=root;
            for (int i=1;i<ss.length;i++){
                TreeNode node=new TreeNode(Integer.valueOf(ss[i]));
                if (node.val<pre.val){
                    pre.left=node;
                    stack.push(pre);
                }else {
                    while (!stack.isEmpty()){
                        TreeNode parent=stack.pop();
                        if (node.val<parent.val){
                            pre.right=node;
                            stack.push(parent);
                            break;
                        }else {
                            pre=parent;
                        }
                    }
                    if (stack.isEmpty()){
                        pre.right=node;
                    }
                }
                pre=node;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Codec c=new Codec();
        TreeNode node=new TreeNode(3);
        TreeNode node1=new TreeNode(1);
        node.left=node1;
        node1.left=new TreeNode(2);
        node.right=new TreeNode(4);
        System.out.println(c.deserialize(c.serialize(node)));
    }
}
