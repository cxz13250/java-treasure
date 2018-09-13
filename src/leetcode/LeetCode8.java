package leetcode;

/**
 * @Author ROKG
 * @Description 实现 atoi，将字符串转为整数。
 * @Date: Created in 下午4:41 2018/4/14
 * @Modified By:
 */
public class LeetCode8 {

    public static int myAtoi(String str) {
        if (str == null || str.trim().length() == 0){
            return 0;
        }
        int sign = 1;
        char[] ch = str.toCharArray();
        int idx = 0;
        while (ch[idx] == ' '){
            idx ++;
        }
        if (ch[idx] == '-'){
            sign = -1;
            idx++;
        }
        else if (ch[idx] == '+'){
            idx++;
        }
        int sum = 0;
        while (idx < str.length()){
            int temp = ch[idx] - '0';
            if (temp > 9 || temp < 0){
                return sum * sign;
            }
            if (sum > Integer.MAX_VALUE / 10 ||
                    (sum == Integer.MAX_VALUE / 10 && temp > Integer.MAX_VALUE % 10)){
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            sum = sum * 10 + temp;
            idx ++;
        }
        return sum * sign;
    }

    public static int check(String str){
        int sum=0;
        char[] cc=str.toCharArray();
        boolean showNum=false;
        boolean showNotNum=false;
        int flag=1;
        for(int i=0;i<cc.length;i++){
            if(cc[i]==' '&&!showNotNum){
                if(!showNum) {
                    continue;
                }else {
                    showNotNum=true;
                    continue;
                }
            }
            if(isNumber(cc[i])){
                if(Math.abs(sum)>Integer.MAX_VALUE/10||(Math.abs(sum)==Integer.MAX_VALUE/10&&Math.abs(cc[i]-'0')>Integer.MAX_VALUE%10)){
                    return (flag==1) ?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
                showNum=true;
                sum=sum*10+cc[i]-'0';
            } else if(isOperate(cc[i])){
                if(showNum || showNotNum){
                    return sum*flag;
                }else {
                    showNotNum=true;
                    if (cc[i] == '-') {
                        flag=-1;
                    }
                }
            }else{
                return sum*flag;
            }
        }
        return sum*flag;
    }

    public static boolean isNumber(char c){
        if(c>='0'&&c<='9'){
            return true;
        }else {
            return false;
        }
    }

    public static boolean isOperate(char c){
        if(c=='+'||c=='-'){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s1="2147483648";
        System.out.println(check(s1));
        String s2="-2147483648";
        System.out.println(check(s2));
        String s3="123  456";
        System.out.println(check(s3));
        String s4="    010";
        System.out.println(check(s4));
    }
}
