package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
 * @Date: Created in 上午12:01 2018/5/15
 * @Modified By:
 */
public class LeetCode66 {

    public int[] plusOne(int[] digits) {

        int temp=digits[digits.length-1]+1;
        if (temp<10){
            digits[digits.length-1]=temp;
            return digits;
        }else {
            digits[digits.length-1]=(temp%10);
            int flag=1;
            for (int i = digits.length - 1; i >= 0; i--) {
                if (i==digits.length-1){
                    continue;
                }
                if (flag==0){
                    break;
                }
                temp=digits[i]+flag;
                if (temp<10){
                    flag=0;
                    digits[i]=temp;
                }else {
                    digits[i]=temp%10;
                }
            }
            if (flag==1){
                int[] result=new int[digits.length+1];
                result[0]=1;
                for (int i=0;i<digits.length;i++){
                    result[i+1]=digits[i];
                }
                return result;
            }else {
                return digits;
            }

        }
    }
}
