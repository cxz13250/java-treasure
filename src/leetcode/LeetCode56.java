package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ROKG
 * @Description 给出一个区间的集合，请合并所有重叠的区间。
 * @Date: Created in 下午7:22 2018/6/5
 * @Modified By:
 */
public class LeetCode56 {

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result=new ArrayList<>();
        if (intervals.size()==0){
            return result;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        Interval temp=intervals.get(0);
        for (Interval interval:intervals){
            if (interval.start<=temp.end){
                temp.end=Math.max(interval.end,temp.end);
            }else {
                result.add(temp);
                temp=interval;
            }
        }
        result.add(temp);
        return result;

    }
}
