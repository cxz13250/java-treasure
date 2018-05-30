package leetcode;

/**
 * @Author ROKG
 * @Description 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * @Date: Created in 下午3:34 2018/5/26
 * @Modified By: *
 */
public class LeetCode42 {

    public static int trap(int[] height) {
        int start=0,end=height.length-1;
        if (height.length==0){
            return 0;
        }
        int result=0;
        int left=height[start];
        int right=height[end];
        int low=0;
        while (start<end){
            low=Math.min(left,right);
            if (low==left){
                left=height[++start];
                while (start<end&&left<=low){
                    result+=low-left;
                    left=height[++start];
                }
            }else {
                right=height[--end];
                while (start<end&&right<=low){
                    result+=low-right;
                    right=height[--end];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={4,2,0,3,2,5};
        System.out.println(trap(nums));
    }
}
