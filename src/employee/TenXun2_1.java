package employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午5:00 2018/5/18
 * @Modified By:
 */
public class TenXun2_1 {

    public static int check(int[] nums,int n){
        List<Integer> list=new ArrayList<>();
        int start=0,end=n-1;
        while (nums[start]==0){
            start++;
        }
        while (nums[end]==0){
            end--;
        }
        for (int i=start;i<end;i++){
            if (nums[i]==1){
                continue;
            }else {
                int j=i+1;
                while (nums[j]==0){
                    j++;
                }
                list.add(j-i+1);
                i=j-1;
            }
        }
        int res=1;
        for (int i:list){
            res*=i;
        }
        return res;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println(check(nums,n));
    }

}
