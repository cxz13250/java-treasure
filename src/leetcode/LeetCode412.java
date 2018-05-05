package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午12:34 2018/5/4
 * @Modified By:
 */
public class LeetCode412 {

    public List<String> fizzBuzz(int n) {
        List<String> strings=new ArrayList<>();
        for(int i=1;i<=n;i++){
            StringBuilder sb=new StringBuilder();
            if(i%3!=0&&i%5!=0){
                sb.append(i);
            }else {
                if (i % 3 == 0) {
                    sb.append("Fizz");
                }
                if (i % 5 == 0) {
                    sb.append("Buzz");
                }
            }
            strings.add(sb.toString());
        }
        return strings;
    }
}
