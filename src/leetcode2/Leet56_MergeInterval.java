package leetcode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午12:18 2023/9/9
 * @Modified By:
 */
public class Leet56_MergeInterval {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[][]{};
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] pre = res.get(res.size()-1);
            int[] cur = intervals[i];
            if (pre[1] < cur[0]) {
                // 无法合并，直接添加
                res.add(cur);
            } else {
                // 合并区间，右区间取最大值
                pre[1] = Math.max(pre[1], cur[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
