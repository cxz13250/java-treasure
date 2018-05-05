package leetcode;

import java.util.HashSet;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午8:37 2018/5/3
 * @Modified By:
 */
public class LeetCode160 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 使用HashSet
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p=headA;
        ListNode q=headB;
        HashSet<ListNode> set=new HashSet<>();
        while (p!=null){
            set.add(p);
            p=p.next;
        }
        while (q!=null){
            if(set.contains(q)){
                return q;
            }else {
                set.add(q);
                q = q.next;
            }
        }
        return null;
    }

    /**
     * 长度计算
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        int lenA=0;
        int lenB=0;
        ListNode p=headA;
        ListNode q=headB;
        while (p.next!=null){
            lenA++;
            p=p.next;
        }
        while (q.next!=null){
            lenB++;
            q=q.next;
        }
        if(p.val!=q.val){
            return null;
        }
        ListNode nodeA,nodeB;
        int diff=Math.abs(lenA-lenB);
        if (lenA>lenB){
            nodeA=headA;
            nodeB=headB;
        }else {
            nodeA=headB;
            nodeB=headA;
        }
        while (diff>0){
            nodeA=nodeA.next;
            diff--;
        }
        while (nodeA!=null){
            if(nodeA.val!=nodeB.val){
                nodeA=nodeA.next;
                nodeB=nodeB.next;
            }else {
                return nodeA;
            }
        }
        return null;
    }
}
