package leetcode;

/**
 * @Author ROKG
 * @Description 数组跳跃
 * @Date: Created in 下午12:35 2018/4/15
 * @Modified By:
 */
public class LeetCode45 {

    public static int jump(int a[]){
        int sum=0;   //跳跃次数
        int last=0;   //上一跳可到的最远距离
        int current=0;   //这一条能到的最远距离
        for(int i=0;i<a.length;i++){
            if(i>last){
                last=current;
                sum++;
            }
            current=Math.max(current,i+a[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int a[]={2,3,1,1,4};
        System.out.println(jump(a));
    }
}
