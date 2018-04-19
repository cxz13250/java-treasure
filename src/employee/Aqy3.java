package employee;

import java.util.Scanner;

/**
 * @Author ROKG
 * @Description n种糖果组成m个糖果的礼盒，第i种糖果，最少不能低于min[i]个，最大不能超过max[i]个
 * @Date: Created in 下午7:54 2018/4/19
 * @Modified By:
 */
public class Aqy3 {

    static int result=0;
    static int category=0;

    public static void check(int local,int sum,int max[]){
        if(sum<0){
            return;
        }
        if(sum==0){
            result++;
            return;
        }
        if(sum>0) {
            if (local >= category) {
                return;
            }
            for (int i = 0; i <= max[local]; i++) {
                check(local + 1, sum - i, max);
            }
        }
    }



    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        category=sc.nextInt();
        int sum=sc.nextInt();
        int[] min=new int[category];
        int[] max=new int[category];
        for(int i=0;i<category;i++){
            min[i]=sc.nextInt();
            max[i]=sc.nextInt();
            sum-=min[i];
            max[i]-=min[i];
        }
        check(0,sum,max);
        System.out.println(result);
    }
}
