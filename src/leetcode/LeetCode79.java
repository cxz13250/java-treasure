package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * @Date: Created in 下午3:25 2018/6/29
 * @Modified By:
 */
public class LeetCode79 {

    public boolean exist(char[][] board, String word) {
        if (board.length==0||board[0].length==0){
            return false;
        }
        boolean[][] visit=new boolean[board.length][board[0].length];
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (check(board,visit,i,j,word,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board,boolean[][] visit,int i,int j,String word,int curLen){
        int m=board.length;
        int n=board[0].length;
        if (curLen>=word.length()){
            return true;
        }
        if (i<0||i>m||j<0||j>n||visit[i][j]||board[i][j]!=word.charAt(curLen)){
            return false;
        }
        visit[i][j]=true;
        boolean result=check(board,visit,i-1,j,word,curLen+1)||
                check(board,visit,i+1,j,word,curLen+1)||
                check(board,visit,i,j-1,word,curLen+1)||
                check(board,visit,i,j+1,word,curLen+1);
        visit[i][j]=false;
        return result;
    }
}
