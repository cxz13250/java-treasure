package leetcode2;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 上午10:48 2024/2/12
 * @Modified By:
 */
public class Leet238_MoveZeros {

    public static void moveZeroes(int[] nums) {
        int noZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            nums[noZeroIndex] = nums[i];
            if (i != noZeroIndex) {
                // 发生过交换，原位置置0
                nums[i] = 0;
            }
            noZeroIndex ++;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2};
        moveZeroes(a);
        System.out.println(a);
    }
}
