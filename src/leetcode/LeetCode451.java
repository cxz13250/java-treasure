package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author ROKG
 * @Description 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * @Date: Created in 2018/7/27
 * @Modified By:
 */
public class LeetCode451 {

    public String frequencySort(String s) {
        if (s==null || s.length()==0){
            return s;
        }
        Map<Character, Integer> map=new HashMap<>();
        for (char c:s.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> queue=new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        });
        for (Map.Entry<Character,Integer> entry:map.entrySet()){
            queue.offer(entry);
        }
        StringBuilder sb=new StringBuilder();
        while (!queue.isEmpty()){
            Map.Entry<Character, Integer> entry=queue.poll();
            int temp=entry.getValue();
            while (temp>0){
                sb.append(entry.getKey());
                temp--;
            }
        }
        return sb.toString();
    }
}
