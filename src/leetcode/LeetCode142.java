package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * @Date: Created in 下午6:38 2018/5/23
 * @Modified By: *
 */
public class LeetCode142 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode detectCycle(ListNode head) {
        if (head==null||head.next==head){
            return head;
        }
        ListNode p=head;
        ListNode q=head;
        ListNode l=null;
        ListNode r=null;
        ListNode result=null;
        while (q!=null&&q.next!=null){
            p=p.next;
            q=q.next.next;
            if(p==q){
                l=head;
                r=p;
                break;
            }
        }

        if (q!=null&&q.next!=null&&l!=null&&r!=null){
            while (l != r) {
                l=l.next;
                r=r.next;
            }
            result=l;
        }
        return result;
    }
}
