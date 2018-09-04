package leetcode;

import java.util.PriorityQueue;

/**
 * @Author ROKG
 * @Description 给定一个m x n的矩阵，其中的值均为正整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 * @Date: Created in 2018/9/4
 * @Modified By: *
 */
public class LeetCode407 {

    class Element{
        int x;
        int y;
        int h;
        Element(int x,int y,int h){
            this.x=x;
            this.y=y;
            this.h=h;
        }
    }

    // 先把四个边上的元素入队列，按高度从低到高排列，依次出队，每出一个元素，便与上下左右四个格子高度对比（去除已经遍历过的），
    // 高度差即为雨水体积，将新的元素入队，高度为max（出队元素高，相邻格子高度），坐标为相邻格子坐标
    public int trapRainWater(int[][] heightMap) {
        int m=heightMap.length;
        if (m<=2){
            return 0;
        }
        int n=heightMap[0].length;
        if (n<=2){
            return 0;
        }
        PriorityQueue<Element> queue=new PriorityQueue<>((a,b) -> a.h-b.h);
        int res=0;
        boolean[][] visited=new boolean[m][n];
        int[] posx=new int[]{-1,0,1,0};
        int[] posy=new int[]{0,-1,0,1};
        for (int i=0;i<m;i++){
            visited[i][0]=true;
            visited[i][n-1]=true;
            queue.offer(new Element(i, 0, heightMap[i][0]));
            queue.offer(new Element(i, n-1, heightMap[i][n-1]));
        }
        for (int i=1;i<n-1;i++){
            visited[0][i]=true;
            visited[m-1][i]=true;
            queue.offer(new Element(0, i, heightMap[0][i]));
            queue.offer(new Element(m-1, i, heightMap[m-1][i]));
        }
        while (!queue.isEmpty()){
            Element e=queue.poll();
            for (int i=0;i<4;i++){
                int nx=e.x+posx[i];
                int ny=e.y+posy[i];
                if (nx>=0&&nx<m&&ny>=0&&ny<n&&!visited[nx][ny]){
                    visited[nx][ny]=true;
                    res+=Math.max(0, e.h-heightMap[nx][ny]);
                    queue.offer(new Element(nx, ny, Math.max(e.h,heightMap[nx][ny])));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode407 l=new LeetCode407();
        System.out.println(l.trapRainWater(new int[][]{
                {12,13,1,12},
                {13,4,13,12},
                {13,8,10,12},
                {12,13,12,12},
                {13,13,13,13}}));
    }
}
