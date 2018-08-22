package leetcode;

import java.util.PriorityQueue;

/**
 * @Author ROKG
 * @Description 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 * @Date: Created in 上午11:03 2018/8/20
 * @Modified By:
 */
public class LeetCode703 {

    class KthLargest {

        PriorityQueue<Integer> queue=new PriorityQueue<>();

        int k;

        public KthLargest(int k, int[] nums) {
            for (int i=0;i<nums.length;i++){
                queue.offer(nums[i]);
                if (i>k){
                    queue.poll();
                }
            }
            this.k=k;
        }

        public int add(int val) {
            queue.offer(val);
            while (queue.size()>k){
                queue.poll();
            }
            return queue.peek();
        }
    }
}


