package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
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
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode pro = pre.next;
        ListNode next = pro.next;
        ListNode tail = new ListNode(-1);
        ListNode result = pro;
        while(next!=null && next.next!=null){
            tail.next = pro;
            pro.next = pre;
            pre.next = next;
            tail = pre;
            pre = next;
            pro = pre.next;
            next = pro.next;
        }
        tail.next = pro;
        pro.next = pre;
        pre.next = next;
        return result;
    }

    public static void main(String[] args) {

    }
}
