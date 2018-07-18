package leetcode;

/**
 * @Author ROKG
 * @Description 文件的最长绝对路径
 * @Date: Created in 下午1:49 2018/7/14
 * @Modified By:
 */
public class LeetCode388 {

    public int lengthLongestPath(String input) {

        int[] lengths=new int[10000];
        int max=-1;
        String[] ss=input.split("\n");
        for (String s:ss){
            char[] cc=s.toCharArray();
            int index=0;
            while (index<cc.length&&cc[index]=='\t'){
                index++;
            }
            int temp=cc.length-index;
            if (s.indexOf(".")>-1&&!s.endsWith(".")){
                int total=0;
                for (int i=0;i<index;i++){
                    total+=lengths[i];
                    total++;
                }
                total+=temp;
                max=Math.max(total,max);
            }else {
                lengths[index]=temp;
            }
        }
        return max==-1?0:max;
    }
}
