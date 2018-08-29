package employee;

import java.util.Scanner;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 上午10:05 2018/8/25
 * @Modified By:
 */
public class TouTiao3_1 {

    public static boolean check(String[] ss){
        for (int i=0;i<ss.length-1;i++){
            for (int j=i+1;j<ss.length;j++){
                if (isSame(ss[0],ss[1])){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isSame(String s1,String s2){
        if (s1.length()!=s2.length()){
            return false;
        }
        char c=s1.charAt(0);
        for (int i=0;i<s2.length();i++){
            if (s2.charAt(i)==c){
                StringBuilder sb1=new StringBuilder(s2.substring(i)+s2.substring(0,i));
                StringBuilder sb2=new StringBuilder(s2.substring(i+1)+s2.substring(0,i+1));
                if (sb1.toString().equals(s1) || sb2.reverse().toString().equals(s1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        String[][] strings=new String[m][];
        for (int i=0;i<m;i++){
            int n=sc.nextInt();
            strings[i]=new String[n];
            for (int j=0;j<n;j++){
                strings[i][j]=sc.next();
            }
        }
        boolean[] res=new boolean[m];
        for (int i=0;i<m;i++){
            res[i]=check(strings[i]);
        }
        for (int i=0;i<m;i++){
            System.out.println(check(strings[i])?"Yeah":"Sad");
        }
    }
}
