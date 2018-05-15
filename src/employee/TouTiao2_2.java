package employee;

import java.util.Scanner;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 上午9:49 2018/5/12
 * @Modified By:
 */
public class TouTiao2_2 {

    public static int check(String[] strs1,String str){
        for (int i=0;i< strs1.length;i++){
            if (str.startsWith(strs1[i])){
                return 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        String[] strs1=new String[m];
        String[] strs2=new String[n];
        for (int i=0;i<m;i++){
            strs1[i]=sc.next();
        }
        sc.nextLine();
        for (int i=0;i<n;i++){
            strs2[i]=sc.next();
        }
        int[] result=new int[n];
        for (int i=0;i<n;i++){
            result[i]=check(strs1,strs2[i]);
        }
        for (int i=0;i<n;i++){
            System.out.println(result[i]);
        }
    }
}
