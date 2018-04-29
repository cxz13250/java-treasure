package leetcode;

/**
 * @Author ROKG
 * @Description 一个强密码应满足以下所有条件：由至少6个，至多20个字符组成。至少包含一个小写字母，一个大写字母，和一个数字。同一字符不能连续出现三次
 * @Date: Created in 下午8:35 2018/4/27
 * @Modified By: 尚未解决
 */
public class LeetCode420 {

    public static int strongPasswordChecker(String s) {
        boolean hasLower=false;
        boolean hasUpper=false;
        boolean hasNumber=false;
        int add=0;
        int del=0;
        int change=0;
        int[] temp=new int[128];
        char cc[]=s.toCharArray();
        for(int i=0;i<cc.length;i++){
            if(cc[i]>='a'&&cc[i]<='z'){
                hasLower=true;
            }else if(cc[i]>='A'&&cc[i]<='Z'){
                hasUpper=true;
            }else if(cc[i]>='0'&&cc[i]<='9'){
                hasNumber=true;
            }
            int p=0;
            while(i<cc.length-1&&cc[i]==cc[i+1]){
                temp[cc[i]]++;
                p++;
                i++;
            }
            change+=(p+1)/3;
        }
        if(s.length()<6){
            add+=6-s.length();
        }
        if(s.length()>20){
            del=s.length()-20;
        }
        if(hasLower&&hasNumber&&hasUpper&&change==0&&add==0&&del==0){
            return 0;
        }else {
            int p=0;
            if(!hasLower){
                p++;
            }
            if(!hasNumber){
                p++;
            }
            if(!hasUpper){
                p++;
            }
            if(s.length()<20) {
                if(change<add){
                    return add;
                }else {
                    return change>p?change:p;
                }
            }else{
                if(change>del&&change>p){
                    return change;
                }else{
                    return del>change?del+p:change+p;
                }
            }
        }
    }

    public static void main(String[] args) {
        String str="1234567890123456Baaaaa";
        System.out.println(strongPasswordChecker(str));
    }
}
