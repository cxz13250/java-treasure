package leetcode;

/**
 * @Author ROKG
 * @Description 给出一些不同颜色的盒子，盒子的颜色由数字表示，即不同的数字表示不同的颜色。
 * 你将经过若干轮操作去去掉盒子，直到所有的盒子都去掉为止。每一轮你可以移除具有相同颜色的连续 k 个盒子（k >= 1），这样一轮之后你将得到 k*k 个积分。
 * 当你将所有盒子都去掉之后，求你能获得的最大积分和。
 * @Date: Created in 下午11:18 2018/8/26
 * @Modified By: *
 */
public class LeetCode546 {

    // 动态规划 res[l][r][k]表示从l到r的元素且后面有k个和r相同的元素能得到的最大值
    // res[l][r][k]最大值有两种情况，第一种：删除r位置元素和后面的k个元素，得到分数(k+1)^2 + res[l][r-1][0]的最大值（继续递归）
    // 第二种：l和r之间存在于r相同的元素，位置为i，则分数为res[l][i][k+1]+res[i+1][r-1][0]
    public int removeBoxes(int[] boxes) {
        int n=boxes.length;
        int[][][] res=new int[100][100][100];
        return dfs(res,0,n-1,0,boxes);
    }

    public int dfs(int[][][] res,int l,int r,int k,int[] boxs){
        if (r<l){
            return 0;
        }
        while (l<r&&boxs[r-1]==boxs[r]){
            r--;
            k++;
        }
        if (res[l][r][k]>0){
            return res[l][r][k];
        }else {
            res[l][r][k]=dfs(res,l,r-1,0,boxs)+(k+1)*(k+1);
            for (int i=l;i<r;i++){
                if (boxs[i]==boxs[r]){
                    res[l][r][k]=Math.max(res[l][r][k],dfs(res,l,i,k+1,boxs)+dfs(res,i+1,r-1,0,boxs));
                }
            }
            return res[l][r][k];
        }
    }
}
