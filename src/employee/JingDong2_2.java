package employee;

import java.util.*;

/**
 * @Author ROKG
 * @Description 完全多部图
 * 给定一张包含N个点、M条边的无向图，每条边连接两个不同的点，且任意两点间最多只有一条边。对于这样的简单无向图，如果能将所有点划分成若干个集合，
 * 使得任意两个同一集合内的点之间没有边相连，任意两个不同集合内的点之间有边相连，则称该图为完全多部图。现在你需要判断给定的图是否为完全多部图。
 * @Date: Created in 下午7:27 2018/9/9
 * @Modified By:
 */
public class JingDong2_2 {

    public static int check(int[][] nums){
        List<int[]> list=new ArrayList<>();
        for (int[] n:nums){
            list.add(n);
        }
        int n=nums.length;
        int res=0;
        Collections.sort(list,(a,b) -> {
            if (a[0]!=b[0]){
                return a[0]-b[0];
            }else if (a[1]!=b[1]){
                return a[1]-b[1];
            }else {
                return a[2]-b[2];
            }
        });
        for (int i=0;i<n;i++){
            int[] num1=list.get(i);
            for (int j=i+1;j<n;j++){
                int[] num2=list.get(j);
                if (!isValid(num1,num2)){
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    public static boolean isValid(int[] n1,int[] n2){
        if (n1[0]<n2[0]&&n1[1]<n2[1]&&n1[2]<n2[2]){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] nums=new int[n][3];
        for (int i=0;i<n;i++){
            nums[i][0]=sc.nextInt();
            nums[i][1]=sc.nextInt();
            nums[i][2]=sc.nextInt();
        }
        System.out.println(check(nums));
    }
}
