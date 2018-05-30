package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * @Date: Created in 下午12:55 2018/5/23
 * @Modified By:
 */
public class LeetCode125 {

    public boolean isPalindrome(String s) {
        if (s.equals("")){
            return true;
        }
        int i=0,j=s.length()-1;
        while (i<j){
            while (i<j&&!needCheck(s.charAt(i))){
                i++;
            }
            while (i<j&&!needCheck(s.charAt(j))){
                j--;
            }
            if (i<j&&Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean needCheck(char c){
        if ((c>='A'&&c<='Z')||(c>='0'&&c<='9')||(c>='a'&&c<='z')){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode125 l=new LeetCode125();
        System.out.println(l.isPalindrome("`l;`` 1o1 ??;l`"));
    }
}
