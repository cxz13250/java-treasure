package leetcode;

import java.util.Arrays;

/**
 * @Author ROKG
 * @Description 给定一个整数 n ，你需要找到与它最近的回文数（不包括自身）。
 * “最近的”定义为两个整数差的绝对值最小。
 * @Date: Created in 下午9:36 2018/8/17
 * @Modified By: **
 */
public class LeetCode564 {

    // 分别找比n大和小的两个回文数
    // 找的过程：复制前一半的数字，拷贝到后一半中，然后检验是否比原数大（小），
    // 若不满足，将前一半的数字从后往前一次加1（减1），注意进位，减的时候注意最后开头数字为0的情况
    public String nearestPalindromic(String n) {
        Long num=Long.valueOf(n);
        Long big=findBig(String.valueOf(num+1));
        Long small=findSmall(String.valueOf(num-1));
        return (big-num)<(num-small)?String.valueOf(big):String.valueOf(small);
    }

    public Long findBig(String num){
        char[] cc=num.toCharArray();
        char[] t= Arrays.copyOf(cc,cc.length);
        for (int i=0;i<cc.length/2;i++){
            t[cc.length-i-1]=cc[i];
        }
        for (int i=0;i<t.length;i++){
            if (cc[i]<t[i]){
                return Long.valueOf(String.valueOf(t));
            }else if (cc[i]>t[i]){
                for (int j=(cc.length-1)/2;j>=0;j--){
                    if (++t[j]>'9'){
                        t[j]='0';
                    }else {
                        break;
                    }
                }
                for (int k=0;k<cc.length/2;k++){
                    t[cc.length-k-1]=t[k];
                }
                return Long.parseLong(String.valueOf(t));
            }
        }
        return Long.parseLong(String.valueOf(t));
    }

    public Long findSmall(String num){
        char[] cc=num.toCharArray();
        char[] t= Arrays.copyOf(cc,cc.length);
        for (int i=0;i<cc.length/2;i++){
            t[cc.length-i-1]=cc[i];
        }
        for (int i=0;i<t.length;i++){
            if (cc[i]>t[i]){
                return Long.valueOf(String.valueOf(t));
            }else if (cc[i]<t[i]){
                for (int j=(cc.length-1)/2;j>=0;j--){
                    if (--t[j]<'0'){
                        t[j]='9';
                    }else {
                        break;
                    }
                }
                if (t[0]=='0'){   //减1处理完了之后开头数字变为0，则降位数，各位全取9
                    char[] t2=new char[cc.length-1];
                    Arrays.fill(t2,'9');
                    return Long.parseLong(String.valueOf(t2));
                }
                for (int k=0;k<cc.length/2;k++){
                    t[cc.length-k-1]=t[k];
                }
                return Long.parseLong(String.valueOf(t));
            }
        }
        return Long.parseLong(String.valueOf(t));
    }

    public static void main(String[] args) {
        System.out.println(check());
    }

    public static int check(){
        int x=0;
        try{
            x=1;
            return x;
        } catch (Exception e){
            x=2;
            return x;
        } finally {
            x=3;
            System.out.println("asd");
        }
    }

}
