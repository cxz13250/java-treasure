package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author ROKG
 * @Description 使用队列实现栈
 * @Date: Created in 上午12:20 2018/4/30
 * @Modified By: *
 */
public class LeetCode225 {

    Queue<Integer> queue1=new LinkedList<>();
    Queue<Integer> queue2=new LinkedList<>();

    public LeetCode225() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.offer(x);
        while (!queue2.isEmpty()){
            queue1.offer(queue2.poll());
        }
        while (!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue2.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue2.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue2.isEmpty()&&queue1.isEmpty();
    }
}
