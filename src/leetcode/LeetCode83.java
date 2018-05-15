package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * @Date: Created in 下午1:32 2018/5/15
 * @Modified By:
 */
public class LeetCode83 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp=null;
        ListNode node=head;
        while (node!=null){
            if (temp==null){
                temp=node;
            }else if (temp.val!=node.val){
                temp.next=node;
                temp=node;
            }
            node=node.next;
        }
        return head;
    }
}
