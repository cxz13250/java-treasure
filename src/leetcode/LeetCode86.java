package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 应当保留两个分区中每个节点的初始相对位置。
 * @Date: Created in 下午5:04 2018/5/1
 * @Modified By:
 */
public class LeetCode86 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 解法一，两个节点，node标识比x小的最后一个节点，tail标识大于等于x的最后一个节点
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode node=new ListNode(-1);
        ListNode result=node;
        ListNode temp=head;
        ListNode tail=node;
        while (temp!=null){
            if(temp.val<x){
                ListNode p=temp.next;
                temp.next=node.next;
                node.next=temp;
                temp=p;
                node=node.next;
                if(tail.val==-1||tail.next==node){
                    tail=node;
                }
            }else {
                tail.next=temp;
                tail=tail.next;
                temp=temp.next;
                tail.next=null;
            }
        }
        return result.next;
    }

    /**
     * 解法二，使用两个链表，分别记录比x小和大于等于x的节点，最后将后者拼接在前者尾部
     * @param head
     * @param x
     * @return
     */
    public ListNode partition2(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummySmall = new ListNode(-1);
        ListNode dummyLarge = new ListNode(-1);

        ListNode tailSmall = dummySmall;
        ListNode tailLarge = dummyLarge;

        ListNode curNode = head;
        while (curNode != null) {
            if (curNode.val < x) {
                tailSmall.next = curNode;
                tailSmall = tailSmall.next;
            } else if (curNode.val >= x) {
                tailLarge.next = curNode;
                tailLarge = tailLarge.next;
            }

            curNode = curNode.next;
        }
        tailLarge.next = null;

        tailSmall.next = dummyLarge.next;

        return dummySmall.next;
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(4);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(2);
        ListNode node5=new ListNode(5);
        ListNode node6=new ListNode(2);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        ListNode result=partition(node1,3);
        while (result!=null){
            System.out.print(result.val+" ");
            result=result.next;
        }
    }
}
