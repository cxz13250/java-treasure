package leetcode;

/**
 * @Author ROKG
 * @Description 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * @Date: Created in 上午12:14 2018/5/7
 * @Modified By:
 */
public class LeetCode92 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head.next==null||m==n){
            return head;
        }
        ListNode result=new ListNode(-1);
        result.next=head;
        ListNode node=result;  // node指针遍历整个链表，最后指向第n+1个节点，或者空
        int i=0;
        while (i<m-1&&node!=null){
            node=node.next;
            i++;
        }
        ListNode p=node;  // p指针标记第m-1个节点
        ListNode q=node.next;  // p指针标记第m个节点，即反转链表的尾
        ListNode pre=q;  // pre指针标记第n个节点，即反转链表的头
        node=q.next;
        i+=2;
        while (i<=n&&node!=null){
            ListNode temp=node;
            node=node.next;
            temp.next=pre;
            pre=temp;
            i++;
        }
        if(node!=null) {
            p.next = pre;
            q.next = node;
        }else{
            p.next = pre;
            q.next = null;
        }
        return result.next;
    }
}
