package employee;

import java.util.Scanner;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 上午9:49 2018/5/12
 * @Modified By:
 */
public class TouTiao2_4 {

    public static int check(String s1,String s2){
        for (int i=0;i<s1.length();i++){
            if (s2.indexOf(s1.charAt(i))==-1){
                return 0;
            }
        }
        int result=100;
        for (int i=0;i<s1.length()-1;i++){
            char c1=s1.charAt(i);
            char c2=s1.charAt(i+1);
            int index1=s2.indexOf(c1);
            int index2=s2.indexOf(c2);
            if (index1<index2){
                result-=(index2-index1-1);
            }else if (index1>index2){
                while (index2<s2.length()&&index2<index1) {
                    index2 = s2.indexOf(c2, index2+1);
                }
                if (index2>index1){
                    result-=(index2-index1-1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        System.out.println(check(s1,s2));
    }
}
