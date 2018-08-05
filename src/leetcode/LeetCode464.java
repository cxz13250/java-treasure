package leetcode;

import java.util.HashMap;

/**
 * @Author ROKG
 * @Description 在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和达到 100 的玩家，即为胜者。
 * 如果我们将游戏规则改为 “玩家不能重复使用整数” 呢？
 * 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
 * @Date: Created in 上午11:19 2018/8/5
 * @Modified By: *
 */
public class LeetCode464 {

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger>=desiredTotal){
            return true;
        }
        if ((1+maxChoosableInteger)*maxChoosableInteger/2<desiredTotal){
            return false;
        }
        char[] flag=new char[maxChoosableInteger];
        for (int i=0;i<flag.length;i++){
            flag[i]='0';
        }
        return check(desiredTotal,flag,new HashMap<String, Boolean>());
    }

    public boolean check(int target,char[] flag,HashMap<String,Boolean> map){
        String s=String.valueOf(flag);
        if (map.containsKey(s)){
            return map.get(s);
        }
        for (int i=0;i<flag.length;i++){
            if (flag[i]=='0'){
                flag[i]='1';
                if (target<=i+1 || !check(target-i-1,flag,map)){
                    map.put(s,true);
                    flag[i]='0';
                    return true;
                }
                flag[i]='0';
            }
        }
        map.put(s,false);
        return false;
    }

    public static void main(String[] args) {
        LeetCode464 l=new LeetCode464();
        System.out.println(l.canIWin(10,11));
    }
}
