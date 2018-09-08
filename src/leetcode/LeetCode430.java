package leetcode;

import java.util.Stack;

/**
 * @Author ROKG
 * @Description 您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表。
 * 这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 * 扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。
 * @Date: Created in 下午10:29 2018/9/6
 * @Modified By:
 */
public class LeetCode430 {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }
    public Node flatten(Node head) {
        if(head==null){
            return head;
        }
        Node node=new Node();
        Node cur=node;
        Stack<Node> stack=new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()){
            Node temp=stack.pop();
            cur.next=temp;
            temp.prev=cur;
            if (temp.next!=null){
                stack.push(temp.next);
            }
            if (temp.child!=null){
                stack.push(temp.child);
                temp.child=null;
            }
            cur=cur.next;
        }
        Node result=node.next;
        result.prev=null;
        return result;
    }
}
