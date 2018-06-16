package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author ROKG
 * @Description 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * @Date: Created in 下午3:12 2018/5/31
 * @Modified By:
 */
public class LeetCode215 {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public int findKthLargest2(int[] nums, int k) {
        Queue<Integer> queue=new PriorityQueue<>();
        for (int i=0;i<k;i++){
            queue.offer(nums[i]);
        }

        for (int i=k;i<nums.length;i++){
            if (nums[i]<=queue.peek()){
                continue;
            }else {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }
}
