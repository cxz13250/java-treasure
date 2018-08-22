package leetcode;

/**
 * @Author ROKG
 * @Description 在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
 * 至少有一个空座位，且至少有一人坐在座位上。
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 * 返回他到离他最近的人的最大距离。
 * @Date: Created in 下午12:13 2018/8/19
 * @Modified By:
 */
public class LeetCode849 {

    public static int maxDistToClosest(int[] seats) {
        int res=0;
        for (int i=0;i<seats.length;i++){
            if (seats[i]==1){
                continue;
            }
            int j=i-1,k=i+1;
            while (j>=0&&seats[j]==0){
                j--;
            }
            while (k<seats.length&&seats[k]==0){
                k++;
            }
            int left = i - j;
            int right = k - i;
            if (i==0){
                res=Math.max(res,right);
            }else if (i==seats.length-1){
                res=Math.max(res,left);
            }else {
                res = Math.max(res, Math.min(left, right));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxDistToClosest(new int[]{1,0,0,0}));
    }
}
