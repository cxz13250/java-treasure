package employee;

import java.util.Scanner;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 上午11:42 2018/4/15
 * @Modified By:
 */
public class TouTiao3 {

    public static int check(int[] arr,String str){
        int sum=0;
        int N=arr[0];
        int M=arr[1];
        int X=arr[2];
        int Y=arr[3];
        char[] chars=str.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='u'){
                X--;
            }else if(chars[i]=='d'){
                X++;
            }else if(chars[i]=='l'){
                Y--;
            }else if(chars[i]=='r'){
                Y++;
            }
            sum++;
            if(X<=0||X>N){
                return sum;
            }else if(Y<=0||Y>M){
                return sum;
            }
        }
        return sum;
    }

    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=Integer.parseInt(sc.nextLine());
        int[][] arr=new int[n][4];
        for(int i=0;i<n;i++){
            String temp=sc.nextLine();
            String[] strings=temp.split(" ");
            for(int j=0;j<4;j++){
                arr[i][j]=Integer.parseInt(strings[j]);
            }
        }
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            result[i]=check(arr[i],s);
        }
        print(result);
    }
}
