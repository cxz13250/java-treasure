package employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 上午11:07 2018/8/25
 * @Modified By:
 */
public class TouTiao3_2 {

    public static int checkGroup(int[][] nums){
        int n=nums.length;
        int count=0;
        int[] flag=new int[n];
        for (int i=0;i<n;i++){
            if (flag[i]==1){
                continue;
            }
            count++;
            DFS(i,nums,flag);
        }
        return count;
    }

    public static void DFS(int i,int[][] nums,int flag[]){
        flag[i]=1;
        for(int j=0;j<nums.length;j++){
            if(nums[i][j]==1&&flag[j]!=1) {
                DFS(j,nums,flag);
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=Integer.valueOf(sc.nextLine());
        int[][] nums=new int[m][m];
        for (int i=0;i<m;i++){
            String[] ss=sc.nextLine().split(" ");
            for (int j=0;j<ss.length-1;j++){
                nums[i][Integer.parseInt(ss[j])-1]=1;
                nums[Integer.parseInt(ss[j])-1][i]=1;
            }
            nums[i][i]=1;
        }
        System.out.println(checkGroup(nums));
    }
}
