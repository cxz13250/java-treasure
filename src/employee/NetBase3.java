package employee;

import java.util.Scanner;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午2:56 2018/8/11
 * @Modified By:
 */
public class NetBase3 {

    public static String check(int n,int m,int k){
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<n;i++){
            sb.append("a");
        }
        for (int i=0;i<m;i++){
            sb.append("z");
        }
        if (k==1){
            return sb.toString();
        }
        return "zzaa";
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt(),k=sc.nextInt();
        System.out.println(check(n,m,k));
    }
}
