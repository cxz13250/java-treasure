package leetcode;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午11:39 2018/5/9
 * @Modified By:
 */
public class LeetCode374 {

    /* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */
    public int guessNumber(int n) {
        int low = 1, high = n;
        int mid = low + (high - low) / 2;
        int flag = guess(mid);
        while (flag != 0 && low < high){
            if (flag == 1){
                low = mid + 1;
            }
            else if (flag == -1){
                high = mid - 1;
            }
            mid = low + (high - low) / 2;

            flag = guess(mid);
        }
        return mid;
    }

    public int guess(int n){
        return 0;
    }
}
