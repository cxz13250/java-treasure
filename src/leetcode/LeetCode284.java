package leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author ROKG
 * @Description 给定一个迭代器类的接口，接口包含两个方法： next() 和 hasNext()。设计并实现一个支持 peek() 操作的顶端迭代器 --
 * 其本质就是把原本应由 next() 方法返回的元素 peek() 出来。
 * @Date: Created in 下午3:58 2018/6/29
 * @Modified By:
 */
public class LeetCode284 {

    class PeekingIterator implements Iterator<Integer> {

        Queue<Integer> queue;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            queue=new LinkedList<>();
            while (iterator.hasNext()){
                queue.offer(iterator.next());
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return queue.peek();
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            return queue.poll();
        }

        @Override
        public boolean hasNext() {
            return queue.size()>0;
        }
    }
}
