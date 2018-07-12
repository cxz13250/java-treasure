package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ROKG
 * @Description 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * @Date: Created in 下午4:26 2018/7/7
 * @Modified By:
 */
public class LeetCode347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        Collection<Map.Entry<Integer,Integer>> collection=map.entrySet();
        List<Map.Entry<Integer,Integer>> list=collection.stream().sorted(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        }).collect(Collectors.toList());
        List<Integer> result=new ArrayList<>();
        for (int i=0;i<k;i++){
            result.add(list.get(i).getKey());
        }
        return result;
    }

    public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> queue=new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        for (Map.Entry entry:map.entrySet()){
            queue.offer(entry);
        }
        List<Integer> result=new ArrayList<>();
        for (int i=0;i<k;i++){
            Map.Entry<Integer,Integer> entry=queue.poll();
            result.add(entry.getKey());
        }
        return result;
    }
}
