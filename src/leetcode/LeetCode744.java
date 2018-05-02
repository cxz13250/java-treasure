package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
 * @Date: Created in 上午11:47 2018/5/2
 * @Modified By:
 */
public class LeetCode744 {

    public char nextGreatestLetter(char[] letters, char target) {
        if(letters[letters.length-1]<=target){
            return letters[0];
        }
        int low=0;
        int high=letters.length-1;
        while(low<high){
            int mid=(low+high)/2;
            if(target<letters[mid]){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return letters[low];
    }
}
