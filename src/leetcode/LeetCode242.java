package leetcode;

import java.util.Arrays;

/**
 * @Author ROKG
 * @Description 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 * @Date: Created in 下午2:45 2018/5/15
 * @Modified By:
 */
public class LeetCode242 {

    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        char[] cc1=s.toCharArray();
        char[] cc2=t.toCharArray();
        Arrays.sort(cc1);
        Arrays.sort(cc2);
        for (int i=0;i<s.length();i++){
            if (cc1[i]!=cc2[i]){
                return false;
            }
        }
        return true;
    }
}
