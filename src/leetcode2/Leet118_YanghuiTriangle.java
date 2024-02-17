package leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 杨辉三角
 * @Date: Created in 上午9:40 2024/2/17
 * @Modified By:
 */
public class Leet118_YanghuiTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>(i + 1);
            ;
            if (i == 0) {
                tmp.add(1);
            } else {
                List<Integer> last = res.get(i - 1);
                for (int j = 0; j < i + 1; j++) {
                    tmp.add((j == 0 ? 0 : last.get(j - 1)) + (j >= last.size() ? 0 : last.get(j)));
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
