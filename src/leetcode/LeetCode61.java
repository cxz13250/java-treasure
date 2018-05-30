package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * @Date: Created in 下午12:08 2018/5/24
 * @Modified By:
 */
public class LeetCode61 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head==null||k==0||head.next==null){
            return head;
        }
        int length=0;
        int step=k;
        ListNode node=head;
        while (node!=null){
            node=node.next;
            length++;
        }
        if (k>=length){
            if (k%length==0){
                return head;
            }
            step=step%length;
        }
        ListNode result=new ListNode(-1);
        node=head;
        int i=1;
        while (i<length-step){
            node=node.next;
            i++;
        }
        result.next=node.next;
        node.next=null;
        node=result.next;
        while (node.next!=null){
            node=node.next;
        }
        node.next=head;
        return result.next;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(0);
        ListNode node1=new ListNode(1);
        node.next=node1;
        node1.next=new ListNode(2);
        System.out.println(rotateRight(node,4).val);
    }
}
