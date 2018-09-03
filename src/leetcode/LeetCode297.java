package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

/**
 * @Author ROKG
 * @Description 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * @Date: Created in 2018/9/3
 * @Modified By: *
 */
public class LeetCode297 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 前序遍历+递归生成树+队列
    private static String delim=",";

    private static String nullNode="#";

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    public static void preOrder(TreeNode node, StringBuilder sb){
        if (node==null){
            sb.append(nullNode).append(delim);
        }else {
            sb.append(node.val).append(delim);
            preOrder(node.left, sb);
            preOrder(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data==null || data.length()==0){
            return null;
        }
        String[] ss=data.split(delim);
        Queue<String> queue=new LinkedList<>();
        queue.addAll(Arrays.asList(ss));
        return buildTree(queue);
    }

    public static TreeNode buildTree(Queue<String> queue){
        if (queue.isEmpty()){
            return null;
        }
        String s=queue.poll();
        if (s.equals(nullNode)){
            return null;
        }
        TreeNode node=new TreeNode(Integer.valueOf(s));
        node.left=buildTree(queue);
        node.right=buildTree(queue);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        TreeNode node=new TreeNode(3);
        node.left=new TreeNode(4);
        node.right=new TreeNode(5);
        root.right=node;
        System.out.println(serialize(root));
    }
}
