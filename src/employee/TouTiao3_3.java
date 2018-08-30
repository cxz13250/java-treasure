package employee;

import java.util.Scanner;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 上午11:43 2018/8/25
 * @Modified By:
 */
public class TouTiao3_3 {

    public static int check(int n){
        int mod=1000000007;
        if (n==1){
            return 10;
        }
        long[] res=new long[n+1];
        res[1]=10;
        res[2]=100;
        for (int i=3;i<=n;i++){
            res[i]=(res[i]+res[i-2])%mod;  //长度为i-2加（）
            for (int j=1;j<i-1;j++){
                res[i]=(res[i]+((res[j]*res[i-j-1])%mod*2)%mod)%mod;  //长度为j何长度为i-j与+，-组合
            }
        }
        return (int)res[n];
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(check(sc.nextInt()));
    }
}
