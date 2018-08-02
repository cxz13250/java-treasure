package leetcode;


import java.util.Arrays;

/**
 * @Author ROKG
 * @Description 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * @Date: Created in 下午3:45 2018/7/16
 * @Modified By:
 */

public class LeetCode670 {

    public int maximumSwap(int num) {
        String primary=String.valueOf(num);
        char[] cc=primary.toCharArray();
        Arrays.sort(cc);
        String newString=new StringBuilder(new String(cc)).reverse().toString();
        if (primary.equals(newString)){
            return num;
        }
        int len=primary.length();
        char[] cp=primary.toCharArray();
        cc=newString.toCharArray();
        int i;
        for (i=0;i<len;i++){
            if (cp[i]==cc[i]){
                continue;
            }else if (cp[i]<cc[i]){
                break;
            }
        }
        char flag=cp[i];
        char target=cc[i];
        cp[i]=target;
        for (int j=len-1;j>-1;j--){
            if (cp[j]==target){
                cp[j]=flag;
                break;
            }
        }
        return Integer.valueOf(new String(cp));
    }

    //从最高位开始，从9开始依次检验这位之后是否存在比这位上数字大的数字，有则交换
    public int maximumSwap2(int num) {
        char[] cc=String.valueOf(num).toCharArray();
        int[] nums=new int[10];
        for (int i=0;i<cc.length;i++){
            nums[cc[i]-'0']=i;
        }
        for (int i=0;i<cc.length;i++){
            for (int j=9;j>cc[i]-'0';j--){
                if (nums[j]>i){
                    char temp=cc[i];
                    cc[i]=cc[nums[j]];
                    cc[nums[j]]=temp;
                    return Integer.valueOf(new String(cc));
                }
            }
        }
        return num;
    }
}
