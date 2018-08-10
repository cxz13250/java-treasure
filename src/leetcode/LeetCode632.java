package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author ROKG
 * @Description 你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
 * 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
 * @Date: Created in 2018/8/10
 * @Modified By: *
 */
public class LeetCode632 {

    // 数组第一位为元素值，第二位为所在list下表，第三位为在list中的下标
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b) -> a[0]-b[0]);
        int max=0;
        int minLeft=Integer.MAX_VALUE;
        int minRight=Integer.MAX_VALUE;
        int range=Integer.MAX_VALUE;
        for (int i=0;i<nums.size();i++){
            int val=nums.get(i).get(0);
            max=Math.max(max,val);
            queue.offer(new int[]{val,i,0});
        }
        while (range!=0){
            int[] temp=queue.poll();
            if (max-temp[0]<range){
                range=max-temp[0];
                minLeft=temp[0];
                minRight=max;
            }
            int i=temp[1];
            int j=temp[2];
            j++;
            if (j==nums.get(i).size()){
                break;
            }
            int val=nums.get(i).get(j);
            if (val>max){
                max=val;
            }
            queue.offer(new int[]{val,i,j});
        }
        return new int[]{minLeft, minRight};
    }
}
