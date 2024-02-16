package leetcode2;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 上午11:13 2024/2/15
 * @Modified By:
 */
public class Leet35_SearchPosition {

    public static int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1, res = nums.length;
        while (l <= r) {
            int mid = (l + r) / 2;
            int num = nums[mid];
            if (num >= target) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(searchInsert(new int[]{1, 3}, 4));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
//        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
//        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
    }
}
