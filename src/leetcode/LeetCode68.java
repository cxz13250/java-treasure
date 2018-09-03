package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * @Date: Created in 2018/9/3
 * @Modified By: *
 */
public class LeetCode68 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result=new ArrayList<>();
        int start=0,end=1,n=words.length;
        while (start<n){
            int space=0;
            int wordLen=words[start].length();
            while (end<n&&space+1+wordLen+words[end].length()<=maxWidth){
                space++;
                wordLen+=words[end].length();
                end++;
            }
            StringBuilder sb=new StringBuilder(words[start]);
            if (end==n){
                for (int i=start+1;i<end;i++){
                    sb.append(" ");
                    sb.append(words[i]);
                }
                for (int i=space+wordLen;i<maxWidth;i++){
                    sb.append(" ");
                }
                result.add(sb.toString());
            }else if (end-start==1){
                for (int i=0;i<maxWidth-words[start].length();i++){
                    sb.append(" ");
                }
                result.add(sb.toString());
            }else {
                int baseSpace=(maxWidth-wordLen)/(end-start-1);
                int remains=(maxWidth-wordLen)%(end-start-1);
                for (int i=start+1;i<end;i++){
                        for (int j=0;j<baseSpace;j++){
                            sb.append(" ");
                        }
                        if (remains-->0){
                            sb.append(" ");
                        }
                        sb.append(words[i]);
                }
                result.add(sb.toString());
            }
            start=end;
            end=end+1;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
