package leetcode;

import java.util.Random;

/**
 * @Author ROKG
 * @Description 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
 * @Date: Created in 下午10:47 2018/4/18
 * @Modified By:
 */
public class LeetCode382 {

    int length;
    ListNode head;

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public LeetCode382(ListNode head) {
        int i=0;
        this.head=head;
        while (head!=null){
            i++;
            head=head.next;
        }
        length=i;
    }

    public int getRandom() {
        int i=(int)Math.ceil(Math.random()*length)-1;
        ListNode temp=head;
        while (i>0){
            temp=temp.next;
            i--;
        }
        return temp.val;
    }

    public int getRandom2(){
        Random rand = new Random();
        int idx = 0;
        int result = 0;
        ListNode cur = head;
        while (cur != null){
            if (rand.nextInt(idx + 1) == idx){
                result = cur.val;
            }
            idx ++;
            cur = cur.next;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
