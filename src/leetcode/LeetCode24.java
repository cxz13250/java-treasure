package leetcode;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午8:29 2018/4/18
 * @Modified By:
 */
public class LeetCode24 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode b=head;
        ListNode c=b.next;
        ListNode a=new ListNode(-1);
        head=a;
        while(b!=null&&c!=null){
            a.next=c;
            b.next=c.next;
            c.next=b;
            a=b;
            b=b.next;
            if(b==null){
                break;
            }
            c=b.next;
        }
        return head.next;
    }

    public static void main(String[] args) {

    }
}
