package leetcode2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午3:55 2023/11/5
 * @Modified By:
 */
public class Leet207_Courses {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        // 0 表示尚未遍历，1表示本次遍历中，-1表示已经以此为起点遍历完成，不存在环
        int[] path = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (path[i] == 0) {
                if (!dfs(graph, path, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(ArrayList<Integer>[] graph, int[] path, int current) {
        // 当前节点进入路径
        path[current] = 1;
        for (int i : graph[current]) {
            // 出现环
            if (path[i] == 1) {
                return false;
            } else if (path[i] == 0) {
                if (!dfs(graph, path, i)) {
                    return false;
                }
            }
        }
        path[current] = -1;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Leet207_Courses().canFinish(2, new int[][]{{1, 0}}));
        System.out.println(new Leet207_Courses().canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }
}
