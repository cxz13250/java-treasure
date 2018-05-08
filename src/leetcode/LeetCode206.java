package leetcode;

/**
 * @Author ROKG
 * @Description 反转一个单链表。
 * @Date: Created in 下午5:40 2018/5/7
 * @Modified By:
 */
public class LeetCode206 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode p=head;
        ListNode q=head.next;
        p.next=null;
        while (head.next!=null){
            ListNode temp=q.next;
            q.next=p;
            p=q;
            q=temp;
        }
        q.next=p;
        return q;
    }

    public static void main(String[] args) {
        System.out.println(reverseList(null));
    }
}
