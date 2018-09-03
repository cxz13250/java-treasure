package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。
 * 我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。
 * 山羊拉丁文的规则如下：
 * 如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
 * 例如，单词"apple"变为"applema"。
 * 如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * 例如，单词"goat"变为"oatgma"。
 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
 * 例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
 * 返回将 S 转换为山羊拉丁文后的句子。
 * @Date: Created in 2018/9/3
 * @Modified By:
 */
public class LeetCode824 {

    public String toGoatLatin(String S) {
        StringBuilder sb=new StringBuilder();
        String[] ss=S.split(" ");
        for (int i=0;i<ss.length;i++){
            sb.append(tansformToGoatLatin(ss[i],i));
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public String tansformToGoatLatin(String s,int index){
        char[] cc=s.toLowerCase().toCharArray();
        char head=cc[0];
        StringBuilder sb=new StringBuilder();
        if (!isVowel(head)){
            sb.append(s.substring(1));
            sb.append(s.charAt(0));
            sb.append("ma");
        }else {
            sb.append(s);
            sb.append("ma");
        }
        for (int i=index;i>=0;i--){
            sb.append("a");
        }
        return sb.toString();
    }

    public boolean isVowel(char c){
        if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode824 l=new LeetCode824();
        System.out.println(l.toGoatLatin("I speak Goat Latin"));
    }
}
