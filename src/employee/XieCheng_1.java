package employee;

import java.util.Scanner;

/**
 * @Author ROKG
 * @Description 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @Date: Created in 2018/9/27
 * @Modified By:
 */
public class XieCheng_1 {

    public static boolean check(int[][] array,int target){
        int col = array[0].length;
        int raw = array.length;
        int i = 0;
        int j = col - 1;
        while(i <= raw-1 && j >= 0){
            if(array[i][j] < target){
                i++;
            }
            else if(array[i][j] > target){
                j--;
            }else {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String ss[]=s.split("\\|");
        int[][] nums=new int[ss.length][];
        for (int i=0;i<ss.length;i++){
            String[] ns=ss[i].split(",");
            nums[i]=new int[ns.length];
            for (int j=0;j<ns.length;j++){
                nums[i][j]=Integer.valueOf(ns[j]);
            }
        }
        int target=sc.nextInt();
        System.out.println(check(nums, target));
    }

}
