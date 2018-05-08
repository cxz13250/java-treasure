package employee;

import java.util.Scanner;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午7:42 2018/5/7
 * @Modified By:
 */
public class XYK1 {

    public static boolean check(String s1,String s2){
        char[] cc1=s1.toCharArray();
        char[] cc2=s2.toCharArray();
        int[] num=new int[128];
        for (char c:cc1){
            num[c]=1;
        }
        for (char c:cc2){
            if(num[c]==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        String[] strings=str.split(";");
        System.out.println(check(strings[0],strings[1]));
    }
}
