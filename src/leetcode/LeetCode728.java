package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 自除数 是指可以被它包含的每一位数除尽的数。例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 还有，自除数不允许包含 0 。给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 * @Date: Created in 下午3:24 2018/5/19
 * @Modified By:
 */
public class LeetCode728 {

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list=new ArrayList<>();
        for (int i=left;i<=right;i++){
            if (check(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public static boolean check(int n){
        int temp=n;
        while (temp>=10){
            if (temp%10==0){
                return false;
            }
            if (temp%10!=0&&n%(temp%10)!=0){
                return false;
            }
            temp/=10;
        }
        if ( n%temp==0) {
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1,22));
    }
}
