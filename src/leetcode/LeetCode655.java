package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author ROKG
 * @Description 在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则：
 * 行数 m 应当等于给定二叉树的高度。
 * 列数 n 应当总是奇数。
 * 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，如果两个子树都为空则不需要为它们留出任何空间。
 * 每个未使用的空间应包含一个空的字符串""。
 * 使用相同的规则输出子树。
 * @Date: Created in 下午10:47 2018/9/10
 * @Modified By:
 */
public class LeetCode655 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res=new ArrayList<>();
        int height=getHeight(root);
        int width=(int)Math.pow(2,height)-1;
        for (int i=0;i<height;i++){
            List<String> list=new ArrayList<>();
            for (int j=0;j<width;j++){
                list.add("");
            }
            res.add(list);
        }
        check(res,root,0,width,0);
        return res;
    }

    public void check(List<List<String>> res,TreeNode node,int left,int right,int height){
        if (node==null){
            return;
        }
        int mid=(left+right)/2;
        List<String> list=res.get(height);
        list.set(mid,String.valueOf(node.val));
        check(res,node.left,left,mid-1,height+1);
        check(res,node.right,mid+1,right,height+1);
    }

    public int getHeight(TreeNode node){
        if (node==null){
            return 0;
        }
        return 1+Math.max(getHeight(node.left),getHeight(node.right));
    }

    public static void main(String[] args) {
        LeetCode655 l=new LeetCode655();
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        System.out.println(l.printTree(node));
    }
}
