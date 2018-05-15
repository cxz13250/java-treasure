package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循这种模式。这里的 遵循 指完全匹配，
 * 例如在pattern里的每个字母和字符串 str 中的每个非空单词存在双向单映射关系。
 * @Date: Created in 下午1:14 2018/5/11
 * @Modified By:
 */
public class LeetCode290 {

    public boolean wordPattern(String pattern, String str) {
        Map<Character,String> map=new HashMap<>();
        char[] cc=pattern.toCharArray();
        String[] strings=str.split(" ");
        if (cc.length!=strings.length){
            return false;
        }
        for (int i=0;i<cc.length;i++){
            char temp=cc[i];
            String string=strings[i];
            if (map.containsKey(temp)){
                if (!map.get(temp).equals(string)){
                    return false;
                }
            }else {
                if (map.values().contains(string)){
                    return false;
                }else {
                    map.put(temp,string);
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        String s="dog cat cat dog";
        String[] strings=s.split(" ");
        System.out.println(strings.length);
    }
}
