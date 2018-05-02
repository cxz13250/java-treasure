package leetcode;

import java.util.Stack;

/**
 * @Author ROKG
 * @Description 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * @Date: Created in 上午12:03 2018/5/1
 * @Modified By:
 */
public class LeetCode155 {

    Stack<Integer> stack1=new Stack<>();
    Stack<Integer> stack2=new Stack<>();

    public LeetCode155() {

    }

    public void push(int x) {
        stack1.push(x);
        if(stack2.empty()){
            stack2.push(x);
        }else {
            int temp = stack2.peek();
            stack2.push(Math.min(temp, x));
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
