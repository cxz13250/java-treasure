package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午10:14 2018/7/12
 * @Modified By:
 */
public class LeetCode436 {

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public int[] findRightInterval(Interval[] intervals) {
        int[] result=new int[intervals.length];
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for (int i=0;i<intervals.length;i++){
            map.put(intervals[i].start,i);
        }
        for (int i=0;i<intervals.length;i++){
            Map.Entry<Integer,Integer> m=map.ceilingEntry(intervals[i].end);
            result[i]=(m==null)?-1:m.getValue();
        }
        return result;
    }


}
