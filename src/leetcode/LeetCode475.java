package leetcode;

import java.util.Arrays;

/**
 * @Author ROKG
 * @Description 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
 * 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
 * @Date: Created in 下午7:26 2018/5/17
 * @Modified By:
 */
public class LeetCode475 {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int result=0;
        int j=0;
        for (int i=0;i<houses.length;i++){
            int tmp=0;
            while (j<heaters.length&&heaters[j]<houses[i]){
                j++;
            }
            if (j==heaters.length){
                tmp=houses[i]-heaters[j-1];
            }else if (j==0){
                tmp=heaters[j]-houses[i];
            }else if (heaters[j]>houses[i]){
                tmp=Math.min(heaters[j]-houses[i],houses[i]-heaters[j-1]);
            }
            result=Math.max(tmp,result);
        }
        return result;
    }

}
