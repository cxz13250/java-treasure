package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author ROKG
 * @Description 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 *
 * @Date: Created in 下午8:42 2020/5/17
 * @Modified By:
 */
public class LeetCode210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<>();
        int[] count = new int[numCourses];
        int[] res = new int[numCourses];
        List<Integer>[] lists = new ArrayList[numCourses];
        int index=0;
        for (int[] i:prerequisites){
            count[i[0]]++;
            if(lists[i[1]] == null){
                lists[i[1]] = new ArrayList<>();
            }
            lists[i[1]].add(i[0]);
        }
        for (int i=0;i<numCourses;i++){
            if (count[i]==0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            Integer cur =queue.poll();
            res[index++]=cur;
            List<Integer> list = lists[cur];
            if(list == null){
                continue;
            }
            for(int val : list){
                count[val]--;
                if(count[val] == 0){
                    queue.add(val);
                }
            }
        }
        return index == numCourses ? res:new int[0];
    }
}
