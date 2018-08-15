package employee;

import java.util.Scanner;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午2:55 2018/8/11
 * @Modified By:
 */
public class NetBase1 {

    public static int getMax(int[] hobby,int[] flag,int k){
        int n=hobby.length;
        int max=0;
        int sum=0;
        for (int i=0;i<n;i++){
            if (flag[i]==1){
                sum+=hobby[i];
                hobby[i]=0;
            }
        }
        int count=0;
        for (int i=0;i<k;i++){
            count+=hobby[i];
        }
        max=sum+count;
        int start=0,end=k;
        for (;end<n;start++,end++){
           count=(count-hobby[start]+hobby[end]);
           max=Math.max(max,sum+count);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int hobby[]=new int[n];
        int flag[]=new int[n];
        for (int i=0;i<n;i++){
            hobby[i]=sc.nextInt();
        }
        for (int i=0;i<n;i++){
            flag[i]=sc.nextInt();
        }
        System.out.println(getMax(hobby,flag,k));
    }
}
