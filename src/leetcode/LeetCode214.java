package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个字符串 s, 你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 * @Date: Created in 下午12:25 2018/5/28
 * @Modified By: *
 */
public class LeetCode214 {

    //从左遍历找回文串
    public static String shortestPalindrome(String s) {
        if (s==null||s.equals("")||check(s)){
            return s;
        }
        String result=new String();
        for (int i=2;i<s.length();i++){
            String temp=s.substring(0,i);
            if (check(temp)){
                StringBuilder sb=new StringBuilder(s.substring(i));
                sb.reverse();
                sb.append(s);
                if (result.length()==0||result.length()>sb.length()){
                    result=sb.toString();
                }
            }
        }
        if (result.length()==0){
            StringBuilder sb=new StringBuilder(s.substring(1));
            sb.reverse();
            sb.append(s);
            result=sb.toString();
        }
        return result;
    }

    public static boolean check(String s){
        StringBuilder sb=new StringBuilder(s);
        return sb.reverse().toString().equals(s);
    }

    //模式匹配:求s的最长前缀回文子串就是求s+"#"+s的最长前缀后缀相等子串
    public static String shortestPalindrome2(String s) {
        String tmp=s+"#"+new StringBuilder(s).reverse().toString();
        int[] next=next(tmp);
        return new StringBuilder(s.substring(next[next.length-1]+1)).reverse().toString()+s;
    }

    public static int[] next(String s){
        int[] next=new int[s.length()];
        int i=0;
        int k=-1;
        next[i]=k;
        while (i<s.length()-1){
            if (k==-1 || s.charAt(i)==s.charAt(k)){
                k++;
                i++;
                next[i]=k;
            }else{
                k=next[k];
            }
        }
        return next;
    }


    public static void main(String[] args) {
        String s="aacecaaa";
        String s1="abcd";
        System.out.println(shortestPalindrome2(s));
        System.out.println(shortestPalindrome2(s1));
    }
}
