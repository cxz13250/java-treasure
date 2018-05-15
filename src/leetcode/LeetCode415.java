package leetcode;

/**
 * @Author ROKG
 * @Description 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * @Date: Created in 下午2:42 2018/5/10
 * @Modified By:
 */
public class LeetCode415 {

    public static String addStrings(String num1, String num2) {
        int len1=num1.length();
        int len2=num2.length();
        String longer;
        String shorter;
        if (len1>len2){
            longer=num1;
            shorter=num2;
        }else {
            longer=num2;
            shorter=num1;
        }
        StringBuilder sb=new StringBuilder();
        int flag=0;
        for (int i=0;i<longer.length();i++){
            if (i<shorter.length()) {
                int temp1 = longer.charAt(longer.length() - i - 1) - '0';
                int temp2 = shorter.charAt(shorter.length() - i - 1) - '0';
                sb.append((temp1 + temp2 + flag) % 10);
                if ((temp1 + temp2 + flag) >= 10) {
                    flag = 1;
                }else {
                    flag = 0;
                }
            }else {
                int temp1 = longer.charAt(len1 - i - 1) - '0';
                sb.append((temp1 + flag) % 10);
                if ((temp1 + flag) >= 10) {
                    flag = 1;
                }else {
                    flag = 0;
                }
            }
        }
        if(flag==1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Student s=new Student();
        System.out.println(s.getClass());
        System.out.println(s.getClass().getTypeName());
    }

    private static class Student{

    }
}
