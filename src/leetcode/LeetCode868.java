package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。
 * 如果没有两个连续的 1，返回 0 。
 * @Date: Created in 下午1:25 2018/7/22
 * @Modified By:
 */
public class LeetCode868 {

    public int binaryGap(int N) {
        String s=Integer.toBinaryString(N);
        int res=0;
        int pre=-1;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='1'){
                if (pre==-1){
                    pre=i;
                }else {
                    res=Math.max(res,i-pre);
                    pre=i;
                }
            }
        }
        return res;
    }
}
