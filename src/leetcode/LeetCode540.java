package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 * @Date: Created in 下午1:34 2018/7/22
 * @Modified By: *
 */
public class LeetCode540 {

    public static int singleNonDuplicate(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        if (nums[0]!=nums[1]){
            return nums[0];
        }
        if (nums[nums.length-1]!=nums[nums.length-2]){
            return nums[nums.length-1];
        }
        int l=0,r=nums.length-1;
        while (l<=r){
            int mid=l+(r-l)/2;
            if (nums[mid]!=nums[mid+1]&&nums[mid]!=nums[mid-1]){
                return nums[mid];
            }else if (nums[mid]==nums[mid-1]){
                if ((mid-l-1)%2==1){
                    r=mid-2;
                }else {
                    l=mid+1;
                }
            }else if (nums[mid]==nums[mid+1]){
                if ((mid-l)%2==1){
                    r=mid-1;
                }else {
                    l=mid+2;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] s={1,1,2};
        System.out.println(singleNonDuplicate(s));
    }
}
