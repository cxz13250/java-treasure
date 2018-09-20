package leetcode;

/**
 * @Author ROKG
 * @Description 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 * @Date: Created in 下午5:16 2018/9/16
 * @Modified By:
 */
public class LeetCode709 {

    public String toLowerCase(String str) {
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if (c>='A'&&c<='Z'){
                sb.append((char)(c+32));
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
