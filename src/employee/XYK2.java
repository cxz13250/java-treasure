package employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午7:46 2018/5/7
 * @Modified By:
 */
public class XYK2 {

    public static String check(char[] cc){
        if(cc.length==0){
            return "";
        }
        List<Character> R=new ArrayList<>();
        List<Character> G=new ArrayList<>();
        List<Character> B=new ArrayList<>();
        for (char c:cc){
            if (c=='R'){
                R.add(c);
            }else if(c=='G'){
                G.add(c);
            }else if(c=='B'){
                B.add(c);
            }
        }
        R.addAll(G);
        R.addAll(B);
        StringBuilder sb=new StringBuilder();
        for (Character c:R){
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        System.out.println(check(str.toCharArray()));
    }
}
