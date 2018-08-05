package employee;

import java.util.Scanner;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午7:00 2018/8/5
 * @Modified By:
 */
public class PingDuoDuo4 {

    int right=0;

    public int check(int nums[]){
        int[] flag=new int[nums.length];
        int count=0;
        int res=0;
        right=nums.length-1;
        while (count<nums.length){
            count+=getMajor(nums,flag);
            res++;
            if (count==nums.length){
                break;
            }
            count+=getMiner(nums,flag);
            res++;
        }
        return res;
    }

    public int getMiner(int[] nums,int[] flag){
        int count=0;
        for (int i=0;i<nums.length;i++){
            if (flag[i]==0&&i+1<nums.length&&nums[i]<nums[i+1]){
                flag[i]=1;
                count++;
            }else if (i==right){
                flag[i]=1;
                while (right>0&&flag[right]==1){
                    right--;
                }
                count++;
            }
        }
        return count;
    }

    public int getMajor(int[] nums,int[] flag){
        int count=0;
        for (int i=0;i<nums.length;i++){
            if (flag[i]==0&&i+1<nums.length&&nums[i]>nums[i+1]){
                flag[i]=1;
                count++;
            }else if (i==right){
                flag[i]=1;
                while (right>0&&flag[right]==1){
                    right--;
                }
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        PingDuoDuo4 p=new PingDuoDuo4();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println(p.check(nums));
    }
}
