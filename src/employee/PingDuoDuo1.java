package employee;

import java.util.Scanner;

/**
 * @Author ROKG
 * @Description 旋转打印字符串，向右-向下-向左-向上
 * @Date: Created in 下午6:55 2018/8/5
 * @Modified By:
 */
public class PingDuoDuo1 {

    public static char[][] check(String s){
        int totalLength=s.length();
        int width=(totalLength-4)/4+2;
        char[][] res=new char[width][width];
        for (int i=0;i<width;i++){
            for (int j=0;j<width;j++){
                res[i][j]=' ';
            }
        }
        int i=0,j=0;
        int count=0;
        while (count<totalLength){
            res[i][j]=s.charAt(count);
            count++;
            if (i==0&&j<width-1){
                j++;
            }else if (j==width-1&i<width-1){
                i++;
            }else if (i==width-1&&j>0){
                j--;
            }else if (j==0&&i>0){
                i--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String in=sc.next();
        char[][] result=check(in);
        for (int i=0;i<result.length;i++){
            for (int j=0;j<result[0].length;j++){
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
}
