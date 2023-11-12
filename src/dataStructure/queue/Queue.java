package dataStructure.queue;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午2:34 2018/4/5
 * @Modified By:
 */
public class Queue {

    LinkedList<Integer> stack1 = new LinkedList<>();
    LinkedList<Integer> stack2 = new LinkedList<>();

    public Queue() {

    }

    public void appendTail(int value) {
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public int deleteHead() {
        if (stack1.isEmpty()){
            return -1;
        }
        return stack1.pop();
    }


    public static void main(String[] args) {
        java.util.Queue<Integer> queue=new LinkedList<>();

    }
}
