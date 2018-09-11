package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 定义由 n 个连接的字符串 s 组成字符串 S，即 S = [s,n]。例如，["abc", 3]=“abcabcabc”。
 * 另一方面，如果我们可以从 s2 中删除某些字符使其变为 s1，我们称字符串 s1 可以从字符串 s2 获得。
 * 例如，“abc” 可以根据我们的定义从 “abdbec” 获得，但不能从 “acbbe” 获得。
 * 现在给出两个非空字符串 S1 和 S2（每个最多 100 个字符长）和两个整数 0 ≤ N1 ≤ 106 和 1 ≤ N2 ≤ 106。
 * 现在考虑字符串 S1 和 S2，其中S1=[s1,n1]和S2=[s2,n2]。找出可以使[S2,M]从 S1 获得的最大整数 M。
 * @Date: Created in 下午11:53 2018/9/6
 * @Modified By: *
 */
public class LeetCode466 {

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int count=0,k=-1;
        String s=s1;
        StringBuilder sb;
        List<String> stringList=new ArrayList<>();
        stringList.add("");
        List<Integer> countList=new ArrayList<>();
        countList.add(0);
        for (int i=0;i<=n1;i++){
            sb=new StringBuilder();
            count+=getRemain(s,s2,sb);
            String remain=sb.toString();
            if ((k=stringList.indexOf(remain))!=-1){   // 出现环，即已经出现过得剩余字符串
                break;
            }
            stringList.add(remain);
            countList.add(count);
            s=remain+s1;
        }
        if (k!=-1){
            int countLoop=count-countList.get(k);  // 环里面有多少个s2
            int loopLength=stringList.size()-k;   // 环的长度即多少个s1
            count=countList.get(k);   // 出现环之前，k个s1中s2的个数
            n1-=k;
            count+=countLoop*(n1/loopLength);
            n1%=loopLength;        // n1个s1的末尾还有剩余
            count+=countList.get(k+n1)-countList.get(k);   // 求这剩余长度里s2的数量，因为是循环关系，所以直接取环的起点向后增加剩余的长度对应的s2数量
        }
        return count/n2;
    }

    public int getRemain(String s1,String s2,StringBuilder remain){
        int cnt=0, lastMatch=-1, p2=0;
        for (int p1=0;p1<s1.length();p1++) {
            if (s1.charAt(p1)==s2.charAt(p2)) {
                if (++p2==s2.length()) {
                    p2=0;
                    cnt++;
                    lastMatch=p1;
                }
            }
        }
        remain.append(s1.substring(lastMatch+1));
        return cnt;
    }

    public int getCount(String s1,int index,String s2){
        if (index>=s1.length()){
            return 0;
        }
        int i=index;
        int j=0;
        while (i<s1.length()&&j<s2.length()){
            if (s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }else {
                i++;
            }
        }
        if (j==s2.length()){
            return 1+getCount(s1,i,s2);
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        LeetCode466 l=new LeetCode466();
        System.out.println(l.getMaxRepetitions("aaa",3,"aa",1));
    }
}
