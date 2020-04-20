package employee;

import java.util.*;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午7:00 2018/9/20
 * @Modified By:
 */
public class XiaoMi1_1 {

    public static List<String> check(List<String> list){
        List<String> res=new ArrayList<>();
        Map<Long,List<String>> map=new HashMap<>();
        for (int i=0;i<list.size();i++){
            String[] ss=list.get(i).split("#");
            long tmp=change(Integer.valueOf(ss[0]),ss[1]);
            if (!map.containsKey(tmp)){
                List<String> nodes=new ArrayList<>();
                nodes.add(list.get(i));
                map.put(tmp,nodes);
            }else {
                map.get(tmp).add(list.get(i));
            }
        }
        for (long key:map.keySet()){
            if (map.get(key).size()==1){
                res.add(map.get(key).get(0));
            }
        }
        if (res.size()==0) {
            res.add("None");
        }
        return res;
    }

    public static long change(int n,String m){
        char cc[]=m.toCharArray();
        long res=0;
        for (int i=0;i<cc.length;i++){
            res+=Math.pow(n,cc.length-i-1)*(cc[i]-'0');
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<String> list=new ArrayList<>();
        String s;
        while (!((s=sc.next()).equals("END"))){
            list.add(s);
        }
        List<String> res=check(list);
        for (String str:res) {
            System.out.println(str);
        }
    }
}
