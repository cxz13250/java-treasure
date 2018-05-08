package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * @Date: Created in 下午4:55 2018/5/8
 * @Modified By:
 */
public class LeetCode680 {

    public static boolean validPalindrome(String s) {
        if (s.length()<=1){
            return true;
        }
        return check(s,0,s.length()-1,1);
    }

    public static boolean check(String s,int left,int right,int limit) {
        while (left<right){
            if (s.charAt(left)!=s.charAt(right)) {
                if (limit == 0) {
                    return false;
                } else {
                    limit--;
                    return check(s, left + 1, right, limit) || check(s, left, right - 1, limit);
                }
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("abca"));
    }
}
