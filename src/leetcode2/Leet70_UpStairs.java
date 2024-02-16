package leetcode2;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午8:53 2024/2/3
 * @Modified By:
 */
public class Leet70_UpStairs {

    // n阶的方法 = n-1阶的方法 + n-2阶的方法
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] temp = new int[n + 1];
        temp[0] = 1;
        temp[1] = 1;
        for (int i = 2; i <= n; i++) {
            temp[i] = temp[i - 1] + temp[i - 2];
        }
        return temp[n];
    }

    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        int a = 1;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return b;
    }
}
