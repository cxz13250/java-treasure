package employee;

import java.util.Scanner;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午3:46 2018/9/16
 * @Modified By:
 */
public class TenXun2_2 {

    public static int check(String s,String p){
        boolean[] cc=new boolean[26];
        for (char c:p.toCharArray()){
            cc[c-'a']=true;
        }
        int res=0;
        for (int i=0;i<s.length();i++){
            if (!cc[s.charAt(i)-'a']){
                continue;
            }
            int j=i+p.length();
            int len=0;
            for (;j<s.length()&&isPreSuffix(s.substring(i,j),p);j++){
                len=Math.max(len,j-i);
            }
            res+=len*len;
            i=j;
        }
        return res;
    }

    public static boolean isPreSuffix(String s,String p){
        char chars[]=s.toCharArray();
        char charp[]=p.toCharArray();
        int i=0,j=0;
        while (i<chars.length){
            if(j<charp.length&&chars[i]==charp[j]){
                i++;
                j++;
            }else if (j>=p.length()){
                int k=i-1;
                boolean hasPrefix=false;
                while (k>=i-j){
                   if (p.startsWith(s.substring(k,i+1))){
                       hasPrefix=true;
                       break;
                   }
                   k--;
                }
                if (hasPrefix){
                    i=k;
                    j=0;
                }else {
                    if (s.charAt(i)==p.charAt(0)){
                        j=0;
                    }else {
                        break;
                    }
                }
            }
        }
        return i==chars.length;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String p=sc.next();
        System.out.println(check(s,p));
    }
}
