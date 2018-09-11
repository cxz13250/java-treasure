package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * @Date: Created in 上午11:40 2018/8/11
 * @Modified By: *
 */
public class LeetCode51 {

    //queens[i]=j,表示第i+1行的Queen在第j+1列
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        int[] queens=new int[n];
        generateQueen(queens,0,n,res);
        return res;
    }

    public boolean isValid(int[] queens, int row, int col){
        for (int i=0;i<row;i++){
            int pos=queens[i];
            if (pos == col){  //同一列
                return false;
            }
            if (pos+row-i==col){   //右对角线
                return false;
            }
            if (pos-row+i==col){   //左对角线
                return false;
            }
        }
        return true;
    }

    public void generateQueen(int[] queens,int row, int n,List<List<String>> lists){
        if (row==n){                 // 全放满进入结果集
            List<String> list=new ArrayList<>();
            for (int i=0;i<n;i++){
                String s="";
                for (int j=0;j<n;j++){
                    if (queens[i]==j){
                        s+="Q";
                    }else {
                        s+=".";
                    }
                }
                list.add(s);
            }
            lists.add(list);
            return;
        }
        for (int i=0;i<n;i++){  //i表示列
            if (isValid(queens,row,i)){  //检验row行i列是否能放皇后
                queens[row]=i;
                generateQueen(queens,row+1,n,lists);
            }
        }
    }
}
