package employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 上午9:49 2018/5/12
 * @Modified By:
 */
public class TouTiao2_1 {

    static int result=0;

    static int flag=0;

    public static int check(List<String> strs){
        for (String s:strs){
            checkStr(s);
        }
        return result;
    }

    public static void checkStr(String s){
        if (flag==1){
            if (s.contains("*/")){
                int i=s.indexOf("//");
                if (i==s.length()-2||s.charAt(i+2)!='\"'){
                    result++;
                    flag=0;
                    return ;
                }else {
                    return;
                }
            }else {
                return;
            }
        }
        if (!s.contains("/*")&&s.contains("//")){
            int i=s.indexOf("//");
            if (i==0||s.charAt(i-1)!='\"') {
                result++;
                return;
            }
        }else if (!s.contains("//")&&s.contains("/*")){
            int i=s.indexOf("/*");
            if (i==0||s.charAt(i-1)!='\"') {
                flag=1;
                if (s.contains("*/")){
                    result++;
                    int j=s.indexOf("*/");
                    if (j==s.length()-2){
                        return;
                    }else {
                        checkStr(s.substring(j+2,s.length()));
                    }
                }else {
                    return;
                }
            }
        }else if (s.contains("/*")&&s.contains("//")){
            int k=s.indexOf("/*");
            int l=s.indexOf("//");
            if (k<l){
                int i=s.indexOf("/*");
                if (i==0||s.charAt(i-1)!='\"') {
                    flag=1;
                    if (s.contains("*/")){
                        result++;
                        int j=s.indexOf("*/");
                        if (j==s.length()-2){
                            return;
                        }else {
                            checkStr(s.substring(j+2,s.length()));
                        }
                    }else {
                        return;
                    }
                }
            }else if (l<k){
                int i=s.indexOf("//");
                if (i==0||s.charAt(i-1)!='\"') {
                    result++;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<String> strs=new ArrayList<>();
        String s=sc.next();
        while (!s.equals("EOF")){
            strs.add(s);
            s=sc.next();
        }
        System.out.println(check(strs));
    }
}
