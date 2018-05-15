package leetcode;

/**
 * @Author ROKG
 * @Description 删除链表中等于给定值 val 的所有节点。
 * @Date: Created in 下午10:58 2018/5/9
 * @Modified By:
 */
public class LeetCode203 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode node=head;
        ListNode result=new ListNode(-1);
        result.next=node;
        ListNode pre=result;
        while (node!=null){
            if (node.val==val){
                if (node.next==null){
                    pre.next=null;
                    break;
                }else {
                    pre.next=node.next;
                    node=node.next;
                }
            }else {
                pre = node;
                node = node.next;
            }
        }
        return result.next;
    }
}
