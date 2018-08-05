package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author ROKG
 * @Description 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
 * 如果没有和至少为 K 的非空子数组，返回 -1 。
 * @Date: Created in 下午5:30 2018/7/29
 * @Modified By: *
 */
public class LeetCode862 {


    public static int shortestSubarray(int[] A, int K) {
        int n=A.length;
        long[] nums=new long[n+1];
        for (int i=0;i<A.length;i++){
            nums[i+1]=A[i]+nums[i];
        }
        Deque<Integer> deque=new LinkedList<>();
        int res=n+1;
        for (int i=0;i<nums.length;i++){
            while (!deque.isEmpty()&&nums[i]<=nums[deque.getLast()]){
                deque.removeLast();
            }
            while (!deque.isEmpty()&&nums[i]>=nums[deque.getFirst()]+K){
                res=Math.min(res,i-deque.removeFirst());
            }
            deque.offer(i);
        }
        return res==n+1?-1:res;
    }

    public static void main(String[] args) {
        int[] A={84,-37,32,40,95};
        System.out.println(shortestSubarray(A,167));
    }
}
