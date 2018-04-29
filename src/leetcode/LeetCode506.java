package leetcode;

import java.util.Arrays;

/**
 * @Author ROKG
 * @Description 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
 * @Date: Created in 下午8:16 2018/4/26
 * @Modified By:
 */
public class LeetCode506 {

    public String[] findRelativeRanks(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        String result[]=new String[nums.length];
        int[] temp=new int[max+1];
        for(int i=0;i<nums.length;i++){
            temp[nums[i]]=i+1;
        }
        int count=1;
        for(int i=temp.length-1;i>=0;i++){
            if(temp[i]==0){
                continue;
            }
            if(count<=3){
                if(count==1){
                    result[temp[i]]="Gold Medal";
                }else if(count==2){
                    result[temp[i]]="Silver Medal";
                }else if(count==3){
                    result[temp[i]]="Bronze Medal";
                }
            }else{
                result[temp[i]]=count+"";
                count++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
    }
}
