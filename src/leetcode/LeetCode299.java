package leetcode;

/**
 * @Author ROKG
 * @Description 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。
 * @Date: Created in 下午1:58 2018/6/10
 * @Modified By:
 */
public class LeetCode299 {

    public static String getHint(String secret, String guess) {
        int[] numsS=new int[10];
        int[] numsG=new int[10];
        int len=secret.length();
        int countA=0;
        int countB=0;
        for (int i=0;i<len;i++){
            char a=secret.charAt(i);
            char b=guess.charAt(i);
            if (a==b){
                countA++;
            }else {
                numsS[a-'0']++;
                numsG[b-'0']++;
            }
        }
        for (int i=0;i<10;i++){
            countB+=Math.min(numsG[i],numsS[i]);
        }
        StringBuilder sb=new StringBuilder();
        sb.append(countA);
        sb.append("A");
        sb.append(countB);
        sb.append("B");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getHint("1807","7810"));
    }
}
