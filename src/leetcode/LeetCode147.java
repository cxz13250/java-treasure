package leetcode;

/**
 * @Author ROKG
 * @Description 对链表进行插入排序。
 * @Date: Created in 下午1:47 2018/5/30
 * @Modified By:
 */
public class LeetCode147 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode infi=new ListNode(Integer.MIN_VALUE);
        infi.next=head;
        ListNode pre=head;
        ListNode cur=head.next;
        while (cur!=null){
            boolean flag=false;
            ListNode search=infi.next;
            ListNode searchPre=infi;
            while (search!=cur){
                if (cur.val<search.val){
                    pre.next=cur.next;
                    searchPre.next=cur;
                    cur.next=search;
                    cur=pre.next;
                    flag=true;
                    break;
                }
                searchPre=search;
                search=search.next;
            }
            if (search==cur){
                pre=cur;
                cur=cur.next;
                continue;
            }
            if (flag){
                continue;
            }
            pre=cur;
            cur=cur.next;
        }
        return infi.next;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(4);
        ListNode node1=new ListNode(2);
        ListNode node2=new ListNode(1);
        ListNode node3=new ListNode(3);
        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        ListNode result=insertionSortList(node);
        while (result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
}
