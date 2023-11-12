package leetcode;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午11:48 2020/5/21
 * @Modified By:
 */
public class LeetCode883 {

    public int projectionArea(int[][] grid) {
        int sum=0;
        int n=grid.length;
        int[] xz=new int[n];
        int[] yz=new int[n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]==0){
                    continue;
                }
                sum++;
                xz[i]=Math.max(xz[i],grid[i][j]);
                yz[j]=Math.max(yz[j],grid[i][j]);
            }
        }
        for (int i=0;i<n;i++){
            sum+=xz[i];
            sum+=yz[i];
        }
        return sum;
    }
}
