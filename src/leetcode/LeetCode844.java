package leetcode;

/**
 * @Author ROKG
 * @Description 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * @Date: Created in 2018/7/19
 * @Modified By:
 */
public class LeetCode844 {

    public boolean backspaceCompare(String S, String T) {
        String s1=change(S);
        String s2=change(T);
        return s1.equals(s2);
    }

    public String change(String s){
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)!='#'){
                sb.append(s.charAt(i));
            }else {
                if (sb.length()>0){
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode844 l=new LeetCode844();
        System.out.println(l.backspaceCompare("a#c","b"));
    }
}
