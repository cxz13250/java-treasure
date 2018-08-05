package employee;

import java.util.Scanner;

/**
 * @Author ROKG
 * @Description 数字分两组并加小数点，总共有多少种组合
 * @Date: Created in 下午7:00 2018/8/5
 * @Modified By:
 */
public class PingDuoDuo2 {

    public static int check(String s){
        int res=0;
        for (int i=1;i<s.length();i++){
            res+=addDot(s.substring(0,i))*addDot(s.substring(i,s.length()));
        }
        return res;
    }

    public static int addDot(String s){
        if (s.length()==1){
            return 1;
        }else {
            int res;
            int i=0,j=s.length()-1;
            while (i<s.length()&&s.charAt(i)=='0'){
                i++;
            }
            while (j>=0&&s.charAt(j)=='0'){
                j--;
            }
            if (i>0){
                if (j==s.length()-1) {
                    res = 1;
                }else {
                    res=0;
                }
            }else {
                if (j==s.length()-1){
                    res=s.length();
                }else {
                    res=1;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(check(s));
    }
}
