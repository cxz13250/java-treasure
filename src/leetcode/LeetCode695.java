package leetcode;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 2018/7/30
 * @Modified By:
 */
public class LeetCode695 {

    public int maxAreaOfIsland(int[][] grid) {
        int res=0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==1){
                    int area=check(grid,i,j);
                    res=Math.max(res,area);
                }
            }
        }
        return res;
    }

    public int check(int[][] grid,int i,int j){
        if (i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]!=1){
            return 0;
        }else{
            grid[i][j]=2;
            return 1+check(grid,i-1,j)+check(grid,i+1,j)+check(grid,i,j-1)+check(grid,i,j+1);
        }
    }

    public static void main(String[] args) {
        LeetCode695 l=new LeetCode695();
        int[][] nums={{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(l.maxAreaOfIsland(nums));
    }
}
