package leetcode;

/**
 * @Author ROKG
 * @Description 求解一个给定的方程，将x以字符串"x=#value"的形式返回。该方程仅包含'+'，' - '操作，变量 x 和其对应系数。
 * 如果方程没有解，请返回“No solution”。
 * 如果方程有无限解，则返回“Infinite solutions”。
 * 如果方程中只有一个解，要保证返回值 x 是一个整数。
 * @Date: Created in 下午11:11 2018/9/3
 * @Modified By: *
 */
public class LeetCode640 {

    // 先将字符串按等号分为左右两个字符串
    // 一次获取左右两个表达式的系数和常数
    // x=（右常数-左常数）/（左系数-右系数）
    public String solveEquation(String equation) {
        String[] ss=equation.split("=");
        int[] nums1=check(ss[0]);
        int[] nums2=check(ss[1]);
        int ratio=nums1[0]-nums2[0];
        int constant=nums2[1]-nums1[1];
        if (ratio==0&&constant!=0){
            return "No solution";
        }
        if (ratio==0&&constant==0){
            return "Infinite solutions";
        }
        return "x="+constant/ratio;
    }

    // res[0] 为系数和
    // res[1] 为常数和
    public int[] check(String s){
        int ratio=0;
        int constant=0;
        int start=0;
        int end=1;
        char operator='+';
        if (s.charAt(0)=='-'){
            operator='-';
            start=1;
            end=2;
        }
        while (end<=s.length()){
            while (end<s.length()&&s.charAt(end)!='+'&&s.charAt(end)!='-'){
                end++;
            }
            String temp=s.substring(start,end);
            if (temp.indexOf('x')>-1){  //系数
                String num=temp.substring(0,temp.indexOf('x'));
                if (!num.equals("")){
                    if (operator=='+'){
                        ratio+=Integer.valueOf(num);
                    } else {
                        ratio-=Integer.valueOf(num);
                    }
                }
            }else {  //常数
                int num=Integer.valueOf(temp);
                if (operator=='+'){
                    constant+=num;
                }else {
                    constant-=num;
                }
            }
            if (end<s.length()){
                operator=s.charAt(end);
            }
            start=end+1;
            end=start+1;
        }
        return new int[]{ratio,constant};
    }

    public static void main(String[] args) {
        LeetCode640 l=new LeetCode640();
        System.out.println(l.solveEquation("x+5-3+x=6+x-2"));
    }
}
