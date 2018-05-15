package leetcode;

/**
 * @Author ROKG
 * @Description 桌子上有一堆石头，每次你们轮流拿掉 1 到 3 块石头。 拿掉最后一块石头的人就是胜利者。
 * @Date: Created in 下午10:38 2018/5/12
 * @Modified By:
 */
public class LeetCode292 {

    public static boolean canWinNim(int n) {
        return (n % 4 != 0);
    }

    public static void main(String[] args) {
        System.out.println(canWinNim(4));
    }
}
