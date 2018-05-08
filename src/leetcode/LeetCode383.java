package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
 * 如果可以构成，返回 true ；否则返回 false。
 * @Date: Created in 下午5:30 2018/5/8
 * @Modified By:
 */
public class LeetCode383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] num=new int[128];
        for (int i=0;i<magazine.length();i++){
            num[magazine.charAt(i)]++;
        }
        for (int i=0;i<ransomNote.length();i++){
            if (num[ransomNote.charAt(i)]==0){
                return false;
            }else {
                num[ransomNote.charAt(i)]--;
            }
        }
        return true;
    }
}
