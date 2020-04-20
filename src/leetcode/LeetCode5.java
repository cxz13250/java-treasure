package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 长度最长为1000。
 * @Date: Created in 下午10:14 2018/4/10
 * @Modified By:
 */
public class LeetCode5 {

    int[] flag=new int[2];
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] str = s.toCharArray();
        for(int i=0;i<s.length();i++){
            i = checklongestPalindrome(str, i);
        }
        return s.substring(flag[0],flag[1]+1);
    }

    public int checklongestPalindrome(char[] cc, int low) {
        int high = low;
        while(high<cc.length-1 && cc[high+1] == cc[low]){
            high++;
        }
        int next=high;
        while(low>0&&high<cc.length-1&&cc[low-1]==cc[high+1]){
            low--;
            high++;
        }
        if(high-low>flag[1]-flag[0]){
            flag[0]=low;
            flag[1]=high;
        }
        return next;
    }

    public static void main(String[] args) {
        String s="babad";
        LeetCode5 l=new LeetCode5();
        System.out.println(l.longestPalindrome(s));
    }
}
