package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * @Date: Created in 下午1:17 2018/5/30
 * @Modified By: *
 */
public class LeetCode109 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    ListNode cur;

    public TreeNode sortedListToBST(ListNode head) {
        if (head==null){
            return null;
        }
        cur=head;
        ListNode node=head;
        int length=0;
        while (node!=null){
            length++;
            node=node.next;
        }
        return build(0,length-1);
    }

    public TreeNode build(int left,int right){
        if (left>right){
            return null;
        }
        int mid=left+(right-left)/2;
        TreeNode lnode=build(left,mid-1);
        TreeNode root=new TreeNode(cur.val);
        cur=cur.next;
        root.left=lnode;
        TreeNode rnode=build(mid+1,right);
        root.right=rnode;
        return root;
    }
}
