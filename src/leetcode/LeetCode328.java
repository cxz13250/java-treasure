package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * @Date: Created in 下午10:18 2018/6/18
 * @Modified By:
 */
public class LeetCode328 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head==null||head.next==null||head.next.next==null){
            return head;
        }
        ListNode heada=head;
        ListNode headb=head.next;
        ListNode prea=heada;
        ListNode preb=headb;
        ListNode cura=null,curb=null;
        if (heada.next.next!=null){
            cura=heada.next.next;
        }
        if (headb.next.next!=null){
            curb=headb.next.next;
        }
        while (cura!=null||curb!=null){
            if (cura!=null){
                prea.next=cura;
                prea=cura;
                if (prea.next!=null){
                    cura=prea.next.next;
                }else {
                    cura=null;
                }
            }
            if (curb!=null){
                preb.next=curb;
                preb=curb;
                if (preb.next!=null) {
                    curb = preb.next.next;
                }else {
                    curb=null;
                }
            }
        }
        prea.next=headb;
        preb.next=null;
        return head;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        ListNode node1=new ListNode(2);
        ListNode node2=new ListNode(3);
        ListNode node3=new ListNode(4);
        ListNode node4=new ListNode(5);
        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        ListNode res=oddEvenList(node);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
}
