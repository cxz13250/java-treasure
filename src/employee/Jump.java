package employee;

import java.util.Scanner;

/**
 * @Author ROKG
 * @Description 华为笔试第2题，判断一组数字，每次跳跃数为当前元素值，需要跳跃几次能到终点，如:2,3,2,1,2,1,5 需要3次
 * @Date: Created in 下午7:51 2018/4/10
 * @Modified By:
 */
public class Jump {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Jump t=new Jump();
        System.out.println(t.jump(arr));
    }

    public int jump(int[] arr){
        int max=0;
        int sum=0;
        int jump=0;
        for(int i=0;i<arr.length-1;i++){
            if(i+arr[i]>max){
                max=i+arr[i];
            }
            if(i==jump){
                jump=max;
                sum++;
            }
        }
        return sum;
    }
}
