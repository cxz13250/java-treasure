package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author ROKG
 * @Description 这里有 n 门不同的在线课程，他们按从 1 到 n 编号。每一门课程有一定的持续上课时间（课程时间）t 以及关闭时间第 d 天。
 * 一门课要持续学习 t 天直到第 d 天时要完成，你将会从第 1 天开始。
 * 给出 n 个在线课程用 (t, d) 对表示。你的任务是找出最多可以修几门课。
 * @Date: Created in 下午2:32 2018/9/15
 * @Modified By: *
 */
public class LeetCode630 {

    // 贪心算法，每次检验当前课程耗时+已耗时间是否超过当前课程的结束时间
    // 若超过则删除前面耗时最久的课程，通过优先队列 O(nlogn)
    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)-> a[1]-b[1]);
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>((a,b)->b-a);
        int now=0;
        for (int i=0;i<courses.length;i++){
            queue.offer(courses[i][0]);
            now +=courses[i][0];
            if (now>courses[i][1]){
                now-=queue.poll();
            }
        }
        return queue.size();
    }

    public static void main(String[] args) {
        System.out.println(scheduleCourse(new int[][]{{100,200},{200,1300},{1000,1250},{2000,3200}}));
    }
}
