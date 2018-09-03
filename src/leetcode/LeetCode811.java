package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 一个网站域名，如"discuss.leetcode.com"，包含了多个子域名。作为顶级域名，常用的有"com"，下一级则有"leetcode.com"，最低的一级为"discuss.leetcode.com"。当我们访问域名"discuss.leetcode.com"时，
 * 也同时访问了其父域名"leetcode.com"以及顶级域名 "com"。
 * 给定一个带访问次数和域名的组合，要求分别计算每个域名被访问的次数。其格式为访问次数+空格+地址，例如："9001 discuss.leetcode.com"。
 * 接下来会给出一组访问次数和域名组合的列表cpdomains 。要求解析出所有域名的访问次数，输出格式和输入格式相同，不限定先后顺序。
 * @Date: Created in 2018/9/3
 * @Modified By:
 */
public class LeetCode811 {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> map=new HashMap<>();
        for (String s:cpdomains){
            check(s,map);
        }
        List<String> list=new ArrayList<>();
        for (String s:map.keySet()){
            list.add(map.get(s)+" "+s);
        }
        return list;
    }

    public void check(String s, Map<String,Integer> map){
        String count=s.split(" ")[0];
        Integer i=Integer.valueOf(count);
        String[] ss=s.split(" ")[1].split("\\.");
        StringBuilder sb=new StringBuilder(ss[ss.length-1]);
        map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+i);
        for (int j=ss.length-2;j>=0;j--){
            sb.insert(0, ss[j]+".");
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+i);
        }
    }

    public static void main(String[] args) {
        LeetCode811 l=new LeetCode811();
        System.out.println(l.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }
}
