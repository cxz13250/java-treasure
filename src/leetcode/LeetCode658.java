package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Description 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
 * @Date: Created in 2018/9/14
 * @Modified By:
 */
public class LeetCode658 {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> queue=new PriorityQueue<>((a,b)-> {
            if (a[1]!=b[1]){
                return a[1]-b[1];
            }else {
                return a[0]-b[0];
            }
        });
        for (int i:arr){
            queue.offer(new int[]{i,Math.abs(i-x)});
        }
        List<Integer> res=new ArrayList<>();
        for (int i=0;i<k;i++){
            res.add(queue.poll()[0]);
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{1,2,5,5,6,6,7,7,8,9},7, 7));
    }
}
