package leetcode;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午2:04 2018/5/7
 * @Modified By: *
 */
public class LeetCode372 {

    public boolean isZero(int[] b){
        for (int i:b){
            if(i>0){
                return false;
            }
        }
        return true;
    }

    public int superPow(int a, int[] b) {
        if (isZero(b)){
            return 1;
        }
        a=a%1337;
        boolean flag=b[b.length-1]%2==0;
        int temp=0;
        for (int i=0;i<b.length;i++){
            b[i]=temp*10+b[i];
            temp=b[i]%2;
            b[i]/=2;
        }
        int result=superPow(a,b);
        result%=1337;
        result*=result;
        result%=1337;
        if (!flag){
            result*=a;
            result%=1337;
        }
        return result;
    }

    public static void main(String[] args) {
    }
}
