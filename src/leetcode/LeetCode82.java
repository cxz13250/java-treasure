package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * @Date: Created in 下午2:24 2018/6/1
 * @Modified By:
 */
public class LeetCode82 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode node=new ListNode(-1);
        node.next=head;
        ListNode tail=node;
        ListNode pre=head;
        ListNode cur=head.next;
        boolean flag=false;
        while (cur!=null){
            if (cur.val!=pre.val){
                if (flag) {
                    tail.next = cur;
                    flag=false;
                }else {
                    tail=tail.next;
                    tail.next=cur;
                }
            }else {
                flag=true;
            }
            pre=cur;
            cur=cur.next;
        }
        if (flag){
            tail.next=cur;
        }
        return node.next;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        ListNode node1=new ListNode(2);
        ListNode node2=new ListNode(3);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(4);
        ListNode node6=new ListNode(5);
        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        ListNode node7=new ListNode(1);
        node7.next=new ListNode(1);
        ListNode result=deleteDuplicates(node);
        while (result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
}
