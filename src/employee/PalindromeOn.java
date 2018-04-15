package employee;

/**
 * @Author ROKG
 * @Description 求最长回文字符串长度 时间复杂度O(n) Manacher算法
 * @Date: Created in 下午7:00 2018/4/3
 * @Modified By:
 */
public class PalindromeOn {
    private int[] p;
    private String s;
    private char[] t;
    public String longestPalindrome(String str) {
        s = str;
        preprocess();
        p = new int[t.length];
        int mid = 0, right = 0;
        for (int i = 1; i < t.length-1; i++) {
            int mirror = 2*mid - i;
            if (right > i)
                p[i] = Math.min(right - i, p[mirror]);
            while (t[i + (1 + p[i])] == t[i - (1 + p[i])])
                p[i]++;
            if (i + p[i] > right) {
                mid = i;
                right = i + p[i];
            }
        }
        int length = 0;
        int center = 0;
        for (int i = 1; i < p.length-1; i++) {
            if (p[i] > length) {
                length = p[i];
                center = i;
            }
        }
        return s.substring((center - 1 - length) / 2, (center - 1 + length) / 2);
    }
    private void preprocess() {
        t = new char[s.length()*2 + 3];
        t[0] = '$';
        t[s.length()*2 + 2] = '@';
        for (int i = 0; i < s.length(); i++) {
            t[2*i + 1] = '#';
            t[2*i + 2] = s.charAt(i);
        }
        t[s.length()*2 + 1] = '#';
    }

    public static void main(String[] args) {
        PalindromeOn m=new PalindromeOn();
        String s="abbabbac";
        System.out.println(m.longestPalindrome(s).length());
    }
}
