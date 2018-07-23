package leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author ROKG
 * @Description 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
 * @Date: Created in 2018/7/23
 * @Modified By:
 */
public class LeetCode622 {

    class MyCircularQueue {

        int[] queue;
        int max;
        int length=0;
        int start=-1;
        int end=-1;

        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            max=k;
            queue=new int[k];
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if (isFull()){
                return false;
            }
            queue[(end+1)%max]=value;
            end=(end+1)%max;
            length++;
            if (start==-1){
                start++;
            }
            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if (isEmpty()){
                return false;
            }
            start=(start+1)%max;
            length--;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            if (isEmpty()){
                return -1;
            }
            return queue[start];
        }

        /** Get the last item from the queue. */
        public int Rear() {
            if (isEmpty()){
                return -1;
            }
            return queue[end];
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return length==0;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return length==max;
        }
    }
}
