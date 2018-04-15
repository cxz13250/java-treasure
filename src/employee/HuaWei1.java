package employee;

import java.util.*;

/**
 * @Author ROKG
 * @Description 华为笔试第1题，字符串按ASCII码输出，如："eeefgghh" 输出为"efgheghe"
 * @Date: Created in 下午7:08 2018/4/10
 * @Modified By:
 */
public class HuaWei1 {

    public char[] check(String str){
        char[] cc=str.toCharArray();
        char[] res=new char[cc.length];
        int[] temp=new int[128];
        int max=0;
        for(char c:cc){
            temp[c]++;
            if(temp[c]>max){
                max=temp[c];
            }
        }
        int l=0;
        for(int i=0;i<max;i++){
            for(int j=0;j<128;j++){
                if(temp[j]>0){
                    res[l]=(char)j;
                    temp[j]--;
                    l++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        HuaWei1 m=new HuaWei1();
        char[] result=m.check(str);
        System.out.println(String.valueOf(result));
    }
}
