package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个单词，你需要判断单词的大写使用是否正确。我们定义，在以下情况时，单词的大写用法是正确的：
 * 全部字母都是大写，比如"USA"。
 * 单词中所有字母都不是大写，比如"leetcode"。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 * 否则，我们定义这个单词没有正确使用大写字母。
 * @Date: Created in 下午11:27 2018/5/3
 * @Modified By:
 */
public class LeetCode520 {

    public boolean detectCapitalUse(String word) {
        char[] cc=word.toCharArray();
        if(cc.length<=1){
            return true;
        }
        if(cc[0]>='A'&&cc[0]<='Z'){
            if(cc[1]>='A'&&cc[1]<='Z'){
                for(int i=2;i<cc.length;i++){
                    if(cc[i]>='a'&&cc[i]<='z'){
                        return false;
                    }
                }
                return true;
            }else {
                for(int i=1;i<cc.length;i++){
                    if(cc[i]>='A'&&cc[i]<='Z'){
                        return false;
                    }
                }
                return true;
            }

        }else {
            for(int i=1;i<cc.length;i++){
                if(cc[i]>='A'&&cc[i]<='Z'){
                    return false;
                }
            }
            return true;
        }
    }
}
