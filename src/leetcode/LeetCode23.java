package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author ROKG
 * @Description 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * @Date: Created in 下午8:18 2018/4/18
 * @Modified By:
 */
public class LeetCode23 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //第一种解法，两两合并
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        ListNode result=lists[0];
        for(int i=1;i<lists.length;i++){
            result=mergeTwoLists(result,lists[i]);
        }
        return result;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }
        ListNode head;
        ListNode p=l1;
        ListNode q=l2;
        if(p.val<=q.val){
            head=p;
            p=p.next;
        }else{
            head=q;
            q=q.next;
        }
        ListNode tmp=head;
        while(p!=null&&q!=null){
            if(p.val<=q.val){
                tmp.next=p;
                p=p.next;
            }else{
                tmp.next=q;
                q=q.next;
            }
            tmp=tmp.next;
        }
        if(p==null){
            tmp.next=q;
        }else if(q==null){
            tmp.next=p;
        }
        return head;
    }

    private static final Comparator<ListNode> comparator=new Comparator<ListNode>() {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val-o2.val;
        }
    };

    //第二种解法，优先队列
    public static ListNode mergeKListsByQueue(ListNode[] lists) {
        if(lists.length==0) {
            return null;
        }
        Queue<ListNode> queue=new PriorityQueue<>(lists.length,comparator);
        for (ListNode node:lists){
            if(node==null){
                continue;
            }
            queue.offer(node);
        }
        if(queue.isEmpty()){
            return null;
        }
        ListNode node=queue.poll();
        if (node.next!=null){
            queue.offer(node.next);
        }
        ListNode head=node;
        while (!queue.isEmpty()){
            ListNode temp=queue.poll();
            node.next=temp;
            node=node.next;
            if(temp.next!=null){
                queue.offer(temp.next);
            }
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
