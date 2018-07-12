package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Descriptioin 给出方程式 A / B = k, 其中 A 和 B 均为代表字符串的变量， k 是一个浮点型数字。
 * 根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回 -1.0。
 * @Date: Created in 下午3:31 2018/7/2
 * @Modified By: *
 */
public class LeetCode399 {

    class Edge{
        public String source;
        public String target;
        public double value;
        public Edge(String source, String target, double value){
            this.source = source;
            this.target = target;
            this.value = value;
        }
    }

    Set<String> visit=new HashSet<>();
    Map<String,List<Edge>> graph=new HashMap<>();

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] result=new double[queries.length];
        for (int i=0;i<equations.length;i++){
            String[] equation=equations[i];
            String source=equation[0];
            String target=equation[1];
            double value=values[i];
            List<Edge> targets=graph.containsKey(source)?graph.get(source):new ArrayList<>();
            targets.add(new Edge(source,target,value));
            graph.put(source,targets);
            List<Edge> sources=graph.containsKey(target)?graph.get(target):new ArrayList<>();
            if (value != 0) {
                sources.add(new Edge(target, source, 1 / value));
            }
            graph.put(target,sources);
        }
        for (int i=0;i<queries.length;i++){
            String[] query=queries[1];
            result[i]=check(query[0],query[1],1);
        }
        return result;
    }

    public double check(String source,String target,double value){
        if (!graph.containsKey(source)){
            return -1;
        }else {
            if (source.equals(target)){
                return 1;
            }else {
                List<Edge> edgesFromSource=graph.get(source);
                for (Edge e:edgesFromSource){
                    if (e.target.equals(target)){
                        return e.value;
                    }
                }
                for (Edge e:edgesFromSource){
                    if (visit.contains(e.target)){
                        continue;
                    }
                    visit.add(e.target);
                    double val=check(e.target,target,value);
                    visit.remove(e.target);
                    if (val!=-1){
                        return value*val*e.value;
                    }
                }
            }
        }
        return -1;
    }
}
