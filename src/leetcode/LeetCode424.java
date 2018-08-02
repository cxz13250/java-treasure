package leetcode;

/**
 * @Author ROKG
 * @Description 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 * @Date: Created in 2018/8/2
 * @Modified By: *
 */
public class LeetCode424 {

    //滑动窗口
    public static int characterReplacement(String s, int k) {
        if (s==null||s.length()==0){
            return 0;
        }
        int start=0;
        int end=0;
        int result=0;
        int[] count=new int[26];
        count[s.charAt(0)-'A']++;
        while (end<s.length()){
            int max=0;
            for (int i=0;i<26;i++){
                max=Math.max(max,count[i]);
            }
            if (max+k>end-start){
                end++;
                if (end<s.length()){
                    count[s.charAt(end)-'A']++;
                }
            }else {
                count[s.charAt(start)-'A']--;
                start++;
            }
            if (max+k>result){
                result=max+k>s.length()?s.length():max+k;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA"
                ,1));
    }
}
