package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Description 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 * @Date: Created in 2018/7/19
 * @Modified By:
 */
public class LeetCode547 {

    Set<Integer> set=new HashSet<>();
    public int findCircleNum(int[][] M) {
        int N=M.length;
        if (N==0||M[0].length==0){
            return 0;
        }
        int count=0;
        for (int i=0;i<N;i++){
            if (!set.contains(i)){
                findFriends(M, i);
                count++;
            }
        }
        return count;
    }

    public void findFriends(int[][] M, int index){
        int N=M.length;
        Queue<Integer> queue=new LinkedList<>();
        set.add(index);
        queue.offer(index);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int j = 0; j < N; j++) {
                if (j != temp && M[temp][j] == 1 && !set.contains(j)) {
                    set.add(j);
                    queue.offer(j);
                }
            }
        }
    }

    public static void main(String[] args) {
        LeetCode547 l=new LeetCode547();
        int[][] ss={{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        System.out.println(l.findCircleNum(ss));
    }
}
