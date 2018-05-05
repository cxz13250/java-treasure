package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个字符串来代表一个学生的出勤纪录，这个纪录仅包含以下三个字符：
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * 如果一个学生的出勤纪录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 * @Date: Created in 下午2:08 2018/5/2
 * @Modified By:
 */
public class LeetCode551 {

    public boolean checkRecord(String s) {
        if(s.length()==0){
            return false;
        }
        char[] cc=s.toCharArray();
        int sumA=0;
        for(int i=0;i<cc.length;i++){
            if(cc[i]=='A'){
                sumA++;
            }
            if(sumA>1){
                return false;
            }
            if(cc[i]=='L'){
                int sumL=1;
                while (i+1<cc.length){
                    if(cc[i+1]=='L'){
                        sumL++;
                        i++;
                    }else {
                        break;
                    }
                }
                if(sumL>2){
                    return false;
                }
            }
        }
        return true;
    }
}
