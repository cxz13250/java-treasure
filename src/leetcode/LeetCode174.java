package leetcode;

/**
 * @Author ROKG
 * @Description 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 * @Date: Created in 2018/8/27
 * @Modified By:
 */
public class LeetCode174 {

    public int calculateMinimumHP(int[][] dungeon) {
        int m=dungeon.length;
        int n=dungeon[0].length;
        int[][] res=new int[m][n];
        res[m-1][n-1]=dungeon[m-1][n-1]<0?1-dungeon[m-1][n-1]:1;  // 如果最后一个房间里是恶魔,则骑士进入那个房间之前最少得有1-dungeon[m-1][n-1]点健康值
        for (int i=n-2;i>=0;i--){
            res[m-1][i]=dungeon[m-1][i]<res[m-1][i+1]?res[m-1][i+1]-dungeon[m-1][i]:1;
        }
        for (int i=m-2;i>=0;i--){
            res[i][n-1]=dungeon[i][n-1]<res[i+1][n-1]?res[i+1][n-1]-dungeon[i][n-1]:1;
        }
        for (int i=m-2;i>=0;i--){
            for (int j=n-2;j>=0;j--){
                int right=dungeon[i][j]<res[i][j+1]?res[i][j+1]-dungeon[i][j]:1;
                int left=dungeon[i][j]<res[i+1][j]?res[i+1][j]-dungeon[i][j]:1;
                res[i][j]=Math.min(right, left);
            }
        }
        return res[0][0];
    }

    public static void main(String[] args) {
        LeetCode174 l=new LeetCode174();
        System.out.println(l.calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}}));
    }
}
