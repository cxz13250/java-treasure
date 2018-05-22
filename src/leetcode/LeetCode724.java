package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
 * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * @Date: Created in 下午1:49 2018/5/18
 * @Modified By:
 */
public class LeetCode724 {

    public static int pivotIndex(int[] nums) {
        if (nums.length==0|| nums.length==1 || nums.length==2){
            return -1;
        }
        for (int i=1;i<nums.length-2;i++){
            int countl=0;
            for (int j=0;j<i;j++){
                countl+=nums[j];
            }
            int countr=0;
            for (int j=i+1;j<nums.length-1;j++){
                countr+=nums[j];
            }
            if (countl==countr){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] num={-1,-1,-1,-1,1,1};
        System.out.println(pivotIndex(num));
    }
}
