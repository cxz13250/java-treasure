package leetcode;

/**
 * @Author ROKG
 * @Description 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 * @Date: Created in 2018/8/2
 * @Modified By: *
 */
public class LeetCode395 {

    public int longestSubstring(String s, int k) {
        int[] count=new int[26];
        if (s==null||s.length()<k){
            return 0;
        }
        for (char c:s.toCharArray()){
            count[c-'a']++;
        }
        for (int i=0;i<s.length();i++){
            if(count[s.charAt(i)-'a']<k){
                return Math.max(longestSubstring(s.substring(0,i),k),longestSubstring(s.substring(i+1,s.length()),k));
            }
        }
        return s.length();
    }
}
