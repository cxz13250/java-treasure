package leetcode;

/**
 * @Author ROKG
 * @Description 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
 * @Date: Created in 下午11:16 2020/6/18
 * @Modified By:
 */
public class LeetCode1010 {

    public int numPairsDivisibleBy60(int[] time) {
        int[] flag = new int[60];
        int count=0;
        for (int i:time){
            i%=60;
            if(i!=0){
                count+=flag[60-i];
            }else{
                count+=flag[i];
            }
            flag[i]++;
        }
        return count;
    }
}
