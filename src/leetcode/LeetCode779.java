package leetcode;

/**
 * @Author ROKG
 * @Description 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 * @Date: Created in 下午12:13 2018/8/11
 * @Modified By: *
 */
public class LeetCode779 {

    public int kthGrammar(int N, int K) {
        if (N==1){
            return 0;
        }else {
            return K%2==0 ? kthGrammar(N-1,(K+1)/2) ^ 1 : kthGrammar(N-1,(K+1)/2);
        }
    }



    public static void main(String[] args) {
        LeetCode779 l =new LeetCode779();
        System.out.println(l.kthGrammar(4,5));
    }
}
