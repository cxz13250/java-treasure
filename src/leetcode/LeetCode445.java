package leetcode;

/**
 * @Author ROKG
 * @Description 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * @Date: Created in 2018/7/25
 * @Modified By:
 */
public class LeetCode445 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1=reverse(l1);
        ListNode node2=reverse(l2);
        int flag=0;
        ListNode head=new ListNode(-1);
        head.next=node1;
        while (node1.next!=null&&node2.next!=null){
            int temp=(node1.val+node2.val+flag)/10;
            node1.val=(node1.val+node2.val+flag)%10;
            flag=temp;
            node1=node1.next;
            node2=node2.next;
        }
        int temp1=(node1.val+node2.val+flag)/10;
        node1.val=(node1.val+node2.val+flag)%10;
        flag=temp1;
        if (node1.next!=null){
            node1=node1.next;
            while (node1.next!=null){
                int temp=(node1.val+flag)/10;
                node1.val=(node1.val+flag)%10;
                flag=temp;
                node1=node1.next;
            }
            int temp=(node1.val+flag)/10;
            node1.val=(node1.val+flag)%10;
            flag=temp;
            if (flag!=0){
                node1.next=new ListNode(flag);
            }
        }else {
            node2=node2.next;
            while (node2!=null){
                int temp=(node2.val+flag)/10;
                node1.next=new ListNode((node2.val+flag)%10);
                flag=temp;
                node1=node1.next;
                node2=node2.next;
            }
            if (flag!=0){
                node1.next=new ListNode(flag);
            }
        }
        return reverse(head.next);
    }

    public ListNode reverse(ListNode head){
        ListNode node=head;
        ListNode pre=null;
        while (node!=null){
            ListNode current=node.next;
            if(current==null){
                head=node;
            }
            node.next=pre;
            pre=node;
            node=current;
        }
        return head;
    }

    public static void main(String[] args) {
//        ListNode node=new ListNode(7);
//        ListNode node1=new ListNode(2);
//        ListNode node2=new ListNode(4);
//        node2.next=new ListNode(3);
//        node1.next=node2;
//        node.next=node1;
//        ListNode node3=new ListNode(5);
//        ListNode node4=new ListNode(6);
//        node4.next=new ListNode(4);
//        node3.next=node4;
        LeetCode445 l =new LeetCode445();
        ListNode node=new ListNode(9);
        ListNode node3=new ListNode(9);
        node.next=new ListNode(9);
        l.addTwoNumbers(node,node3);
    }
}
