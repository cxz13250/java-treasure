package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @Date: Created in 下午2:43 2018/5/22
 * @Modified By:
 */
public class LeetCode143 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void reorderList(ListNode head) {
        if (head==null || head.next==null){
            return;
        }
        ListNode node=head;
        List<ListNode> nodes=new ArrayList<>();
        while (node!=null){
            nodes.add(node);
            node=node.next;
        }
        int index=nodes.size()-1;
        ListNode pre=head;
        ListNode next=head.next;
        while (index>nodes.size()/2){
            ListNode temp=nodes.get(index);
            pre.next=temp;
            temp.next=next;
            pre=next;
            next=next.next;
            index--;
        }
        if (nodes.size()%2==0) {
            next.next = null;
        }else{
            pre.next = null;
        }
    }
}
