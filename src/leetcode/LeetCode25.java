package leetcode;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 上午10:12 2018/4/21
 * @Modified By:
 */
public class LeetCode25 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int i=0;
        ListNode p=head;
        while(p!=null&&i<k){
            p=p.next;
            i++;
        }
        if(i==k){
            p=reverseKGroup(p,k);
            while(i>0){
                ListNode temp=head.next;
                head.next=p;
                p=head;
                head=temp;
                i--;
            }
            head=p;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
