package leetcode;

/**
 * @Author ROKG
 * @Description 假设有 n 台超级洗衣机放在同一排上。开始的时候，每台洗衣机内可能有一定量的衣服，也可能是空的。
 * 在每一步操作中，你可以选择任意 m （1 ≤ m ≤ n） 台洗衣机，与此同时将每台洗衣机的一件衣服送到相邻的一台洗衣机。
 * 给定一个非负整数数组代表从左至右每台洗衣机中的衣物数量，请给出能让所有洗衣机中剩下的衣物的数量相等的最少的操作步数。如果不能使每台洗衣机中衣物的数量相等，则返回 -1。
 * @Date: Created in 下午5:17 2018/9/1
 * @Modified By: *
 */
public class LeetCode517 {

    public static int findMinMoves(int[] machines) {
        int num=machines.length;
        int sum=0;
        int res=0;
        for (int i:machines){
            sum+=i;
        }
        if (sum%num!=0){
            return -1;
        }
        int temp=0;
        int avg=sum/num;
        for (int i:machines){
            temp+=i-avg;
            res=Math.max(res,Math.max(i-avg,Math.abs(temp)));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findMinMoves(new int[]{1,0,5}));
    }
}
