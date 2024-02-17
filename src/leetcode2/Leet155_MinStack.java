package leetcode2;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午10:34 2024/2/16
 * @Modified By:
 */
public class Leet155_MinStack {

    class MinStack {

        private Stack<Integer> stackVal;

        private Stack<Integer> stackMin;

        public MinStack() {
            stackVal = new Stack<>();
            stackMin = new Stack<>();
        }

        public void push(int val) {
            stackVal.push(val);
            if (stackMin.isEmpty()) {
                stackMin.push(val);
            } else {
                int lastMin = stackMin.peek();
                stackMin.push(Math.min(lastMin, val));
            }
        }

        public void pop() {
            stackMin.pop();
            stackVal.pop();
        }

        public int top() {
            return stackVal.peek();
        }

        public int getMin() {
            return stackMin.peek();
        }

    }


    class MinStack2 {

        // 记录当前元素与上一个最小值之间的diff
        // diff>0 说明 当前元素比上个最小值大 栈顶元素=当前最小值+diff 出栈时 最小值不用更新
        // diff=0 说明 当前元素等于上一个最小值 栈顶元素=当前最小值 出栈时 最小值不用更新
        // diff<0 说明 当前元素比上个最小值小 栈顶元素=当前最小值 出栈时 更新最小值=当前小值-diff
        private LinkedList<Long> stackDiff;

        private long stackMin;

        public MinStack2() {
            stackDiff = new LinkedList<>();
        }

        // 先进后出，所以插入在链首
        public void push(int val) {
            if (stackDiff.isEmpty()) {
                stackDiff.addFirst(0L);
                stackMin = val;
            } else {
                stackDiff.addFirst(val - stackMin);
                stackMin = Math.min((long)val, stackMin);
            }
        }

        public void pop() {
            long diff = stackDiff.removeFirst();
            // diff < 0 说明栈顶元素比上一个最小值还小，也就说明当前最小值就是栈顶元素，可以反算出上一个最小值
            if (diff < 0) {
                stackMin = stackMin - diff;
            }
            // diff >=0 说明当前最小值不用更新，就是上一个最小值
        }

        public int top() {
            long diff = stackDiff.peek();
            if (diff <= 0) {
                // diff <=0 说明栈顶元素就是最小值
                return (int)stackMin;
            }
            // diff > 0 说明当前值比上一个最小值大，可以反算出当前值
            return (int) (stackMin + diff);
        }

        public int getMin() {
            return (int) stackMin;
        }

    }

}
