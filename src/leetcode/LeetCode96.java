package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * @Date: Created in 下午2:11 2018/5/24
 * @Modified By: **
 */
public class LeetCode96 {

    public int numTrees(int n) {
        if (n==1||n==0){
            return 1;
        }
        int result[]=new int[n+1];
        result[0]=1;
        result[1]=1;
        for (int i=2;i<=n;i++){
            int sum=0;
            for (int left=0;left<i;left++){
                int right=i-1-left;
                sum+=result[left]*result[right];
            }
            result[i]=sum;
        }
        return result[n];
    }

    public static int numTrees2(int n) {
        if (n==1||n==0){
            return 1;
        }
        int result=0;
        for (int i=0;i<n;i++){
            result+=numTrees2(i)*numTrees2(n-i-1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numTrees2(18));
    }
}
