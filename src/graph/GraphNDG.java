package graph;

import array.Base;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author ROKG
 * @Description 邻接无向图
 * @Date: Created in 下午2:17 2018/4/3
 * @Modified By:
 */
public class GraphNDG {

    private int size;
    private int[][] martix;
    private char[] vertexs;
    private int[] visitedCount;
    private int[][] weights;

    GraphNDG(char[] vertexs,char[][] edges,int[] w){
        size=vertexs.length;
        martix=new int[size][size];
        weights=new int[size][size];
        visitedCount=new int[size];
        this.vertexs=vertexs;

        for(int i=0;i<edges.length;i++){
            int p1=getPosition(edges[i][0]);
            int p2=getPosition(edges[i][1]);
            int weight=w[i];

            martix[p1][p2]=1;
            martix[p2][p1]=1;
            weights[p1][p2]=weight;
            weights[p2][p1]=weight;
        }
    }

    int getPosition(char a){
        for(int i=0;i<vertexs.length;i++){
            if((vertexs[i]-a)==0){
                return i;
            }
        }
        return -1;
    }

    /**
     * 深度优先遍历
     * @param i
     */
    public void DFS(int i){
        visitedCount[i]=1;
        System.out.println(vertexs[i]);
        for(int j=0;j<vertexs.length;j++){
            if(martix[i][j]==1&&visitedCount[j]!=1) {
                DFS(j);
            }
        }
    }

    /**
     * 广度优先遍历
     * @param i
     */
    public void BFS(int i){
        Queue<Integer> queue = new LinkedList<>();
        int next;
        queue.add(i);
        visitedCount[i]=1;
        while (!queue.isEmpty()) {
            next=queue.remove();
            System.out.println(vertexs[next]);
            int vex = getFirst(next);
            while (vex!=-1) {
                if (visitedCount[vex]==0) {
                    queue.add(vex);
                    visitedCount[vex]=1;
                }
                vex=getNext(next, vex);
            }
        }
    }

    public void prim(int n){

    }

    public int getFirst(int v) {
        for(int i=0;i<vertexs.length;i++) {
            if (martix[v][i]==1) {
                return i;
            }
        }
        return -1;
    }

    public int getNext(int v,int k) {
        for(int i=k+1;i<vertexs.length;i++) {
            if (martix[v][i] == 1) {
                return i;
            }
        }
        return -1;
    }

    public void initVisitedCount(){
        for(int i = 0; i < visitedCount.length; i ++){
            visitedCount[i] = 0;
        }
    }

    public static void main(String[] args) {
        char[] vertexs={'A','B','C','D','E','F','G','H','I'};
        char[][] edges={{'A','B'},{'A','F'},{'B','G'},{'B','C'},{'B','I'},{'F','G'},{'F','E'},{'G','H'},{'H','E'},{'I','D'},{'C','D'},{'D','E'},{'H','D'},{'D','G'}};
        int[] weights={10,6,9,11,15,3,8,5,12,7,20,17,4,13};
        GraphNDG n=new GraphNDG(vertexs,edges,weights);
        n.initVisitedCount();
        System.out.println("深度优先遍历");
        n.DFS(0);
        n.initVisitedCount();
        System.out.println("广度优先遍历");
        n.BFS(0);
    }
}
