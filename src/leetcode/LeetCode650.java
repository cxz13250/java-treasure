package leetcode;

/**
 * @Author ROKG
 * @Description 最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：
 * Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
 * Paste (粘贴) : 你可以粘贴你上一次复制的字符。
 * 给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 个 'A' 的最少操作次数。
 * @Date: Created in 下午5:37 2018/8/12
 * @Modified By:
 */
public class LeetCode650 {

    public int minSteps(int n) {
        if(n==1){
            return 0;
        }else if (n==2){
            return 2;
        }else if (n==3){
            return 3;
        }else {
            int maxDivsor=getMaxDivsor(n);
            if (maxDivsor==1){
                return n;
            }else {
                return minSteps(maxDivsor)+n/maxDivsor;
            }
        }
    }

    public int getMaxDivsor(int n){
        for (int i=n/2;i>0;i--){
            if (n%i==0){
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        LeetCode650 l=new LeetCode650();
        System.out.println(l.minSteps(6));
    }
}
