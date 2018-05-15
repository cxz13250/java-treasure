package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 * @Date: Created in 下午12:54 2018/5/11
 * @Modified By:
 */
public class LeetCode541 {

    public static String reverseStr(String s, int k) {
        int i=0;
        StringBuilder sb=new StringBuilder();
        while (i<s.length()){
            int j=i+k-1<s.length()?i+k-1:s.length()-1;
            for (;j>=i;j--) {
                sb.append(s.charAt(j));
            }
            int temp=i+2*k-1;
            i+=k;
            while (i<=temp&&i<s.length()){
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg",3));
    }
}
