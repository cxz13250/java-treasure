package leetcode;

/**
 * @Author ROKG
 * @Description 给出两个整数 n 和 k，找出所有包含从 1 到 n 的数字，且恰好拥有 k 个逆序对的不同的数组的个数。
 * 逆序对的定义如下：对于数组的第i个和第 j个元素，如果满i < j且 a[i] > a[j]，则其为一个逆序对；否则不是。
 * 由于答案可能很大，只需要返回 答案 mod 109 + 7 的值。
 * @Date: Created in 2018/9/12
 * @Modified By: *
 */
public class LeetCode629 {

    public int kInversePairs(int n, int k) {
        int[][] res=new int[n+1][k+1];
        int mod=1000000007;
        res[1][0]=1;
        for (int i=2;i<=n;i++){
            res[i][0]=1;
            for (int j=1;j<=k&&j<=(i-1)*i/2;j++){
                res[i][j]=(res[i][j-1]+res[i-1][j])%mod;
                if (j>=i){
                    res[i][j]=(res[i][j]-res[i-1][j-i]+mod)%mod;  // res[i][j]是取mod后的值，有可能减去res[i-1][j-i]后会为负，所以需要加mod再取模
                }
            }
        }
        return res[n][k];
    }
}
