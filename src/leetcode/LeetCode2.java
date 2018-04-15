package leetcode;

import java.util.List;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午10:10 2018/4/10
 * @Modified By:
 */
public class LeetCode2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp=l1.val+l2.val;
        ListNode node;
        int add=0;
        if(temp<10){
            node=new ListNode(temp);
        }else{
            add=1;
            node=new ListNode(temp%10);
        }
        ListNode p=node;
        l1=l1.next;
        l2=l2.next;
        while(l1!=null || l2!=null){
            if(l1!=null&&l2!=null){
                int cache=l1.val+l2.val+add;
                p.next=new ListNode(cache%10);
                if(cache>=10){
                    add=1;
                }else{
                    add=0;
                }
                p=p.next;
                l1=l1.next;
                l2=l2.next;
            }else if(l2!=null){
                int cache=l2.val+add;
                if(cache>=10){
                    add=1;
                }else{
                    add=0;
                }
                p.next=new ListNode(cache%10);
                p=p.next;
                l2=l2.next;
            }else if(l1!=null){
                int cache=l1.val+add;
                if(cache>=10){
                    add=1;
                }else{
                    add=0;
                }
                p.next=new ListNode(cache%10);
                p=p.next;
                l1=l1.next;
            }
        }
        if(add!=0){
            p.next=new ListNode(add);
        }
        return node;
    }
}
