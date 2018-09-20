package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 * 返回一个符合上述规则的链表的列表。
 * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 * @Date: Created in 下午1:29 2018/9/16
 * @Modified By:
 */
public class LeetCode725 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        int length=0;
        ListNode node=root;
        while (node!=null){
            length++;
            node=node.next;
        }
        int d=length/k;
        int rem=length%k;
        ListNode[] res=new ListNode[k];
        if(d==0){
            ListNode tmp=root;
            for (int i=0;i<k;i++){
                if (tmp!=null) {
                    res[i] = tmp;
                    tmp=tmp.next;
                    res[i].next=null;
                }else {
                    res[i]=null;
                }
            }
        }else {
            ListNode tmp=root;
            for (int i=0;i<k;i++){
                res[i] = tmp;
                for (int j=0;j<d;j++){
                    if (j==d-1&&rem==0){
                        ListNode n=tmp;
                        tmp=tmp.next;
                        n.next=null;
                    }else {
                        tmp = tmp.next;
                    }
                }
                if (rem>0) {
                    ListNode n=tmp;
                    tmp=tmp.next;
                    n.next=null;
                    rem--;
                }
            }
        }
        return res;
    }
}
