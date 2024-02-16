package leetcode2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 上午10:53 2024/2/15
 * @Modified By:
 */
public class Leet234_PalindromeLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 栈
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        p = head;
        while (p != null) {
            ListNode q = stack.pop();
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
        }
        return true;
    }

    // 转化数组，双指针
    public boolean isPalindrome2(ListNode head) {
        List<Integer> vals = new ArrayList<>();

        // 将链表的值复制到数组中
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 使用双指针判断是否回文
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}
