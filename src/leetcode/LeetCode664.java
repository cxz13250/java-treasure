package leetcode;

/**
 * @Author ROKG
 * @Description 有台奇怪的打印机有以下两个特殊要求：
 * 打印机每次只能打印同一个字符序列。
 * 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
 * 给定一个只包含小写英文字母的字符串，你的任务是计算这个打印机打印它需要的最少次数。
 * @Date: Created in 下午1:39 2018/8/11
 * @Modified By: *
 */
public class LeetCode664 {

    public int strangePrinter(String s) {
        int[][] nums=new int[s.length()][s.length()];
        return print(nums, 0,s.length()-1,s.toCharArray());
    }

    public int print(int[][] nums, int i, int j, char[] s){
        if (i>j){
            return 0;
        }
        if (nums[i][j]>0){
            return nums[i][j];
        }
        int temp=print(nums,i,j-1, s)+1;
        for (int k=i;k<j;k++){
            if (s[k]==s[j]){
                temp=Math.min(temp,print(nums,i,k,s)+print(nums,k+1,j-1,s));
            }
        }
        nums[i][j]=temp;
        return temp;
    }

    public static void main(String[] args) {
        LeetCode664 l =new LeetCode664();
        System.out.println(l.strangePrinter("aaaaaaaaaaaaaaaaaaaaa"));
    }
}
