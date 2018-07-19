package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
 * @Date: Created in 2018/7/19
 * @Modified By:
 */
public class LeetCode307 {

    class NumArray {

        int[] nums;

        public NumArray(int[] nums) {
            this.nums=nums;
        }

        public void update(int i, int val) {
            nums[i]=val;
        }

        public int sumRange(int i, int j) {
            int sum=0;
            for (int k=i;k<=j;k++){
                sum+=nums[k];
            }
            return sum;
        }
    }

}
