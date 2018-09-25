package employee;

import java.util.Scanner;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午8:01 2018/9/17
 * @Modified By:
 */
public class T360_1 {

    public static int check(int k,int l,int r) {
        int res=0;
        int max=0;
        for (int i=l;i<=r;i++) {
            String s = Integer.toString(i,k);
            int count=0;
            for (char c:s.toCharArray()){
                if (c-'0'==k-1){
                    count++;
                }
            }
            if (max<count){
                res=i;
                max=count;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int q=sc.nextInt();
        int[][] nums=new int[q][3];
        for (int i=0;i<q;i++){
            nums[i][0]=sc.nextInt();
            nums[i][1]=sc.nextInt();
            nums[i][2]=sc.nextInt();
        }
        for (int[] num:nums){
            System.out.println(check(num[0],num[1],num[2]));
        }
    }
}
