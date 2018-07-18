package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Description 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * @Date: Created in 下午3:44 2018/7/14
 * @Modified By:
 */
public class LeetCode179 {

    public static String largestNumber(int[] nums) {
        StringBuilder sb=new StringBuilder();
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1=String.valueOf(o1)+String.valueOf(o2);
                String s2=String.valueOf(o2)+String.valueOf(o1);
                return (Long.valueOf(s1)-Long.valueOf(s2))>0?1:-1;
            }
        });
        for (int i:nums){
            queue.offer(i);
        }
        if (queue.peek().equals(0)){
            return "0";
        }
        while (!queue.isEmpty()){
            sb.append(queue.poll());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int s[]={999999998,999999997,999999999};
        System.out.println(largestNumber(s));
    }
}
