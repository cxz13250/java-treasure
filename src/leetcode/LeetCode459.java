package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * @Date: Created in 下午4:03 2018/5/15
 * @Modified By:
 */
public class LeetCode459 {

    public boolean repeatedSubstringPattern(String s) {
        int len=s.length();
        for (int i=1;i<=len/2;i++){
            if (len%i==0){
                String temp=s.substring(0,i);
                StringBuilder sb=new StringBuilder();
                for (int j=0;j<len/i;j++){
                    sb.append(temp);
                }
                if (sb.toString().equals(s)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
    }
}
