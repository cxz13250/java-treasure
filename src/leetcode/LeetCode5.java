package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 长度最长为1000。
 * @Date: Created in 下午10:14 2018/4/10
 * @Modified By:
 */
public class LeetCode5 {

    private int max = 0;
    private String res = "";

    public String longestPalindrome(String s) {
        for(int i=0;i<s.length();i++){
            checkPalindromeExpand(s,i,i);
            checkPalindromeExpand(s,i,i+1);
        }
        return res;
    }

    public void checkPalindromeExpand(String s,int low,int high){
        while (low>=0&&high<s.length()){
            if(s.charAt(low)==s.charAt(high)){
                if(high-low+1>max){
                    max=high-low+1;
                    res=s.substring(low,high+1);
                }
                low--;high++;
            }else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        String s="babad";
        LeetCode5 l=new LeetCode5();
        System.out.println(l.longestPalindrome(s));
    }
}
