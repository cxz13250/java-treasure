package leetcode2;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 上午10:51 2023/7/29
 * @Modified By:
 */
public class Leet2_TwoNumbersAdd {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res;
        // 先处理头
        int value = l1.val + l2.val;
        // 标记进制
        int flag = 0;
        if (value >= 10) {
            flag = 1;
        }
        res = new ListNode(value % 10);
        // 移动指针
        ListNode pre = res;
        ListNode iterator1 = l1.next;
        ListNode iterator2 = l2.next;

        while (iterator1 != null && iterator2 != null) {
            value = iterator1.val + iterator2.val + flag;
            if (value >= 10) {
                flag = 1;
            } else {
                flag = 0;
            }
            ListNode tmp = new ListNode(value % 10);
            pre.next = tmp;
            pre = tmp;
            iterator1 = iterator1.next;
            iterator2 = iterator2.next;
        }
        // 处理尾巴
        if (iterator1 != null) {
            while (iterator1 != null) {
                value = flag + iterator1.val;
                if (value >= 10) {
                    flag = 1;
                } else {
                    flag = 0;
                }
                ListNode tmp = new ListNode(value % 10);
                pre.next = tmp;
                pre = tmp;
                iterator1 = iterator1.next;
            }
        } else {
            while (iterator2 != null) {
                value = flag + iterator2.val;
                if (value >= 10) {
                    flag = 1;
                } else {
                    flag = 0;
                }
                ListNode tmp = new ListNode(value % 10);
                pre.next = tmp;
                pre = tmp;
                iterator2 = iterator2.next;
            }
        }
        if (flag != 0) {
            pre.next = new ListNode(1);
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(2);
        ListNode l1 = new ListNode(4);
        ListNode j1 = new ListNode(3);
        h1.next = l1;
        l1.next = j1;
        ListNode h2 = new ListNode(5);
        ListNode l2 = new ListNode(6);
        ListNode j2 = new ListNode(4);
        h2.next = l2;
        l2.next = j2;
        ListNode res = addTwoNumbers(h1, h2);
        ListNode p = res;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
