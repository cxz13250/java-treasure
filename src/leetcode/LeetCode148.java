package leetcode;

/**
 * @Author ROKG
 * @Description 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * @Date: Created in 下午5:23 2018/5/8
 * @Modified By:
 */
public class LeetCode148 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode sortList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode node=head;
        int tmp=0;
        while (node.next!=null){
            ListNode current=node.next;
            while (current!=null){
                if(node.val>current.val){
                    tmp=node.val;
                    node.val=current.val;
                    current.val=tmp;
                }
                current=current.next;
            }
            node=node.next;
        }
        return head;
    }
}
