package employee;

import java.util.Scanner;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午7:46 2018/5/11
 * @Modified By:
 */
public class Ali1 {

    public static int check(int[][] nums,String[] start,String[] end){
        int startx=Integer.parseInt(start[0]);
        int starty=Integer.parseInt(start[1]);
        String startHead=start[2];
        int endx=Integer.parseInt(end[0]);
        int endy=Integer.parseInt(end[1]);
        String endHead=end[2];
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String str1=sc.nextLine();
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] nums=new int[m][n];
        for (int i=0;i<m;i++){
            String temp=sc.nextLine();
            String[] strings=temp.split(" ");
            for (int j=0;j<m;j++){
                nums[i][j]=Integer.valueOf(strings[j]);
            }
        }
        System.out.println(check(nums,str.split(" "),str1.split(" ")));
    }
}
