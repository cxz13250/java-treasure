package leetcode2;

import java.util.Arrays;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 上午11:18 2023/7/29
 * @Modified By:
 */
public class Leet3_LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            res = Math.max(res, findLength(i, chars));
        }
        return res;
    }

    public static int findLength(int location, char[] chars) {
        int[] flag = new int[200];
        int res = 0;
        int i;
        for (i = location; i < chars.length; i++) {
            int index = chars[i];
            if (flag[index] == 0) {
                flag[index] = 1;
            } else {
                res = i - location;
                break;
            }
        }
        if (i >= chars.length) {
            res = chars.length - location;
        }
        return res;
    }

    public static int lengthOfLongestSubstring2(String s) {
        // 记录某个元素上次出现的位置
        int[] flag = new int[128];
        if (s.length() <= 1) {
            return s.length();
        }
        Arrays.fill(flag, -1);
        int start = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            // 非重复元素
            if (flag[c] == -1){
                res = Math.max(res, i - start + 1);
            } else {
                // 重复元素，这里有两种情况
                // 1）上次出现的位置在本次起点之前，不需要调整起点
                // 2）上次出现的位置在本次起点之后或者就是本次起点，需要调整起点
                start = Math.max(start, flag[c] + 1);
                res = Math.max(res, i - start + 1);
            }
            flag[c] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(lengthOfLongestSubstring2("aa"));
        System.out.println(lengthOfLongestSubstring2("au"));
        System.out.println(lengthOfLongestSubstring2(" "));
        System.out.println(lengthOfLongestSubstring2("tmmzuxt"));
    }
}
