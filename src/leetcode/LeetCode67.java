package leetcode;

/**
 * @Author ROKG
 * @Description 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * @Date: Created in 下午9:32 2018/4/30
 * @Modified By:
 */
public class LeetCode67 {

    public String addBinary(String a, String b) {
        if(a.length()<b.length()){
            return addBinary(b,a);
        }
        char[] ca=a.toCharArray();
        char[] cb=b.toCharArray();
        StringBuilder sb=new StringBuilder();
        int add=0;
        int temp=0;
        for(int i=ca.length-1;i>=0;i--){
            int j=i-ca.length+cb.length;
            int vala=ca[i]-'0';
            int valb=j<0?0:cb[j]-'0';
            temp=(vala+valb+add)%2;
            add=(vala+valb+add)/2;
            sb.append(String.valueOf(temp));
        }
        if(add==1){
            sb.append(add);
        }
        return sb.reverse().toString();
    }
}
