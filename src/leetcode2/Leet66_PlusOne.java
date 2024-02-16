package leetcode2;

import java.util.Arrays;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午2:22 2024/1/14
 * @Modified By:
 */
public class Leet66_PlusOne {

    public int[] plusOne(int[] digits) {
        int tmp = 1;
        int[] tmpArr = new int[digits.length];
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = tmp + digits[i];
            if (sum >= 10) {
                tmp = 1;
            } else {
                tmp = 0;
            }
            tmpArr[i] = sum % 10;
        }
        if (tmp == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = tmp;
            for (int i = 0; i < digits.length; i++) {
                res[i + 1] = tmpArr[i];
            }
            return res;
        } else {
            return tmpArr;
        }
    }
}
