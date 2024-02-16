package leetcode2;

import com.sun.jmx.snmp.SnmpNull;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午9:03 2024/2/11
 * @Modified By:
 */
public class Leet239_MaxOfSlidingWindows {

    // 双向链表
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1 && k == 1) {
            return new int[]{nums[0]};
        }
        LinkedList<Integer> position = new LinkedList<>();
        int res[] = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            while (!position.isEmpty() && position.getFirst() <= i - k) {
                position.removeFirst();
            }
            while (!position.isEmpty() && cur > nums[position.getLast()]) {
                position.removeLast();
            }
            position.add(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[position.getFirst()];
            }
        }
        return res;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        int[] res = new int[nums.length - k + 1];
        res[0] = queue.peek()[0];
        for (int i = k; i < nums.length; i++) {
            queue.offer(new int[]{nums[i], i});
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            res[i - k + 1] = queue.peek()[0];
        }
        return res;
    }
}
