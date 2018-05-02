package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * @Date: Created in 下午12:58 2018/5/2
 * @Modified By:
 */
public class LeetCode557 {

    public String reverseWords(String s) {
        String[] strings=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<strings.length-1;i++){
            sb.append(reverseWord(strings[i])+" ");
        }
        sb.append(reverseWord(strings[strings.length-1]));
        return sb.toString();
    }

    public String reverseWord(String s){
        char[] cc=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        for(int i=cc.length-1;i>=0;i--){
            sb.append(cc[i]);
        }
        return sb.toString();
    }
}
