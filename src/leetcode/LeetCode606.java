package leetcode;

/**
 * @Author ROKG
 * @Description 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 * @Date: Created in 上午12:31 2018/8/16
 * @Modified By:
 */
public class LeetCode606 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public String tree2str(TreeNode t) {
        if (t==null){
            return "";
        }else {
            return check(t,-1);
        }
    }

    public String check(TreeNode t,int flag){
        if(t==null){
            if (flag==0){
                return "()";
            }else {
                return "";
            }
        }
        String left,right;
        if (t.left==null&&t.right!=null){
            left="()";
            right="("+check(t.right,1)+")";
        }else if (t.right==null&&t.left!=null){
            right="";
            left="("+check(t.left,0)+")";
        }else if (t.left!=null&t.right!=null){
            left="("+check(t.left,0)+")";
            right="("+check(t.right,1)+")";
        }else {
            left="";
            right="";
        }
        return t.val+left+right;
    }
}
