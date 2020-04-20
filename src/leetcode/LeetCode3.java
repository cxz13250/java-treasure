package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个字符串，找出不含有重复字符的最长子串的长度。O(n)时间复杂度，空间复杂度O(1)。
 * @Date: Created in 下午9:36 2018/4/10
 * @Modified By:
 */
public class LeetCode3 {

    public static int lengthOfLongestSubstring(String s) {
        if(s == null){
            return 0;
        }
        if(s.length() <= 1){
            return s.length();
        }
        int max = 0;
        int start = 0;
        int[] flag=new int[128];
        for(int i=0; i<128;i++){
            flag[i] = -1;
        }
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(flag[c] > -1){
                start = Math.max(start, flag[c] + 1);
            }
            flag[c] = i;
            max = Math.max(max,i - start + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String s1="c";
        String s2="abcabcbb";
        System.out.println(lengthOfLongestSubstring(s1));
        System.out.println(lengthOfLongestSubstring(s2));
    }
}
