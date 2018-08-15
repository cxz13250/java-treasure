package leetcode;

import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * @Date: Created in 上午12:09 2018/8/14
 * @Modified By:
 */
public class LeetCode876 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode middleNode(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode fast=head.next;
        ListNode slow=head;
        while (fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow.next;
    }
}
