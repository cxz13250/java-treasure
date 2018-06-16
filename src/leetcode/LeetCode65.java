package leetcode;

/**
 * @Author ROKG
 * @Description 验证给定的字符串是否为数字。例如:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * @Date: Created in 下午4:25 2018/6/6
 * @Modified By:
 */
public class LeetCode65 {

    public static boolean isNumber(String s) {
        int i=0;
        while (i<s.length()&&s.charAt(i)==' '){
            i++;
        }
        if (i<s.length()&&(s.charAt(i)=='+'||s.charAt(i)=='-')){
            i++;
        }
        boolean hasDot=false;
        boolean isNumber=false;
        boolean hasE=false;
        for (;i<s.length();i++){
            if (s.charAt(i)=='.'&&!hasDot){
                hasDot=true;
            }else if (s.charAt(i)>='0'&&s.charAt(i)<='9'){
                isNumber=true;
            }else if (s.charAt(i)=='e'&&isNumber&&!hasE){
                hasDot=hasE=true;
                if (i+1<s.length()&&(s.charAt(i+1)=='+'||s.charAt(i+1)=='-')){
                    i++;
                }
                if (i+1>=s.length()||!(s.charAt(i+1)>='0'&&s.charAt(i+1)<='9')){
                    return false;
                }
            }else {
                break;
            }
        }
        while (i<s.length()&&s.charAt(i)==' '){
            i++;
        }
        return isNumber&&i==s.length();
    }

    public static boolean isNumber(char c){
        if (c>='0'&&c<='9'){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isNumber("2e0"));
    }
}
