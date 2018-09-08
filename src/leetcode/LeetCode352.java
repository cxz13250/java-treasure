package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个非负整数的数据流输入 a1，a2，…，an，…，将到目前为止看到的数字总结为不相交的间隔列表。
 * @Date: Created in 下午10:57 2018/9/8
 * @Modified By: *
 */
public class LeetCode352 {

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    List<Interval> intervals;

    /** Initialize your data structure here. */
    public LeetCode352() {
        intervals = new ArrayList<>();
    }

    public void addNum(int val) {
        if (intervals.size()==0){
            intervals.add(new Interval(val,val));
        }else if (intervals.size()==1){
            Interval interval=intervals.get(0);
            if (val<=interval.end&&val>=interval.start){
                return;
            }else if (val<interval.start){
                if (val==interval.start-1){
                    interval.start=val;
                }else {
                    intervals.add(0,new Interval(val,val));
                }
            }else {
                if (val==interval.end+1){
                    interval.end=val;
                }else {
                    intervals.add(new Interval(val,val));
                }
            }
        }else {
            int index=findIndex(val);
            if (index==-1){
                if (val==intervals.get(0).start-1){
                    intervals.get(0).start=val;
                }else {
                    intervals.add(0,new Interval(val,val));
                }
            }else if (index==intervals.size()-1){
                if (val<=intervals.get(index).end){
                    return;
                }else if (val==intervals.get(index).end+1){
                    intervals.get(index).end=val;
                }else {
                    intervals.add(new Interval(val,val));
                }
            }else {
                if (val<=intervals.get(index).end){
                    return;
                }else if (val==intervals.get(index+1).start-1&&val==intervals.get(index).end+1){
                    Interval i1=intervals.remove(index);
                    Interval i2=intervals.remove(index);
                    intervals.add(index,new Interval(i1.start,i2.end));
                }else if (val==intervals.get(index+1).start-1){
                    intervals.get(index+1).start=val;
                }else if (val==intervals.get(index).end+1){
                    intervals.get(index).end=val;
                }else {
                    intervals.add(index,new Interval(val,val));
                }
            }
        }
    }

    // 寻找数组中start比val小的最大值对应的下标
    // -1表示val比数组中所有元素的start还小
    // size-1表示val比数组中所有元素的start还大
    public int findIndex(int val){
        int start=0;
        int end=intervals.size()-1;
        if (intervals.get(start).start>val){
            return -1;
        }
        if (intervals.get(end).start<val){
            return intervals.size()-1;
        }
        while (start<end){
            int mid=(start+end)/2;
            if (intervals.get(mid).start>val){
                end=mid-1;
            }else if (intervals.get(mid).start<val){
                if (intervals.get(mid+1).start>val){
                    return mid;
                }else {
                    start=mid+1;
                }
            }else {
                return mid;
            }
        }
        return start;
    }

    public List<Interval> getIntervals() {
        return intervals;
    }

    public static void main(String[] args) {
    }
}
