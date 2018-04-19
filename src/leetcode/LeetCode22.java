package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * @Date: Created in 下午7:35 2018/4/18
 * @Modified By:
 */
public class LeetCode22 {

    public static List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        generateOneByOne("",result,n,n);
        return result;
    }

    public static void generateOneByOne(String sublist, List<String> list, int left, int right) {
        if (left > right) {
            return;
        }

        if (left > 0) {
            generateOneByOne(sublist + "(", list, left - 1, right);
        }

        if (right > 0) {
            generateOneByOne(sublist + ")", list, left, right - 1);
        }

        if (left == 0 && right == 0) {
            list.add(sublist);
            return;
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
