package employee;

/**
 * @Author ROKG
 * @Description 求最长回文字符串长度 时间复杂度O(n2)
 * @Date: Created in 下午7:14 2018/4/3
 * @Modified By:
 */
public class PalindromeOn2 {
    private int max = 0;
    private String res = "";
    public String longestPalindrome(String s) {

        if (s.length() == 1) { return s; }
        for (int i = 0; i < s.length()-1; i++) {
            checkPalindromeExpand(s,i,i);
            checkPalindromeExpand(s,i,i+1);
        }
        return res;
    }
    public void checkPalindromeExpand(String s, int low, int high) {
        while (low >= 0 && high < s.length()) {
            if (s.charAt(low) == s.charAt(high)) {
                if (high - low + 1 > max) {
                    max = high - low + 1;
                    res = s.substring(low,high+1);
                }
                low--; high++;
            }else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        String a="abbacdas";
        PalindromeOn2 s=new PalindromeOn2();
        System.out.println(s.longestPalindrome(a).length());
    }
}
