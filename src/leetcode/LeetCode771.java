package leetcode;

/**
 * @Author ROKG
 * @Description 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 * @Date: Created in 上午12:09 2018/8/9
 * @Modified By:
 */
public class LeetCode771 {

    public int numJewelsInStones(String J, String S) {
        int count=0;
        if (J==null||J.length()==0||S==null||S.length()==0){
            return count;
        }
        int temp[]=new int[58];
        for (int i=0;i<J.length();i++){
            temp[J.charAt(i)-'A']++;
        }
        for (int i=0;i<S.length();i++){
            if (temp[S.charAt(i)-'A']>0){
                count++;
            }
        }
        return count;
    }
}
