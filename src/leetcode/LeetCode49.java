package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Description 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * @Date: Created in 下午3:02 2018/5/11
 * @Modified By:
 */
public class LeetCode49 {

    Map<String,List<String>> map=new HashMap<>();

    public List<List<String>> groupAnagrams(String[] strs) {
        for (int i=0;i<strs.length;i++){
            String temp=compare(strs[i]);
            if (map.containsKey(temp)){
                List<String> list=map.get(temp);
                list.add(strs[i]);
                map.put(temp,list);
            }else {
                List<String> list=new ArrayList<String>();
                list.add(strs[i]);
                map.put(temp,list);
            }
        }
        List<List<String>> result=new ArrayList<>();
        for (String s:map.keySet()){
            result.add(map.get(s));
        }
        return result;
    }

    public String compare(String s1){
        char[] cc=s1.toCharArray();
        Arrays.sort(cc);
        return String.valueOf(cc);
    }

    public static void main(String[] args) {
    }
}
