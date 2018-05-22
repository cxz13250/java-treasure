package leetcode;

/**
 * @Author ROKG
 * @Description 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 * @Date: Created in 下午12:13 2018/5/22
 * @Modified By:
 */
public class LeetCode717 {

    public boolean isOneBitCharacter(int[] bits) {
        int flag=0;
        int i=0;
        while (i<bits.length){
            if (bits[i]==0){
                i++;
                flag=1;
            }else if (bits[i]==1){
                i+=2;
                flag=2;
            }
        }
        return flag==1;
    }
}
