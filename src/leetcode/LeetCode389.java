package leetcode;

/**
 * @Author ROKG
 * @Description 给定两个字符串 s 和 t，它们只包含小写字母。字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。请找出在 t 中被添加的字母。
 * @Date: Created in 下午11:47 2018/4/25
 * @Modified By:
 */
public class LeetCode389 {

    public char findTheDifference(String s, String t) {
        int[] n1=new int[26];
        int[] n2=new int[26];
        char[] c1=s.toCharArray();
        char[] c2=t.toCharArray();
        for(int i=0;i<c1.length;i++){
            n1[c1[i]-'a']++;
        }
        for(int i=0;i<c2.length;i++){
            n2[c2[i]-'a']++;
        }
        char result=0;
        for(int i=0;i<26;i++){
            if(n1[i]!=n2[i]){
                int temp=i+'a';
                result= (char)temp;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
