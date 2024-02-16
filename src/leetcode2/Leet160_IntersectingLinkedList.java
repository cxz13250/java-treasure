package leetcode2;

import java.util.List;
import java.util.Stack;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午4:40 2024/2/12
 * @Modified By:
 */
public class Leet160_IntersectingLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 栈先进后出，实现从尾开始遍历
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA= new Stack<>();
        ListNode iteratorA = headA;
        while (iteratorA != null) {
            stackA.add(iteratorA);
            iteratorA = iteratorA.next;
        }
        Stack<ListNode> stackB = new Stack<>();
        ListNode iteratorB = headB;
        while (iteratorB != null) {
            stackB.add(iteratorB);
            iteratorB = iteratorB.next;
        }
        ListNode result = null;
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            ListNode nodeA = stackA.pop();
            ListNode nodeB = stackB.pop();
            if (nodeA == nodeB) {
                result = nodeA;
            }
        }
        return result;
    }

    // 双指针向前遍历，谁先遍历完，就从另外一个链表的头继续遍历
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}
