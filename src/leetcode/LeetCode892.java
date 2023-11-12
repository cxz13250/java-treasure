package leetcode;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午10:56 2020/5/21
 * @Modified By:
 */
public class LeetCode892 {

    public int surfaceArea(int[][] grid) {
        int m=0,n=0;
        if (grid.length>0){
            m=grid.length;
        }
        if (grid[0].length>0){
            n=grid[0].length;
        }
        int sum=0;
        for (int i = 0; i<m;i++){
            for (int j =0;j<n;j++){
                if (grid[i][j]==0){
                    continue;
                }
                sum+=(2+4*grid[i][j]);
                if (j+1<n){
                    sum -= 2*Math.min(grid[i][j],grid[i][j+1]);
                }
                if (i+1<m){
                    sum -= 2*Math.min(grid[i][j],grid[i+1][j]);
                }
            }
        }
        return sum;
    }
}
