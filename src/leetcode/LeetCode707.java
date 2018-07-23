package leetcode;

/**
 * @Author ROKG
 * @Description 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，
 * next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * @Date: Created in 2018/7/23
 * @Modified By:
 */
public class LeetCode707 {

    static class MyLinkedList {

        class Node{
            int val;
            Node next;
            Node(int i){
                val=i;
            }
        }
        Node head;

        /** Initialize your data structure here. */
        public MyLinkedList() {

        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            int i=0;
            Node node=head;
            while (node!=null&&i<index){
                node=node.next;
                i++;
            }
            if (i==index){
                return node.val;
            }else {
                return -1;
            }
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            Node node=new Node(val);
            node.next=head;
            head=node;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            Node node=head;
            if (node==null){
                head=new Node(val);
                return;
            }
            while (node.next!=null){
                node=node.next;
            }
            node.next=new Node(val);
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if (head==null){
                if (index==0) {
                    head = new Node(val);
                }else {
                    return;
                }
            }
            int i=0;
            Node node=head;
            while (node.next!=null&&i<index-1){
                node=node.next;
                i++;
            }
            if (i==index-1) {
                Node next = node.next;
                Node newNode = new Node(val);
                node.next = newNode;
                newNode.next = next;
            }
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (index==0){
                if (head.next==null){
                    head=null;
                }else {
                    head=head.next;
                }
            }
            int i=0;
            Node node=head;
            while (node.next!=null&&i<index-1){
                node=node.next;
                i++;
            }
            Node del=node.next;
            Node next=null;
            if (node.next!=null){
                next=node.next.next;
            }
            node.next=next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList m=new MyLinkedList();
        m.addAtHead(1);
        m.addAtTail(3);
        m.addAtIndex(1,2);
        m.get(1);
        m.deleteAtIndex(1);
        m.get(1);
    }
}
