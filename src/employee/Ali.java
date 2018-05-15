package employee;

import java.util.*;

/**
 * @Author ROKG
 * @Description 阿里巴巴客服管理员管理着n个客服小组，他需要为每一组安排客服24小时值班。为简单起见，假设每组只有2个客服，一天只需要1个客服上班，并且一些客服由于某些原因不能在同一天上班。
 * 我们已经对客服进行了编号，第i（i>=1&&i<=n）个组的客服编号为2*i-1和2*i。并且知道了m种如下约束关系：客服编号a和客服编号b不能一起上班。
 * 管理员需要聪明的你帮忙判断今天是否存在可行的方案，既满足m条约束关系，又能让每个组都有1个客服上班。
 * 输入：n(代表有n个组）
 * m(m条约束关系），接下来会有m行
 * a,b(代表a，b两位客服标号不能同时上班)
 * 输出：判断有没有可行方案：如果不可行输出no；如果可行输出yes
 * @Date: Created in 下午8:02 2018/5/11
 * @Modified By:
 */
public class Ali {
    static Map<Integer,List<Integer>> map=new HashMap<>();

    public static boolean check(int n,int m,int[][] nums){
        for (int i=0;i<m;i++){
            if (!map.containsKey(nums[i][0])) {
                List<Integer> list=new ArrayList<>();
                list.add(nums[i][1]);
                map.put(nums[i][0], list);
            }else {
                List<Integer> list=map.get(nums[0]);
                list.add(nums[i][1]);
                map.put(nums[i][0],list);
            }
            if (!map.containsKey(nums[i][1])) {
                List<Integer> list=new ArrayList<>();
                list.add(nums[i][0]);
                map.put(nums[i][1], list);
            }else {
                List<Integer> list=map.get(nums[1]);
                list.add(nums[i][0]);
                map.put(nums[i][1],list);
            }
        }
        for (List list:map.values()){
            if (list.size()>n-1){
                return false;
            }
        }
        List<Integer> list=new ArrayList<>();
        return choose(1,n,list);
    }

    public static boolean choose(int num,int n,List<Integer> list){
        if (num>n) {
            return true;
        }
        boolean temp1=false,temp2=true;
        if (test(2*num-1,list)) {
            list.add(2 * num - 1);
            temp1 = choose(num + 1, n, list);
            list.remove(list.size() - 1);
        }
        if (test(2*num,list)) {
            list.add(2 * num);
            temp2 = choose(num + 1, n, list);
            list.remove(list.size() - 1);
        }
        return temp1||temp2;
    }

    public static boolean test(int n,List<Integer> list){
        List<Integer> integers=map.get(n);
        for (Integer i:list){
            if (integers.contains(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] nums=new int[m][2];
        for (int i=0;i<m;i++){
            String temp=sc.next();
            String[] strings=temp.split(",");
            for (int j=0;j<2;j++){
                nums[i][j]=Integer.valueOf(strings[j]);
            }
        }
        System.out.println(check(n,m,nums)==true?"yes":"no");
    }
}
