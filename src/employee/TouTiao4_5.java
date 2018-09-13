package employee;

import java.util.*;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 上午10:58 2018/9/9
 * @Modified By:
 */
public class TouTiao4_5 {

    public static int check2(int[][] relations,int n){
        int res=0;
        int[] degrees=new int[n+1];
        for (int i=0;i<relations.length;i++){
            degrees[relations[i][1]]=degrees[relations[i][0]]+1;
        }
        for (int i=1;i<=n;i++){
            if (degrees[i]==n-1){
                res++;
            }
        }
        return res;
    }

    public static int check(int[][] relations,int n){
        int[][] flag=new int[n][n];
        for (int i=0;i<relations.length;i++){
            flag[relations[i][0]-1][relations[i][1]-1]=1;
            flag[i][i]=1;
        }
        change(relations,flag);
        int res=0;
        for (int i=0;i<n;i++){
            boolean isDaRean=true;
            for (int j=0;j<n;j++){
                if (flag[j][i]==0){
                    isDaRean=false;
                    break;
                }
            }
            if (isDaRean){
                res++;
            }
        }
        return res;
    }

    public static void change(int[][] relations,int[][] flag){
        int n=flag.length;
        int[] visited=new int[n];
        for (int i=0;i<n;i++){
            visited[i]=1;
            Queue<Integer> queue=new LinkedList<>();
            for (int j=0;j<n;j++){
                if (j!=i&&flag[i][j]==1){
                    queue.offer(j);
                }
            }
            while (!queue.isEmpty()){
                int person=queue.poll();
                if (visited[person]==1){
                    continue;
                }
                flag[i][person]=1;
                visited[person]=1;
                for (int j=0;j<n;j++){
                    if (j!=i&&flag[person][j]==1){
                        queue.offer(j);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] relations=new int[m][2];
        for (int i=0;i<m;i++){
            relations[i][0]=sc.nextInt();
            relations[i][1]=sc.nextInt();
        }
        System.out.println(check2(relations,n));
    }
}
