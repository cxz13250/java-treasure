package dataStructure.graph;

/**
 * @Author ROKG
 * @Description 邻接有向图
 * @Date: Created in 下午2:17 2018/4/3
 * @Modified By:
 */
public class GraphDG {

    private int size;
    private int[][] martix;
    private int[] vertexs;
    private int[] visitedCount;

    GraphDG(int[] vertexs,int[][] edges){
        size=vertexs.length;
        martix=new int[size][size];
        this.vertexs=vertexs;

        for(int[] i:edges){
            int p1=getPosition(i[0]);
            int p2=getPosition(i[1]);

            martix[p1][p2]=1;
        }
    }

    int getPosition(int a){
        for(int i:vertexs){
            if(vertexs[i]==a){
                return i;
            }
        }
        return -1;
    }


}

