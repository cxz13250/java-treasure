package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Description 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 出发。
 * 说明:
 * 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程
 * @Date: Created in 下午4:46 2018/7/28
 * @Modified By: *
 */
public class LeetCode332 {

    public List<String> findItinerary(String[][] tickets) {

        List<String> result=new ArrayList<>();
        Map<String,List<String>> map=new HashMap<>();
        for (String[] ss:tickets){
            String from=ss[0],to=ss[1];
            List<String> list=map.containsKey(from)?map.get(from):new ArrayList<>();
            list.add(to);
            map.put(from,list);
        }
        for (List<String> l:map.values()){
            Collections.sort(l);
        }
        check(map,"JFK",result,tickets.length+1);
        return result;
    }


    public boolean check(Map<String,List<String>> map,String cur,List<String> result,int targetSize){
        result.add(cur);
        if (result.size()==targetSize){
            return true;
        }
        if (map.get(cur)!=null){
            List<String> list=map.get(cur);
            for (int i=0;i<list.size();i++){
                String to=list.get(i);
                list.remove(to);
                if (check(map,to,result,targetSize)){
                    return true;
                }
                list.add(to);
                Collections.sort(list);
            }
        }
        result.remove(result.size()-1);
        return false;
    }

    public static void main(String[] args) {
        String[][] s={{"JFK","SFO"}};
        LeetCode332 l=new LeetCode332();
        System.out.println(l.findItinerary(s));
    }
}
