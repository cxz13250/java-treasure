package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，
 * 但一些节点为空。每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * @Date: Created in 下午9:59 2018/9/9
 * @Modified By:
 */
public class LeetCode662 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int x) { val = x; }
    }

    public static class MyNode extends TreeNode{
        int width;
        MyNode(TreeNode node,int width){
            super(node.val);
            this.width=width;
        }
    }

    static Map<Integer,List<MyNode>> map=new HashMap<>();

    public static int widthOfBinaryTree(TreeNode root) {
        check(root,0,1);
        int max=0;
        for (Map.Entry<Integer,List<MyNode>> entry:map.entrySet()){
            List<MyNode> nodes=entry.getValue();
            int width=0;
            if (nodes.size()>1){
                int start=nodes.get(0).width;
                int end=nodes.get(nodes.size()-1).width;
                width=end-start+1;
            }else {
                width=1;
            }
            max=Math.max(max,width);
        }
        return max;
    }

    public static void check(TreeNode node,int height,int width){
        if (node==null){
            return;
        }
        if (!map.containsKey(height)){
            List<MyNode> list=new ArrayList<>();
            list.add(new MyNode(node,width));
            map.put(height,list);
        }else {
            map.get(height).add(new MyNode(node,width));
        }
        check(node.left,height+1,2*width-1);
        check(node.right,height+1,2*width);
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode node=new TreeNode(2);
        TreeNode node1=new TreeNode(3);
        root.left=node1;
        root.right=node;
        TreeNode node2=new TreeNode(5);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(9);
        node1.left=node2;
        node1.right=node3;
        node.right=node4;
        System.out.println(widthOfBinaryTree(root));
    }
}
