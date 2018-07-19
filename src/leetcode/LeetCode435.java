package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author ROKG
 * @Description 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 注意:
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * @Date: Created in 下午11:01 2018/7/11
 * @Modified By: *
 */
public class LeetCode435 {

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end-o2.end;
            }
        });
        int count=1;
        int last=0;
        for (int i=1;i<intervals.length;i++){
            if (intervals[last].end<=intervals[i].start){
                count++;
                last=i;
            }
        }
        return intervals.length-count;
    }
}
