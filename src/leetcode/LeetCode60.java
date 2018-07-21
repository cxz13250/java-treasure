package leetcode;

/**
 * @Author ROKG
 * @Description 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * 给定 n 和 k，返回第 k 个排列。
 * @Date: Created in 上午11:44 2018/7/21
 * @Modified By: *
 */
public class LeetCode60 {

    public String getPermutation(int n, int k) {
        StringBuffer sb=new StringBuffer();
        StringBuffer sbFlag=new StringBuffer();
        for (int i=1;i<=n;i++){
            sbFlag.append(i);
        }
        int num=k;
        int fact=factorial(n);
        for (int i=n;i>=1;i--){
            fact/=i;
            int index=(num-1)/fact;
            String tmp=""+sbFlag.charAt(index);
            sb.append(tmp);
            num-=index*fact;
            sbFlag.deleteCharAt(index);
        }
        return sb.toString();
    }

    private int factorial(int n){
        int sum=1;
        for (int i=1;i<=n;i++){
            sum*=i;
        }
        return sum;
    }

    public static void main(String[] args) {
        LeetCode60 l=new LeetCode60();
        System.out.println(l.getPermutation(3,3));
    }
}
