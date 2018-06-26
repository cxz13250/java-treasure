package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author ROKG
 * @Description 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * 例如，[2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * @Date: Created in 下午11:17 2018/6/18
 * @Modified By: *
 */
public class LeetCode295 {

    //两个优先队列，第一个从小到大排列（为中位数到结尾），第二个从大到小排列（为中位数到开头）
    PriorityQueue<Integer> minQueue=new PriorityQueue<>();
    PriorityQueue<Integer> maxQueue=new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });

    public LeetCode295() {

    }

    public void addNum(int num) {
        if (minQueue.size()==maxQueue.size()){
            maxQueue.offer(num);
        }else {
            minQueue.offer(num);
        }
        if (!minQueue.isEmpty()&&(maxQueue.peek()>minQueue.peek())){
            minQueue.offer(maxQueue.poll());
            maxQueue.offer(minQueue.poll());
        }
    }

    public double findMedian() {
        if ((minQueue.size()+maxQueue.size())%2==0){
            return (minQueue.peek()+maxQueue.peek())*1.0/2;
        }else {
            return maxQueue.peek();
        }
    }
}
