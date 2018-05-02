package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 您需要在二叉树的每一行中找到最大的值。
 * @Date: Created in 下午2:32 2018/5/1
 * @Modified By:
 */
public class LeetCode515 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        check(root,0,list);
        return list;
    }

    public void check(TreeNode node,int height,List<Integer> list){
        if(node==null){
            return;
        }
        if(list.size()<=height){
            list.add(node.val);
        }else {
            list.set(height,Math.max(node.val,list.get(height)));
        }
        check(node.left,height+1,list);
        check(node.right,height+1,list);
    }
}
