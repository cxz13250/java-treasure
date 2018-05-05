package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 给定一个二叉树，在树的最后一行找到最左边的值。
 * @Date: Created in 下午3:26 2018/5/2
 * @Modified By:
 */
public class LeetCode513 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Map<Integer,Integer> map=new HashMap<>();

    public int findBottomLeftValue(TreeNode root) {
        check(root,1);
        int height=map.size();
        return map.get(height);
    }

    public void check(TreeNode node,int height){
        if(node==null){
            return;
        }else {
            if(!map.containsKey(height)){
                map.put(height,node.val);
            }
            check(node.left,height+1);
            check(node.right,height+1);
        }
    }
}
