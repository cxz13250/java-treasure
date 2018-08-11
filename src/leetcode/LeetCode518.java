package leetcode;

/**
 * @Author ROKG
 * @Description 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 * @Date: Created in 下午11:37 2018/8/6
 * @Modified By:
 */
public class LeetCode518 {

    public int change(int amount, int[] coins) {
        int[] res=new int[amount+1];
        res[0]=1;
        for (int i:coins){
            for (int j=i;j<res.length;j++){
                res[j]+=res[j-i];
            }
        }
        return res[amount];
    }



    public static void main(String[] args) {
        LeetCode518 l =new LeetCode518();
        System.out.println(l.change(5,new int[]{1,2,5}));
    }
}
