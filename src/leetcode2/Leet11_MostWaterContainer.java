package leetcode2;

/**
 * @Author ROKG
 * @Description 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * @Date: Created in 上午11:46 2024/1/27
 * @Modified By:
 */
public class Leet11_MostWaterContainer {

    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            int temp = (j - i) * Math.min(height[i], height[j]);
            max = Math.max(max, temp);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Leet11_MostWaterContainer().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
