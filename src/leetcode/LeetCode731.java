package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内不会导致三重预订时，则可以存储这个新的日程安排。
 * MyCalendar 有一个 book(int start, int end)方法。它意味着在start到end时间内增加一个日程安排，注意，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end。
 * 当三个日程安排有一些时间上的交叉时（例如三个日程安排都在同一时间内），就会产生三重预订。
 * 每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致三重预订，返回 true。否则，返回 false 并且不要将该日程安排添加到日历中。
 * 请按照以下步骤调用MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 * @Date: Created in 2018/9/20
 * @Modified By:
 */
public class LeetCode731 {

    List<int[]> single=new ArrayList<>();

    List<int[]> doubles=new ArrayList<>();

    public LeetCode731() {

    }

    public boolean book(int start, int end) {
        for (int[] tmp:doubles){
            if (tmp[1]>start&&tmp[0]<start){
                return false;
            }
        }
        for (int[] tmp:single){
            if (tmp[1]>start&&tmp[0]<start){
                doubles.add(new int[]{Math.max(start, tmp[0]),Math.min(end, tmp[1])});
            }
        }
        single.add(new int[]{start,end});
        return true;
    }
}
