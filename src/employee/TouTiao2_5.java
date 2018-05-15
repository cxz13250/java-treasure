package employee;

import java.util.Scanner;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 上午9:49 2018/5/12
 * @Modified By:
 */
public class TouTiao2_5 {

    static int result=0;

    public static int check(int[][] nums,int n,int m){
        for (int i=0;i<n;i++){
            for (int j=1;j<m;j++){
                if (i==0){
                    nums[i][j]+=Math.max(nums[i][j-1],nums[i+1][j-1]);
                }else if (i==n-1){
                    nums[i][j]+=Math.max(nums[i][j-1],nums[i-1][j-1]);
                }else {
                    nums[i][j]+=Math.max(nums[i-1][j-1],Math.max(nums[i][j-1],nums[i+1][j-1]));
                }
            }
        }
        int result=0;
        for (int i=0;i<n;i++){
            result+=Math.max(nums[i][m-1],result);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] nums=new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                nums[i][j]=sc.nextInt();
            }
        }
        System.out.println(check(nums,n,m));
    }
}
