package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符。
 * '*' 匹配零个或多个前面的元素。
 * 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 * @Date: Created in 下午5:10 2018/4/15
 * @Modified By:
 */
public class LeetCode10 {

    public static boolean isMatch(String s,String p){
        if(p.isEmpty()){
            return s.isEmpty();
        }
        if(p.length()==1){
            return s.length()==1&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.');
        }
        if(p.charAt(1)=='*'){
            while (!s.isEmpty()&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.')){
                if(isMatch(s,p.substring(2))){
                    return true;
                }
                s=s.substring(1);
            }
            return isMatch(s,p.substring(2));
        }else {
            if(s.isEmpty()){
                return false;
            }else if(s.charAt(0)==p.charAt(0) || p.charAt(0)=='.'){
                return isMatch(s.substring(1),p.substring(1));
            }else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        String s="aa";
        String p="a";
        System.out.println(isMatch(s,p));
        String s1="aa";
        String p1="a*";
        System.out.println(isMatch(s1,p1));
        String s2="ab";
        String p2=".*c";
        System.out.println(isMatch(s2,p2));
        String s3="aaa";
        String p3="a*a";
        System.out.println(isMatch(s3,p3));
        String s4="a";
        String p4="ab*a";
        System.out.println(isMatch(s4,p4));
    }
}
