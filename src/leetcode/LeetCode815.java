package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Description 我们有一系列公交路线。每一条路线 routes[i] 上都有一辆公交车在上面循环行驶。例如，有一条路线 routes[0] = [1, 5, 7]，
 * 表示第一辆 (下标为0) 公交车会一直按照 1->5->7->1->5->7->1->... 的车站路线行驶。假设我们从 S 车站开始（初始时不在公交车上），要去往 T 站。
 * 期间仅可乘坐公交车，求出最少乘坐的公交车数量。
 * @Date: Created in 下午11:50 2018/4/19
 * @Modified By:
 */
public class LeetCode815 {

    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) return 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; ++i) {
            for (int j : routes[i]) {
                if (!map.containsKey(j)) map.put(j, new HashSet<>());
                map.get(j).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (int next : map.get(S)) {
            visited.add(next);
            queue.add(next);
        }
        int res = 1;
        while (!queue.isEmpty()) {
            Queue<Integer> tmp = new LinkedList<>();
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int c : routes[cur]) {
                    if (c == T) return res;
                    for (int next : map.get(c)) {
                        if (!visited.contains(next)) {
                            tmp.add(next);
                            visited.add(next);
                        }
                    }
                }
            }
            ++res;
            queue = tmp;
        }
        return -1;
    }
}
