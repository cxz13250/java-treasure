package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author ROKG
 * @Description 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
 * 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
 * @Date: Created in 下午9:13 2018/6/19
 * @Modified By:
 */
public class LeetCode373 {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result=new ArrayList<>();
        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]+o1[1]-o2[0]-o2[1];
            }
        });
        for (int i=0;i<nums1.length;i++){
            for (int j=0;j<nums2.length;j++){
                queue.offer(new int[]{nums1[i],nums2[j]});
            }
        }
        for (int i=0;i<k&&queue.size()>0;i++){
            int[] nums=queue.poll();
            result.add(nums);
        }
        return result;
    }

    //优化复杂度
    public List<int[]> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        if (nums1.length==0 || nums2.length==0){
            return new ArrayList<>();
        }
        List<int[]> result=new ArrayList<>();
        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]+o1[1]-o2[0]-o2[1];
            }
        });
        for (int i=0;i<nums1.length;i++){
            queue.offer(new int[]{nums1[i],nums2[0],0});
        }
        while (result.size()<k&&!queue.isEmpty()){
            int[] cur=queue.poll();
            result.add(new int[]{cur[0],cur[1]});
            if (cur[2]==nums2.length-1){
                continue;
            }
            queue.offer(new int[]{cur[0],nums2[cur[2]+1],cur[2]+1});
        }
        return result;
    }
}
