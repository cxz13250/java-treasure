package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 填充同一层的兄弟节点
 * @Date: Created in 下午3:48 2018/5/11
 * @Modified By:
 */
public class LeetCode116 {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    Map<Integer,List<TreeLinkNode>> map=new HashMap<>();

    public void connect(TreeLinkNode root) {
        check(root,0);
        for (Integer i:map.keySet()){
            List<TreeLinkNode> nodes=map.get(i);
            for (int j=0;j<nodes.size()-1;j++){
                TreeLinkNode no1=nodes.get(j);
                TreeLinkNode no2=nodes.get(j+1);
                no1.next=no2;
            }
        }
    }

    public void check(TreeLinkNode node,int height){
        if (node==null){
            return;
        }
        if (map.containsKey(height)){
            List<TreeLinkNode> nodes=map.get(height);
            nodes.add(node);
            map.put(height,nodes);
        }else {
            List<TreeLinkNode> nodes=new ArrayList<>();
            nodes.add(node);
            map.put(height,nodes);
        }
        check(node.left,height+1);
        check(node.right,height+1);
    }
}
