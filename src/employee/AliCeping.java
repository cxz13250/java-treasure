package employee;

import java.util.*;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午9:38 2018/8/13
 * @Modified By:
 */
public class AliCeping {

    public static int getMinDistance(int[][] pos){
        List<Integer> set=new ArrayList<>();
        return check(pos,0,0,0,set);
    }

    public static int check(int[][] pos,int curX,int curY,int index,List<Integer> set){
        if (index==pos.length){
            return curX+curY;
        }
        int res=Integer.MAX_VALUE;
        for (int i=0;i<pos.length;i++){
            if (set.contains(i)){
                continue;
            }
            set.add(i);
            int[] temp=pos[i];
            int dist=Math.abs(curX-temp[0])+Math.abs(curY-temp[1])+check(pos,temp[0],temp[1],index+1,set);
            set.remove(set.size()-1);
            res=Math.min(res,dist);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] pos=new int[n][2];
        for (int i=0;i<n;i++){
            String s=sc.next();
            String nums[]=s.split(",");
            pos[i][0]=Integer.parseInt(nums[0]);
            pos[i][1]=Integer.parseInt(nums[1]);
        }
        System.out.println(getMinDistance(pos));
    }
}
