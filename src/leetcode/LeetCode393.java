package leetcode;

/**
 * @Author ROKG
 * @Description UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：
 * 对于 1 字节的字符，字节的第一位设为0，后面7位为这个符号的unicode码。
 * 对于 n 字节的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为0，后面字节的前两位一律设为10。剩下的没有提及的二进制位，全部为这个符号的unicode码。
 * @Date: Created in 上午12:02 2018/7/24
 * @Modified By:
 */
public class LeetCode393 {

    // 一个字节最大为 01111111 即127
    // 两个字节最大为 11011111 即223
    // 三个字节最大为 11101111 即239
    // 四个字节最大为 11110111 即247
    // 多字节后续字节最大为 10111111 即191，最小为 10000000 即128
    public boolean validUtf8(int[] data) {
        int len=data.length;
        int count=0;
        int i=0;
        while (i<len){
            if (count>0){
                if (data[i]<192&&data[i]>=128){
                    count--;
                }else {
                    return false;
                }
            }else if (data[i]>=248){
                return false;
            }else if (data[i]>=240){
                count=3;
            }else if (data[i]>=224){
                count=2;
            }else if (data[i]>=192){
                count=1;
            }else if (data[i]>=128){
                return false;
            }
            i++;
        }
        return count==0;
    }
}
