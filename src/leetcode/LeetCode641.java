package leetcode;

/**
 * @Author ROKG
 * @Description 设计实现双端队列。
 * 你的实现需要支持以下操作：
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 * @Date: Created in 下午3:55 2018/9/8
 * @Modified By:
 */
public class LeetCode641 {

    int max=0;

    int length=0;

    Node head;

    Node tail;

    class Node{
        Node pre;
        Node next;
        int val;
        Node(int val){
            this.val=val;
        }
    }

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public LeetCode641(int k) {
        this.max=k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (length==max){
            return false;
        }
        if (length==0){
            head=new Node(value);
            tail=head;
            change1();
        }else if (length==1){
            head=new Node(value);
            change1();
        }else {
            Node node=new Node(value);
            head.pre=node;
            node.next=head;
            node.pre=tail;
            head=node;
            change2();
        }
        length++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (length==max){
            return false;
        }
        if (length==0){
            head=new Node(value);
            tail=head;
            change1();
        }else if (length==1){
            tail=new Node(value);
            change1();
        }else {
            Node node=new Node(value);
            tail.next=node;
            node.next=head;
            node.pre=tail;
            tail=node;
            change2();
        }
        length++;
        return true;
    }

    public void change1() {
        head.pre=tail;
        tail.next=head;
        head.next=tail;
        tail.pre=head;
    }

    public void change2(){
        head.pre=tail;
        tail.next=head;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (length==0){
            return false;
        }
        if (length==1){
            head=tail=null;
        }else {
            head=head.next;
            change2();
        }
        length--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (length==0){
            return false;
        }
        if (length==1){
            head=tail=null;
        }else {
            tail=tail.pre;
            change2();
        }
        length--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (head!=null){
            return head.val;
        }else {
            return -1;
        }
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (tail!=null){
            return tail.val;
        }else {
            return -1;
        }
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return length==0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return length==max;
    }

    public static void main(String[] args) {
        LeetCode641 l=new LeetCode641(97);
        l.insertFront(35);
        l.insertFront(10);
        System.out.println(l.getFront());
        l.insertLast(17);
        l.insertLast(14);
        System.out.println(l.getFront());
        l.isFull();
        l.isEmpty();
        System.out.println(l.getFront());
        l.isFull();
        l.deleteLast();
        l.insertFront(6);
        l.deleteLast();
        l.insertLast(39);
        System.out.println(l.getRear());
        l.deleteLast();
        System.out.println(l.getFront());
        l.deleteFront();
        System.out.println(l.getFront());
        l.insertLast(8);
        System.out.println(l.getFront());
        l.insertFront(31);
        System.out.println(l.getRear());
        l.deleteFront();
        l.isFull();
        System.out.println(l.getRear());
        l.insertFront(91);
        l.insertFront(0);
        System.out.println(l.getRear());
        l.insertFront(57);
        System.out.println(l.getRear());
        System.out.println(l.getRear());
        System.out.println(l.getRear());
        l.isFull();
        l.insertFront(56);
        l.insertFront(28);
        System.out.println(l.getRear());
        l.isFull();
        l.deleteLast();
        System.out.println(l.getFront());
        System.out.println(l.getRear());
        l.isFull();
        l.deleteLast();
        l.insertFront(43);
        l.deleteLast();
        System.out.println(l.getFront());
        l.deleteLast();
        System.out.println(l.getRear());
        l.insertLast(85);
        l.deleteFront();
        System.out.println(l.getFront());
        System.out.println(l.getRear());
    }
}
