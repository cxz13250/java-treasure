package leetcode;

/**
 * @Author ROKG
 * @Description 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。给定一个数字 n，找出可形成完整阶梯行的总行数。
 * @Date: Created in 下午12:59 2018/5/5
 * @Modified By:
 */
public class LeetCode441 {

    public static int arrangeCoins(int n) {
        int i=1;
        while (n>=i){
            n-=i;
            i++;
        }
        return i-1;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(8));
    }
}
