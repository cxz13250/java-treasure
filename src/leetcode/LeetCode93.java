package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * @Date: Created in 下午9:54 2018/6/22
 * @Modified By:
 */
public class LeetCode93 {

    List<String> result=new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        check(s,0,new ArrayList<>());
        return result;
    }

    public void check(String s,int cur,List<String> list){
        if (cur>s.length()){
            return;
        }
        if (list.size()>=4&&cur<s.length()){
            return;
        }
        if (list.size()==4&&cur==s.length()){
            String temp=toString(list);
            result.add(temp);
        }
        for (int i=cur+1;i<=Math.min(s.length(),cur+3);i++){
            String temp=s.substring(cur,i);
            if (i>cur+1&&s.charAt(cur)=='0'){
                continue;
            }
            if (Integer.valueOf(temp)>255){
                return;
            }
            list.add(temp);
            check(s,i,list);
            list.remove(list.size()-1);
        }
    }

    public String toString(List<String> list){
        return list.get(0)+"."+list.get(1)+"."+list.get(2)+"."+list.get(3);
    }

    public static void main(String[] args) {
        LeetCode93 l=new LeetCode93();
        System.out.println(l.restoreIpAddresses("10001"));
    }
}
