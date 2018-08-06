package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个正整数 n，返回长度为 n 的所有可被视为可奖励的出勤记录的数量。 答案可能非常大，你只需返回结果mod 109 + 7的值。
 * 学生出勤记录是只包含以下三个字符的字符串：
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * 如果记录不包含多于一个'A'（缺勤）或超过两个连续的'L'（迟到），则该记录被视为可奖励的。
 * @Date: Created in 2018/8/3
 * @Modified By: *
 */
public class LeetCode552 {

    // P[i]表示以P结尾的长度为i的串有多少个，P[i]=P[i-1]+L[i-1]+A[i-1]
    // L[i]=P[i-1]+A[i-1]+P[i-2]+A[i-2]
    // A[i]=P[i-1]中不带A的+L[i-1]中不带A的，
    public int checkRecord(int n) {
        int[] P=new int[n];
        int[] A=new int[n];
        int[] L=new int[n];
        int m=1000000007;
        P[0]=1;
        A[0]=1;
        L[0]=1;
        if (n>1) {
            A[1] = 2;
            L[1] = 3;
        }
        if (n>2){
            A[2] = 4;
        }
        for (int i=1;i<n;i++){
            P[i]=((L[i-1]+P[i-1])%m+A[i-1])%m;
            if (i>1){
                L[i]=((A[i-1]+P[i-1])%m+(A[i-2]+P[i-2])%m)%m;
            }
            if (i>2){
                A[i]=((A[i-1]+A[i-2])%m+A[i-3])%m;
            }
        }
        return ((P[n-1]+A[n-1])%m+L[n-1])%m;
    }

    public int checkRecord2(int n) {
        int[] P=new int[n+1];
        int[] PorL=new int[n+1];
        int m=1000000007;
        P[0]=1;
        PorL[0]=1;
        PorL[1]=2;
        for (int i=1;i<=n;i++){
            P[i]=PorL[i-1];
            if (i>1){
                PorL[i]=(P[i]+P[i-1]+P[i-2])%m;
            }
        }
        int res=PorL[n];
        for (int i=1;i<n;i++){
            int t=(PorL[i]*PorL[n-i-1])%m;
            res=(res+t)%m;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode552 l=new LeetCode552();
        System.out.println(l.checkRecord2(100));
    }
}
