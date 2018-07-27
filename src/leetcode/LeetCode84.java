package leetcode;

/**
 * @Author ROKG
 * @Description 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * @Date: Created in 2018/7/27
 * @Modified By:
 */
public class LeetCode84 {

    public int largestRectangleArea(int[] heights) {
        int result=0;
        for (int i=0;i<heights.length;i++){
            int height=heights[i];
            int width=1;
            int left=i-1;
            while (left>=0&&heights[left]>=height){
                left--;
                width++;
            }
            int right=i+1;
            while (right<=heights.length-1&&heights[right]>=height){
                width++;
                right++;
            }
            result=Math.max(result,height*width);
        }
        return result;
    }
}
