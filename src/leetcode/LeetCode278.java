package leetcode;

/**
 * @Author ROKG
 * @Description 假设你有 n 个版本 [1, 2, ..., n]，你想找出第一个错误的版本，导致下面所有的错误。
 * @Date: Created in 下午3:24 2018/4/30
 * @Modified By:
 */


public class LeetCode278 {

    public int firstBadVersion(int n) {
        int left=1;
        int right=n;
        while(left<right){
            int temp=left+(right-left)/2;
            if(isBadVersion(temp)){
                right=temp;
            }else{
                left=temp+1;
            }
        }
        return left;
    }

    boolean isBadVersion(int i){
        return true;
    }

}
