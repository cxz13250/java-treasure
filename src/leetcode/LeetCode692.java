package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Description 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * @Date: Created in 下午11:36 2018/7/9
 * @Modified By:
 */
public class LeetCode692 {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map=new HashMap<>();
        for (String s:words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> queue=new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue()>o2.getValue()){
                    return -1;
                }else if (o1.getValue()<o2.getValue()){
                    return 1;
                }else {
                    return o2.getKey().compareTo(o1.getKey());
                }
            }
        });
        for (Map.Entry<String,Integer> entry:map.entrySet()){
            queue.offer(entry);
        }
        List<String> result=new ArrayList<>();
        while (k>0){
            result.add(queue.poll().getKey());
            k--;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("i".compareTo("love"));
    }
}
