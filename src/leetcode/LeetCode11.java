package leetcode;

/**
 * @Author ROKG
 * @Description
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
