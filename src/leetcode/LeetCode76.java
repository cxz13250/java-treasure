package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
 * @Date: Created in 下午1:57 2018/5/8
 * @Modified By: *
 */
public class LeetCode76 {

    public static String minWindow(String s, String t) {
        Map<Character,Integer> map=new HashMap<>();
        for (char c:t.toCharArray()){
            map.put(c,map.containsKey(c)?map.get(c)+1:1);
        }
        int count=t.length();
        int min=Integer.MAX_VALUE;
        int start=0,end=s.length();
        int left=0;
        for (int right=0;right<s.length();right++){
            char temp=s.charAt(right);
            if (map.containsKey(temp)){
                map.put(temp,map.get(temp)-1);
                if(map.get(temp)>=0){
                    count--;
                }
            }
            while (count==0){
                if (right-left<min){
                    min=right-left;
                    start=left;
                    end=right;
                }
                char val=s.charAt(left);
                if (map.containsKey(val)){
                    map.put(val,map.get(val)+1);
                    if (map.get(val)>0){
                        count++;
                    }
                }
                left++;
            }
        }
        return min==Integer.MAX_VALUE?"":s.substring(start,end);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
}
