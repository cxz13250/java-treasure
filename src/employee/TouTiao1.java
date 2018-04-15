package employee;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 上午10:03 2018/4/15
 * @Modified By:
 */
public class TouTiao1 {

    public static int check(List<Integer> integers){
        int result=0;
        for(int i=0;i<integers.size();i++){
            int T=integers.get(i);
            if(isCricle(integers,T)){
                result=integers.get(i);
                break;
            }
        }
        return result;
    }

    public static boolean isCricle(List<Integer> integers,int a){
        int T=a;
        int an=integers.get(integers.size()-1);
        int a1=integers.get(0);
        boolean isCircle=true;
        for(int j=0;j<integers.size();j++){
            int x=integers.get(j);
            if(x==a){
                continue;
            }
            if(x+T<=an&&!(integers.contains(Integer.valueOf(x+T)))){
                isCircle=false;
                break;
            }
            if(x-T>=a1&&!(integers.contains(Integer.valueOf(x-T)))){
                isCircle=false;
                break;
            }
        }
        for(int i=1;i<T;i++){
            if(isCricle(integers,i)){
                isCircle=false;
                break;
            }
        }
        return isCircle;
    }

    public static void print(long arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static long getT(long[] data,int n){
        int step=n-1;
        long T=data[step]-data[0];
        long preT=T;
        boolean con=true;
        while (con){
            for(int i=0;i<n-step;i++){
                if(data[i]+T!=data[i+step]){
                    return preT;
                }
            }
            if(step==1){
                con=false;
            }else if(step>1){
                step--;
                preT=T;
                T=data[step]-data[0];
            }
        }
        return T;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        long[][] arr=new long[n][];
        int head[]=new int[n];
        for(int i=0;i<n;i++){
            String s=sc.nextLine();
            String[] strings=s.split(" ");
            long[] temp=new long[strings.length-1];
            head[i]=Integer.parseInt(strings[0]);
            for (int j=1;j<strings.length;j++){
                temp[j-1]=Long.parseLong(strings[j]);
            }
            arr[i]=temp;
        }
        long[] result=new long[n];
        for (int i=0;i<n;i++){
            result[i]=getT(arr[i],head[i]);
        }
        print(result);
    }
}
