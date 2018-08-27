package leetcode;

/**
 * @Author ROKG
 * @Description 报数序列是指一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。
 * @Date: Created in 下午10:23 2018/4/25
 * @Modified By:
 */
public class LeetCode38 {

    public static String countAndSay(int n) {
        String str="1";
        if(n==1){
            return str;
        }
        while (n>1){
            str=check(str);
            n--;
        }
        return str;
    }

    public static String check(String str){
        char[] cc=str.toCharArray();
        StringBuilder sb=new StringBuilder();
        int i=0;
        int count;
        while(i<cc.length){
            count=1;
            if(i+1<cc.length&&cc[i]==cc[i+1]){
                while(i+1<cc.length&&cc[i]==cc[i+1]){
                    count++;
                    i++;
                }
                sb.append(String.valueOf(count));
                sb.append(cc[i]);
                i++;
            }
            else {
                sb.append('1');
                sb.append(cc[i]);
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(sort("11"));
//        System.out.println(sort("21"));
        System.out.println(countAndSay(4));
    }
}
