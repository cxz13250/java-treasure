package leetcode;

/**
 * @Author ROKG
 * @Description
 * 给定两个整数 n 和 k，你需要实现一个数组，这个数组包含从 1 到 n 的 n 个不同整数，同时满足以下条件：
 * ① 如果这个数组是 [a1, a2, a3, ... , an] ，那么数组 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 中应该有且仅有 k 个不同整数；.
 * ② 如果存在多种答案，你只需实现并返回其中任意一种.
 * @Date: Created in 2018/9/19
 * @Modified By:
 */
public class LeetCode667 {

    public int[] constructArray(int n, int k) {
        int[] nums=new int[n];
        for (int i=1;i<=n;i++){
            nums[i-1]=i;
        }
        for (int i=k;i>=0;i--){
            reverse(nums, n-i, n-1);
        }
        return nums;
    }

    public void reverse(int[] nums,int start,int end){
        for (int i=start,j=end;i<j;i++,j--){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
    }

    public static void main(String[] args) {
        LeetCode667 l=new LeetCode667();
        l.constructArray(3, 1);
    }
}
