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

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        else if(head.next == null) return new TreeNode(head.val);
        ListNode pre = head;
        ListNode p = pre.next;
        ListNode q = p.next;
        //找到链表的中点p
        while(q!=null && q.next!=null){
            pre = pre.next;
            p = pre.next;
            q = q.next.next;
        }
        //将中点左边的链表分开
        pre.next = null;
        TreeNode root = new TreeNode(p.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(p.next);
        return root;
    }
}
