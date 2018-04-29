package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个数组，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * @Date: Created in 下午2:32 2018/4/28
 * @Modified By:
 */
public class LeetCode303 {

    private int[] result;

    public LeetCode303(int[] nums) {
        result=new int[nums.length];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            result[i]=sum;
        }
    }

    public int sumRange(int i, int j) {
        if(i==0){
            return result[j];
        }else {
            return result[j] - result[i - 1];
        }
    }

    public static void main(String[] args) {

    }
}
