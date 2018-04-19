package employee;

import java.util.Scanner;

/**
 * @Author ROKG
 * @Description 字典序最大子序列
 * @Date: Created in 下午7:16 2018/4/19
 * @Modified By:
 */
public class Aqy1 {

    public static String check(String str){
        String result="";
        for(int i=0;i<str.length();i++){
            String temp=str.substring(str.length()-i-1,str.length()-i)+result;
            if(temp.compareTo(result)>0){
                result=temp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        System.out.println(check(str));
    }
}
