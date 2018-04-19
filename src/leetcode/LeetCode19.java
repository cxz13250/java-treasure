package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * @Date: Created in 下午1:06 2018/4/18
 * @Modified By:
 */
public class LeetCode19 {

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p=head;
        ListNode q=head;
        int i=0;
        while (i<=n){
            if(p==null){
                if(n==1){
                    return null;
                }
                if(n==i){
                    head=head.next;
                }
                return head;
            }
            p=p.next;
            i++;
        }
        while (p!=null){
            p=p.next;
            q=q.next;
        }
        q.next=q.next.next;
        return head;
    }

    public static void main(String[] args) {

    }
}
