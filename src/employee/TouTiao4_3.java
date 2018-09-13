package employee;

import java.util.Scanner;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 上午9:27 2018/9/9
 * @Modified By:
 */
public class TouTiao4_3 {

    static int max=255;
    static int res=0;

    public static int check(String s){
        if (s.length()==4||s.length()==16){
            return 1;
        }
        check(s,0,0);
        return res;
    }

    public static void check(String s,int cur,int count){
        if (cur>s.length()){
            return;
        }
        if (count>=4&&cur<s.length()){
            return;
        }
        if (count==4&&cur==s.length()){
            res++;
        }
        for (int i=cur+1;i<=Math.min(s.length(),cur+3);i++){
            String temp=s.substring(cur,i);
            if (i>cur+1&&s.charAt(cur)=='0'){
                break;
            }
            if (Integer.valueOf(temp)>255){
                return;
            }
            count++;
            check(s,i,count);
            count--;
        }
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(check(str));
    }
}
