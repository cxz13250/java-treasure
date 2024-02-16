package leetcode2;

import java.util.List;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午1:36 2024/2/13
 * @Modified By:
 */
public class Leet21_MergeTwoLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 != null && list2 == null) {
            return list1;
        }
        if (list1 == null && list2 != null) {
            return list2;
        }
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode result = new ListNode(-1);
        ListNode last = result;
        while (p1 != null && p2 != null) {
            ListNode temp1 = p1.next;
            ListNode temp2 = p2.next;
            if (p1.val > p2.val) {
                last.next = p2;
                last = p2;
                p2 = temp2;
            } else {
                last.next = p1;
                last = p1;
                p1 = temp1;
            }
        }
        if (p1 == null) {
            last.next = p2;
        }
        if (p2 == null) {
            last.next = p1;
        }
        return result.next;
    }
}
