package leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午7:57 2023/9/17
 * @Modified By:
 */
public class Leet14_LongestPrefixSubstring {

    public static String longestCommonPrefix(String[] strs) {
        int min = Integer.MAX_VALUE;
        for (String s : strs) {
            min = Math.min(min, s.length());
        }
        int i;
        for (i = 0; i < min; i++) {
            char tmp = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != tmp) {
                    return i > 0 ? strs[0].substring(0, i) : "";
                }
            }
        }

        return i == strs[0].length() ? strs[0]: strs[0].substring(0, i);
    }


    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));
    }

}
