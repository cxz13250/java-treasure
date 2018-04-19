package employee;

import java.util.Scanner;

/**
 * @Author ROKG
 * @Description X,Y,Z三个数要是他们一样大，两个操作：第一种，选一个数加2；第二种选两个数加1
 * @Date: Created in 下午7:43 2018/4/19
 * @Modified By:
 */
public class Aqy2 {

    public static int check(int x,int y,int z){
        int max=0;
        if(x>y){
            max=x;
        }else {
            max=y;
        }
        if(z>max){
            max=z;
        }
        int temp=(max*3-x-y-z);
        int result=temp/2;
        if(temp%2!=0){
            result+=2;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        int z=sc.nextInt();
        System.out.println(check(x,y,z));
    }
}
