package employee;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午2:56 2018/8/11
 * @Modified By:
 */
public class NetBase2 {

    public static int[] check(int[] nums){
        int n=nums.length;
        int sum=0;
        for (int i=0;i<n;i++){
            sum+=nums[i];
        }
        int[] res=new int[sum];
        int index=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<nums[i];j++){
                res[index++]=i+1;
            }
        }
        return res;
    }

    public static int[] check2(int[] nums, int[] ques){
        int max=0;
        int n=nums.length;
        int m=ques.length;
        for (int i=0;i<m;i++){
            max=Math.max(max,ques[i]);
        }
        int[] res=new int[max];
        int index=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<nums[i];j++){
                res[index++]=i+1;
                if (index>=max){
                    break;
                }
            }
            if (index>=max){
                break;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] apples=new int[n];
        for (int i=0;i<n;i++){
            apples[i]=sc.nextInt();
        }
        int m=sc.nextInt();
        int[] ques=new int[m];
        for (int i=0;i<m;i++){
            ques[i]=sc.nextInt();
        }
        int res[]= check2(apples,ques);
        for (int i=0;i<m;i++){
            System.out.println(res[ques[i]-1]);
        }
    }
}
