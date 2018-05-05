package leetcode;

/**
 * @Author ROKG
 * @Description 给一个非负整数 num，反复添加所有的数字，直到结果只有一个数字。
 * @Date: Created in 下午9:06 2018/5/2
 * @Modified By:
 */
public class LeetCode258 {

    public int addDigits(int num) {
        if(num<10){
            return num;
        }else {
            return check(num);
        }
    }

    public int check(int num){
        int result=0;
        while (num>0){
            result+=num%10;
            num/=10;
        }
        if(result<10){
            return result;
        }else {
            return check(result);
        }
    }

    public int addDigits2(int num){
        return (num-1)%9+1;
    }

    public static void main(String[] args) {

    }
}
