package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个链表，判断链表中是否有环。
 * @Date: Created in 下午5:20 2018/5/5
 * @Modified By:
 */
public class LeetCode141 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean hasCycle(ListNode head) {
        ListNode p=head;
        ListNode q=head;
        while (q!=null&&q.next!=null){
            if(p==q&&p!=head){
                return true;
            }
           p=p.next;
           q=q.next.next;
        }
        return false;
    }
}
