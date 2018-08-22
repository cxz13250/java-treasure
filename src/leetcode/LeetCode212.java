package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * @Date: Created in 2018/8/21
 * @Modified By: *
 */
public class LeetCode212 {
    class TrieNode{
        char c;
        TrieNode[] children=new TrieNode[26];
        boolean isWord;
        TrieNode(char c){
            this.c=c;
        }
        TrieNode() {}
    }

    TrieNode root=new TrieNode();

    // 使用目标字符串数组构建前缀树，然后一次检验矩阵中各位置开头元素作为前缀树开始节点，将遍历完成的字符串添加到结果集中
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res=new ArrayList<>();
        if (words==null||words.length==0){
            return res;
        }
        TrieNode node;
        for (String s:words){
            node=root;
            for (char c:s.toCharArray()){
                if (node.children[c-'a']==null){
                    node.children[c-'a']=new TrieNode(c);
                }
                node=node.children[c-'a'];
            }
            node.isWord=true;
        }
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                dfs(board, i, j, "", res, root.children[board[i][j]-'a']);
                if (res.size()==words.length){
                    break;
                }
            }
            if (res.size()==words.length){
                break;
            }
        }
        return res;
    }

    public void dfs(char[][] board,int i,int j,String word,List<String> res,TrieNode node){
        int m=board.length,n=board[0].length;
        if (node==null||board[i][j]=='#'){
            return;
        }
        if (node.isWord){
            res.add(word);
            node.isWord=false;
        }
        char c=board[i][j];
        word+=c;
        board[i][j]='#';
        if (i-1>=0&&board[i-1][j]!='#'){
            dfs(board, i-1, j, word, res, node.children[board[i-1][j]-'a']);
        }
        if (i+1<m&&board[i+1][j]!='#'){
            dfs(board, i+1, j, word, res, node.children[board[i+1][j]-'a']);
        }
        if (j-1>=0&&board[i][j-1]!='#'){
            dfs(board, i, j-1, word, res, node.children[board[i][j-1]-'a']);
        }
        if (j+1<n&&board[i][j+1]!='#'){
            dfs(board, i, j+1, word, res, node.children[board[i][j+1]-'a']);
        }
        board[i][j]=c;
    }

    public static void main(String[] args) {
        LeetCode212 l=new LeetCode212();
        System.out.println(l.findWords(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}}, new String[]{"oath","eat"}));
    }
}

