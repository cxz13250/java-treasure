package employee;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午7:27 2018/9/9
 * @Modified By:
 */
public class JingDong2_1 {

    static int[][] vertixs;
    public static boolean isValid(int points,int[][] edges){
        vertixs=new int[points+1][points+1];
        for (int i=0;i<edges.length;i++){
            vertixs[edges[i][0]][edges[i][1]]=1;
            vertixs[edges[i][1]][edges[i][0]]=1;
        }
        // 检验是否连通
        boolean[] visited=new boolean[points+1];
        DFS(1,visited);
        for (int i=1;i<visited.length;i++){
            if (!visited[i]){
                return false;
            }
        }
        return true;
    }

    public static void DFS(int i,boolean[] visited){
        visited[i]=true;
        for(int j=1;j<visited.length;j++){
            if(vertixs[i][j]==1&&!visited[j]) {
                DFS(j,visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] points=new int[n];
        int[][][] edges=new int[n][][];
        for (int i=0;i<n;i++){
            points[i]=sc.nextInt();
            edges[i]=new int[sc.nextInt()][2];
            for(int j=0;j<edges[i].length;j++){
                edges[i][j][0]=sc.nextInt();
                edges[i][j][1]=sc.nextInt();
            }
        }
        for (int i=0;i<n;i++){
            System.out.println(isValid(points[i],edges[i])?"Yes":"No");
        }
    }
}
