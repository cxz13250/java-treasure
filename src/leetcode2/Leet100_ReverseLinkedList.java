package leetcode2;

import java.util.LinkedList;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午5:15 2024/2/12
 * @Modified By:
 */
public class Leet100_ReverseLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next = cur.next;
        pre.next = null;
        while (next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur.next;
        }
        cur.next = pre;
        return cur;
    }
}
