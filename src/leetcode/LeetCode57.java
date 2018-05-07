package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * @Date: Created in 下午7:29 2018/5/6
 * @Modified By:
 */
public class LeetCode57 {

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result=new ArrayList<>();
        if(intervals.size()==0){
            result.add(newInterval);
            return result;
        }
        Interval interval=new Interval(newInterval.start,newInterval.end);
        int index=-1;
        for (int i=0;i<intervals.size();i++){
            Interval temp=intervals.get(i);
            if(temp.end<interval.start){
                result.add(temp);
            }else if(temp.start>interval.end){
                index=i;
                break;
            }else {
                interval.start=Math.min(interval.start,temp.start);
                interval.end=Math.max(interval.end,temp.end);
            }
        }
        result.add(interval);
        if (index!=-1){
            for (int i=index;i<intervals.size();i++){
                result.add(intervals.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Interval> intervals=new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(6,9));
        System.out.println(insert(intervals,new Interval(2,5)));
    }
}
