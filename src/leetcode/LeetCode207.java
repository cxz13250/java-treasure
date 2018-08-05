package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author ROKG
 * @Description 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 * @Date: Created in 下午10:00 2018/8/1
 * @Modified By: *
 */
public class LeetCode207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] arrayLists=new ArrayList[numCourses];
        for (int i=0;i<arrayLists.length;i++) {
            arrayLists[i]=new ArrayList<>();
        }
        for (int i=0;i<prerequisites.length;i++){
            arrayLists[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        int[] visited = new int[numCourses];
        for (int i=0;i<numCourses;i++){
            if (visited[i]==0){
                if (!check(i,arrayLists,visited)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean check(int cur, ArrayList<Integer>[] adjacency,int[] visited){
        visited[cur]=-1;
        for (int i:adjacency[cur]){
            if (visited[i]==-1){
                return false;
            }else if (visited[i]==0){
                if (!check(i,adjacency,visited)){
                    return false;
                }
            }
        }
        visited[cur]=1;
        return true;
    }

    public static void main(String[] args) {
        LeetCode207 l=new LeetCode207();
        System.out.println(l.canFinish(2,new int[][]{{1,0}}));
    }
}
