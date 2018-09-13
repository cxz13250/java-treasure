package employee;

import java.util.Scanner;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 上午9:27 2018/9/9
 * @Modified By:
 */
public class TouTiao4_2 {

    static int[][] pos={{-1,0},{1,0},{0,-1},{0,1}};

    public static int check(int[][] nums){
        int n=nums.length;
        boolean[][] visited=new boolean[n][n];
        int res=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (!visited[i][j]){
                    if (nums[i][j]==1){
                        change(nums,i,j);
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public static void change(int[][] nums,int x,int y){
        nums[x][y]=0;
        for (int i=0;i<4;i++){
            int nx=x+pos[i][0];
            int ny=y+pos[i][1];
            if (nx>=0&&nx<nums.length&&ny>=0&&ny<nums[0].length&&nums[nx][ny]==1){
                change(nums,nx,ny);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] nums=new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                nums[i][j]=sc.nextInt();
            }
        }
        System.out.println(check(nums));
    }
}
