package leetcode;

/**
 * @Author ROKG
 * @Description 对于给定的整数 n, 如果n的k（k>=2）进制数的所有数位全为1，则称 k（k>=2）是 n 的一个好进制。
 * 以字符串的形式给出 n, 以字符串的形式返回 n 的最小好进制。
 * @Date: Created in 下午10:16 2018/9/4
 * @Modified By: *
 */
public class LeetCode483 {

    public String smallestGoodBase(String n) {
        long num=Long.parseLong(n);
        long res=num-1,bits=2;
        while (true){
            long temp=(long) Math.floor(Math.pow(num,1.0/(double)bits));
            if (temp<=1){
                break;
            }
            long temp1=0,temp2=1;
            for (int i=0;i<=bits;i++){
                temp1+=temp2;
                temp2*=temp;
            }
            if (num==temp1){
                res=temp;
            }
            bits++;
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        LeetCode483 l=new LeetCode483();
        System.out.println(l.smallestGoodBase("2251799813685247"));
    }
}
