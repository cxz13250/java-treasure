package leetcode;

/**
 * @Author ROKG
 * @Description 初始时有 n 个灯泡关闭。 第 1 轮，你打开所有的灯泡。 第 2 轮，每两个灯泡你关闭一次。
 * 第 3 轮，每三个灯泡切换一次开关（如果关闭则开启，如果开启则关闭）。第 i 轮，每 i 个灯泡切换一次开关。
 * 对于第 n 轮，你只切换最后一个灯泡的开关。 找出 n 轮后有多少个亮着的灯泡。
 * @Date: Created in 上午11:41 2018/7/7
 * @Modified By: *
 */
public class LeetCode319 {

    public int bulbSwitch(int n) {
        boolean[] lights=new boolean[n];
        for (int i=1;i<=n;i++){
            for (int j=0;j<n;j++){
                if ((j+1)%i==0){
                    lights[j]=!lights[j];
                }
            }
        }
        int result=0;
        for (int i=0;i<n;i++){
            if (lights[i]){
                result++;
            }
        }
        return result;
    }

    //灯泡开关次数=数的约数个数，灯泡亮着=该灯泡下标的约数个数是奇数=下标是完全平方数
    //最终亮着灯泡数=0到n之间有多少个完全平方数
    public int bulbSwitch2(int n){
        return (int)Math.sqrt(n);
    }
}
