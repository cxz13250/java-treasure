package leetcode;

/**
 * @Author ROKG
 * @Description 两个有序链表有序合并
 * @Date: Created in 下午11:53 2018/4/16
 * @Modified By:
 */
public class LeetCode21 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }
        ListNode head;
        ListNode p=l1;
        ListNode q=l2;
        if(p.val<=q.val){
            head=p;
            p=p.next;
        }else{
            head=q;
            q=q.next;
        }
        ListNode tmp=head;
        while(p!=null&&q!=null){
            if(p.val<=q.val){
                tmp.next=p;
                p=p.next;
            }else{
                tmp.next=q;
                q=q.next;
            }
            tmp=tmp.next;
        }
        if(p==null){
            tmp.next=q;
        }else if(q==null){
            tmp.next=p;
        }
        return head;
    }
}

