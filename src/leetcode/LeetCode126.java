package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 2018/9/11
 * @Modified By:
 */
public class LeetCode126 {

    HashMap<String,Integer> heights = new HashMap<String,Integer>();
    //生成每个Word的高度
    private void bfs(String beginWord,String endWord,List<String> wordList){
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        heights.put(beginWord,0);
        String tmp = null;
        while(queue.isEmpty() == false){
            tmp = queue.poll();
            if(tmp.equals(endWord)) continue;
            char[] tmpChars = tmp.toCharArray();
            char mychar = ' ';
            //根据每个单词，按照26个字母进行构建
            for(int i=0;i<tmp.length();i++){
                for(char c='a';c<='z';c++){
                    if(c == tmpChars[i]) continue;
                    mychar = tmpChars[i];
                    tmpChars[i] = c;
                    String current = new String(tmpChars);
                    if((current.equals(endWord) || wordList.contains(current)) && heights.containsKey(current) == false){
                        int height = heights.get(tmp) + 1;
                        //System.out.println(current + "  "+ height);
                        heights.put(current,height);
                        queue.add(current);
                    }
                    tmpChars[i] = mychar;
                }
            }
        }

    }

    //使用DFS遍历结果
    public void dfs(String beginWord,String endWord,List<String> wordList, List<String> path,List<List<String>> res){
        if(beginWord.equals(endWord) == true){
            path.add(beginWord);
            Collections.reverse(path);
            res.add(path);
            return;
        }
        if(heights.get(beginWord)==null) return ;
        path.add(beginWord);
        int nextHeight = heights.get(beginWord) - 1;
        char[] tmpChars = beginWord.toCharArray();
        char mychar = ' ';
        for(int i=0;i<beginWord.length();i++){
            for(char c='a';c<='z';c++){
                if(c == tmpChars[i]) continue;
                mychar = tmpChars[i];
                tmpChars[i] = c;
                String current = new String(tmpChars);
                if(heights.containsKey(current) && heights.get(current) == nextHeight){
                    List<String> newPath = new ArrayList<String>(path);
                    dfs(current,endWord,wordList,newPath,res);
                }
                tmpChars[i] = mychar;
            }
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //答案
        List<List<String>> res = new ArrayList<List<String>>();
        if (!wordList.contains(endWord)){
            return res;
        }
        List<String> path = new ArrayList<String>();
        bfs(beginWord,endWord,wordList);
        // 注意不同
        dfs(endWord,beginWord,wordList,path,res);
        return res;
    }

    public static void main(String[] args) {
        LeetCode126 l=new LeetCode126();
        System.out.println(l.findLadders("hit", "cog", new ArrayList<String>(){{
            add("hot");
            add("dot");
            add("dog");
            add("lot");
            add("log");
//            add("cog");
        }}));
    }
}
