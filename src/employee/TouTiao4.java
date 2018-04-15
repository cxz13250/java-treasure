package employee;

import java.util.Scanner;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 上午10:50 2018/4/15
 * @Modified By:
 */
public class TouTiao4 {

    public static int[] check(int[] arr){
        int[] result=new int[2];
        int k=arr[0];
        for(int i=1;i<arr.length;i++){

        }
        return result;
    }



    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        int[][] arr=new int[n][];
        for(int i=0;i<n;i++){
            String s=sc.nextLine();
            String[] strings=s.split(" ");
            int[] temp=new int[strings.length];
            for (int j=0;j<strings.length;j++){
                temp[j]=Integer.parseInt(strings[j]);
            }
        }
    }
}
