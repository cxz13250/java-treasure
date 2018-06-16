package leetcode;

/**
 * @Author ROKG
 * @Description 请判断一个链表是否为回文链表。O(n)时间复杂度，O(1)空间复杂度
 * @Date: Created in 下午4:04 2018/5/31
 * @Modified By:
 */
public class LeetCode234 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static boolean isPalindrome(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head;
        while (fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode compare=reverse(slow.next);
        ListNode cur=head;
        while (compare!=null){
            if (compare.val!=cur.val){
                return false;
            }
            cur=cur.next;
            compare=compare.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode node){
        if (node==null||node.next==null){
            return node;
        }
        ListNode p=node;
        ListNode q=node.next;
        p.next=null;
        while (q.next!=null){
            ListNode temp=q.next;
            q.next=p;
            p=q;
            q=temp;
        }
        q.next=p;
        return q;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        ListNode nod1=new ListNode(1);
        ListNode nod2=new ListNode(2);
        ListNode nod3=new ListNode(1);
        node.next=nod1;
        nod1.next=nod2;
        nod2.next=nod3;
        System.out.println(isPalindrome(node));
    }
}
