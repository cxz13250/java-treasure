package leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午5:39 2023/11/5
 * @Modified By:
 */
public class Leet282_AddOperatorToExpression {

    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        dfs(num, target, 0, new StringBuilder(), 0, 0, res);
        return res;
    }

    /**
     *
     * @param pos 当前位置
     * @param expr 临时空间，记录字符串结果
     * @param sum 当前总值
     * @param mul 当前最后一个连续乘字符串计算结果
     */
    private void dfs(String num, int target, int pos, StringBuilder expr, long sum, long mul, List<String> res) {
        if (pos == num.length()) {
            if (sum == target) {
                res.add(expr.toString());
            }
            return;
        }
        int length = expr.length();
        if (pos > 0) {
            expr.append('0');
        }
        long val = 0;
        // 关键点4 num[pos]为0时，只能作为单独的数字运算，或者跟在前面非零的数字后面，但是不能为先导0
        // 如105 可以是1+0+5，或者10+5，但是不能是1+05
        for (int i = pos; i < num.length() && (i == pos || num.charAt(pos) != '0'); i++) {
            val = val * 10 + num.charAt(i) - '0';
            expr.append(num.charAt(i));
            if (pos == 0) {
                dfs(num, target, i + 1, expr, val, val, res);
            } else {
                // 关键点1 运算符插在当前数字前面
                // 关键点2 +时，当前表达式总值为 sum + val, 当前后一个连续乘计算结果为 val
                //        -时，当前表达式总值为 sum - val, 当前后一个连续乘计算结果为 -val
                //        *时，当前表达式总值为 sum - val + val * mul, 当前后一个连续乘计算结果为 mul * val
                expr.setCharAt(length, '+');
                dfs(num, target, i + 1, expr, sum + val, val, res);
                expr.setCharAt(length, '-');
                dfs(num, target, i + 1, expr, sum - val, -val, res);
                expr.setCharAt(length, '*');
                dfs(num, target, i + 1, expr, sum - mul + mul * val, mul * val, res);
            }
        }
        // 关键点3 设置长度为初始值，回溯到上一步
        expr.setLength(length);
    }

    public static void main(String[] args) {
//        System.out.println(new Leet282_AddOperatorToExpression().addOperators("123", 6));
//        System.out.println(new Leet282_AddOperatorToExpression().addOperators("232", 8));
//        System.out.println(new Leet282_AddOperatorToExpression().addOperators("3456237490", 9191));
        System.out.println(new Leet282_AddOperatorToExpression().addOperators("105", 5));
    }
}
