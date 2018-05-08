package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 给定两个字符串 s 和 t，判断它们是否是同构的。如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * @Date: Created in 下午3:13 2018/5/8
 * @Modified By:
 */
public class LeetCode205 {

    public static boolean isIsomorphic(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        Map<Character,Character> map=new HashMap<>();
        Map<Character,Character> compare=new HashMap<>();
        for (int i=0;i<s.length();i++){
            char a=s.charAt(i);
            char b=t.charAt(i);
            if(map.containsKey(a)){
                char temp=map.get(a);
                if (temp!=b){
                    return false;
                }
            }else {
                if (compare.containsKey(b)){
                    return false;
                }
                map.put(a,b);
                compare.put(b,a);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("aa","ab"));
    }
}
