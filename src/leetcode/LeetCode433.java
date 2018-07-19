package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Description 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
 * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
 * 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
 * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
 * 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。
 * 如果无法实现目标变化，请返回 -1。
 * @Date: Created in 下午11:33 2018/7/15
 * @Modified By: *
 */
public class LeetCode433 {

    public int minMutation(String start, String end, String[] bank) {
        Set<String> set=new HashSet<>();
        Queue<String> queue=new LinkedList<>();
        Map<String,Integer> map=new HashMap<>();
        char[] cc={'A','C','G','T'};
        for (String s:bank){
            set.add(s);
        }
        map.put(start,0);
        queue.offer(start);
        while (!queue.isEmpty()){
            String s=queue.poll();
            for (int i=0;i<s.length();i++){
                char[] temp=s.toCharArray();
                for (char c:cc){
                    temp[i]=c;
                    String newString=new String(temp);
                    if (set.contains(newString)){
                        map.put(newString,map.get(s)+1);
                        if (newString.equals(end)){
                            return map.get(newString);
                        }
                        queue.add(newString);
                    }
                }
            }
        }
        return -1;
    }
}
