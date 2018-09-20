package leetcode;

import java.util.TreeMap;

/**
 * @Author ROKG
 * @Description 实现一个 MyCalendar 类来存放你的日程安排，你可以一直添加新的日程安排。
 * MyCalendar 有一个 book(int start, int end)方法。它意味着在start到end时间内增加一个日程安排，注意，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end。
 * 当 K 个日程安排有一些时间上的交叉时（例如K个日程安排都在同一时间内），就会产生 K 次预订。
 * 每次调用 MyCalendar.book方法时，返回一个整数 K ，表示最大的 K 次预订。
 * 请按照以下步骤调用MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 * @Date: Created in 2018/9/20
 * @Modified By: *
 */
public class LeetCode732 {

    private TreeMap<Integer, Integer> timeline = new TreeMap<>();

    public LeetCode732() {

    }

    public int book(int start, int end) {
        timeline.put(start, timeline.getOrDefault(start, 0) + 1); // 1 new event will be starting at [s]
        timeline.put(end, timeline.getOrDefault(end, 0) - 1); // 1 new event will be ending at [e];
        int ongoing = 0, k = 0;
        for (int v : timeline.values()) {
            k = Math.max(k, ongoing += v);
        }
        return k;
    }
}
