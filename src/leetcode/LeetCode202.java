package leetcode;

import java.util.HashSet;

/**
 * @Author ROKG
 * @Description 编写一个算法来判断一个数是不是“快乐数”。一个“快乐数”定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
 * 也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * @Date: Created in 下午1:22 2018/5/1
 * @Modified By:
 */
public class LeetCode202 {

    static HashSet<Integer> set=new HashSet<>();

    public static boolean isHappy(int n) {
        int result=check(n);
        if(result==-1){
            return false;
        }else {
            return true;
        }
    }

    public static int check(int n){
        int temp=0;
        while (n>0){
            temp+=Math.pow(n%10,2);
            n=n/10;
        }
        if(temp==1){
            return 1;
        }else if(set.contains(temp)){
            return -1;
        } else {
            set.add(temp);
            return check(temp);
        }
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2147483647));
    }
}
