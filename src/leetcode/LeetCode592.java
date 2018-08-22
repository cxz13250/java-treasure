package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个表示分数加减运算表达式的字符串，你需要返回一个字符串形式的计算结果。 这个结果应该是不可约分的分数，即最简分数。
 * 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。
 * @Date: Created in 下午5:58 2018/8/18
 * @Modified By: *
 */
public class LeetCode592 {

    private static char plus = '+';

    private static char minus = '-';

    private static String divide = "/";

    public String fractionAddition(String expression) {
        if (expression==null||expression.length()==0){
            return expression;
        }
        if (expression.charAt(0)!=minus){
            expression=plus+expression;
        }
        List<String> list=new ArrayList<>();
        int i=0;
        while (i<expression.length()){
            int end=i+1;
            while (end<expression.length()&&expression.charAt(end)!=minus&&expression.charAt(end)!=plus){
                end++;
            }
            list.add(expression.substring(i,end));
            i=end;
        }
        String p=list.get(0);
        for (int j=1;j<list.size();j++){
            p=operate(p,list.get(j));
        }
        if (p.charAt(0)==plus){
            return p.substring(1);
        }else {
            return p;
        }
    }

    public String operate(String s1,String s2){
        char c1=s1.charAt(0);
        char c2=s2.charAt(0);
        String[] ss1=s1.split("/");
        String[] ss2=s2.split("/");
        int num1=Integer.valueOf(ss1[0].substring(1));
        int num2=Integer.valueOf(ss1[1]);
        int num3=Integer.valueOf(ss2[0].substring(1));
        int num4=Integer.valueOf(ss2[1]);
        int num=getMultiple(num2,num4);
        num1=num/num2*num1;
        num3=num/num4*num3;
        int res=0;
        if (c1==plus&&c2==plus){
            res=num1+num3;
        }else if (c1==minus&&c2==minus){
            res=-num1-num3;
        }else if (c1==minus&&c2==plus){
            res=-num1+num3;
        }else {
            res=num1-num3;
        }
        if (res==0){
            return "+0/1";
        }else if (res>0){
            return reduce(String.valueOf(plus)+res+divide+num);
        }
        return reduce(res+divide+num);
    }

    // 最小公倍数
    public int getMultiple(int x,int y){
        if (x==y){
            return x;
        }
        return x*y/getDivisor(x,y);
    }

    // 最大公约数
    public int getDivisor(int x,int y){
        int z = y;
        while(x%y!=0)
        {
            z = x%y;
            x = y;
            y = z;
        }
        return z;
    }

    public String reduce(String s){
        String[] ss=s.split(divide);
        int num1=Integer.valueOf(ss[0].substring(1));
        int num2=Integer.valueOf(ss[1]);
        int temp=getDivisor(num1,num2);
        num1/=temp;
        num2/=temp;
        return ss[0].substring(0,1)+num1+divide+num2;
    }

    public static void main(String[] args) {
        LeetCode592 l=new LeetCode592();
        System.out.println(l.fractionAddition("-1/2+1/2+1/3"));
    }
}
