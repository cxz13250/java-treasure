package employee;

import java.util.Scanner;

/**
 * @Author ROKG
 * @Description 找某个用户最可能的好友
 * @Date: Created in 下午7:00 2018/8/5
 * @Modified By:
 */
public class PingDuoDuo3 {

    public static int check(String[] ss,int target){
        String targetFriends=ss[target];
        int maxFriends=0;
        int res=-1;
        for (int i=0;i<ss.length;i++){
            if (i==target||targetFriends.indexOf(i)>0){
                continue;
            }
            String compare=ss[i];
            int friends=compareStr(targetFriends,compare);
            if (friends>maxFriends){
                maxFriends=friends;
                res=i;
            }
        }
        return res;
    }

    public static int compareStr(String s1,String s2){
        String[] cc=s1.split(" ");
        int res=0;
        for (String s:cc){
            if (s2.indexOf(s)>0){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int all=sc.nextInt();
        int target=sc.nextInt();
        sc.nextLine();
        String[] ss=new String[all];
        for (int i=0;i<all;i++){
            ss[i]=sc.nextLine();
        }
        System.out.println(check(ss,target));
    }
}
