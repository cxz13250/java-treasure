package leetcode;

/**
 * @Author ROKG
 * @Description 请编写一个函数，使其可以删除某个链表中给定的（非末尾的）节点，您将只被给予要求被删除的节点。
 * @Date: Created in 下午10:30 2018/5/9
 * @Modified By:
 */
public class LeetCode237 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void deleteNode(ListNode node) {
        if (node!=null){
            node.val=node.next.val;
            node.next=node.next.next;
        }
    }
}
