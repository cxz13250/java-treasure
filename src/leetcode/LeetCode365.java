package leetcode;

/**
 * @Author ROKG
 * @Description 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 * 解法：判断z是否为x与y的最大公约数的倍数
 * @Date: Created in 下午5:31 2018/5/7
 * @Modified By:
 */
public class LeetCode365 {

    public static boolean canMeasureWater(int x, int y, int z) {
        if(z==0){
            return true;
        }else if(x==0||y==0){
            return false;
        }else if(x+y<z){
            return false;
        }
        int m=Math.max(x,y);
        int n=Math.min(x,y);
        x=m;
        y=n;
        int temp=0;
        do{
            temp=x%y;
            x=y;
            y=temp;
        }while(temp!=0);
        return z%x==0;
    }

    public static void main(String[] args) {
        System.out.println(canMeasureWater(3,5,4));
    }
}
