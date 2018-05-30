package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个字符串，逐个翻转字符串中的每个单词。
 * @Date: Created in 下午5:02 2018/5/30
 * @Modified By:
 */
public class LeetCode151 {

    public static String reverseWords(String s) {
        if (s==null|| s.length()==0){
            return s;
        }
        StringBuilder sb=new StringBuilder();
        String[] ss=s.split(" ");
        System.out.println(ss.length);
        for (int i=ss.length-1;i>=0;i--){
            if (ss[i].length()>0){
                if (sb.length()>0){
                    sb.append(" ");
                }
                sb.append(ss[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("1 "));
    }
}
