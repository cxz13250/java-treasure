package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 编写一个程序，找出第 n 个丑数。丑数就是只包含质因数 2, 3, 5 的正整数。
 * @Date: Created in 下午5:43 2018/6/9
 * @Modified By: *
 */
public class LeetCode264 {

    public static int nthUglyNumber(int n) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        int cur=2;
        int i=0,j=0,k=0;
        int min1,min2,min3;
        while (list.size()<n){
            while (list.get(i)*2<cur) {
                i++;
            }
            min1=list.get(i)*2;
            while (list.get(j)*3<cur) {
                j++;
            }
            min2=list.get(j)*3;
            while (list.get(k)*5<cur){
                k++;
            }
            min3=list.get(k)*5;
            int next=Math.min(min1,Math.min(min2,min3));
            cur=next+1;
            list.add(next);
        }
        return list.get(n-1);
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}
