package leetcode;

/**
 * @Author ROKG
 * @Description 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 * @Date: Created in 下午1:13 2018/5/5
 * @Modified By:
 */
public class LeetCode788 {

    public int rotatedDigits(int N) {
        int result=0;
        for (int i=1;i<=N;i++){
            if(check(i)){
                result++;
            }
        }
        return result;
    }

    public boolean check(int n){
        char[] cc=String.valueOf(n).toCharArray();
        int sum=0;
        for (int i=0;i<cc.length;i++){
            int temp=cc[i]-'0';
            if(temp==3||temp==4||temp==7){
                return false;
            }
            sum=sum*10+change(temp);
        }
        return !(sum==n);
    }

    public int change(int n){
        switch (n) {
            case 1: return 1;
            case 2: return 5;
            case 5: return 2;
            case 6: return 9;
            case 8: return 8;
            case 9: return 6;
            default: return 0;
        }
    }
}
