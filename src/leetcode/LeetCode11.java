package leetcode;

/**
 * @Author ROKG
 * @Description 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * @Date: Created in 下午9:46 2018/4/15
 * @Modified By:
 */
public class LeetCode11 {

    public static int maxArea(int[] height) {
        int max=0;
        int i=0;
        int j=height.length-1;
        while(i<j){
            int temp=(j-i)*Math.min(height[i],height[j]);
            max=Math.max(max,temp);
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int height[]={1,1};
        System.out.println(maxArea(height));
        int height1[]={0,2};
        System.out.println(maxArea(height1));
        int height2[]={1,2,4,3};
        System.out.println(maxArea(height2));
    }
}
