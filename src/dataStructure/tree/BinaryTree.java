package dataStructure.tree;

import java.util.*;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午8:40 2018/4/1
 * @Modified By:
 */
public class BinaryTree {

    int size;
    TreeNode root;
    TreeNode nodes[];
    List<Integer> list=new ArrayList<>();

    public class TreeNode{
        Integer data;
        TreeNode left;
        TreeNode right;
        TreeNode(int item){
            data=item;
        }
        public void setLeft(TreeNode node){
            left=node;
        }
        public void setRight(TreeNode node){
            right=node;
        }
    }

    public BinaryTree(){

    }

    BinaryTree(int[] arr){
        size=arr.length;
        nodes=new TreeNode[size];
        for(int i=0;i<size;i++){
            nodes[i]=new TreeNode(arr[i]);
        }
        root=nodes[0];
        for(int j=0;j<=(size-2)/2;j++){
            nodes[j].setLeft(nodes[2*j+1]);
            nodes[j].setRight(nodes[2*j+2]);
        }
    }

    /**
     * 递归实现先序遍历
     * @param t
     */
    public void preOrder(TreeNode t){
        if(t!=null){
            print(t);
            preOrder(t.left);
            preOrder(t.right);
        }
    }

    /**
     * 递归实现中序遍历
     * @param t
     */
    public void midOrder(TreeNode t){
        if(t!=null){
            midOrder(t.left);
            print(t);
            midOrder(t.right);
        }
    }

    /**
     * 递归实现后序遍历
     * @param t
     */
    public void postOrder(TreeNode t){
        if(t!=null){
            postOrder(t.left);
            postOrder(t.right);
            print(t);
        }
    }

    /**
     * 非递归实现先序遍历
     */
    public void preOrder(){
        TreeNode node=root;
        Stack<TreeNode> stack=new Stack<>();
        while (node!=null || !stack.empty()){
            if(node!=null){
                stack.push(node);
                System.out.println(node.data);
                node=node.left;
            }else {
                node=stack.pop();
                node=node.right;
            }
        }
    }

    /**
     * 非递归后序遍历
     */
    public void postOrder(){
        if (root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        TreeNode last=null;
        while (cur!=null){
                stack.push(cur);
                cur=cur.left;
        }
        while (!stack.isEmpty()){
            cur=stack.pop();
            if (cur.right!=null&&cur.right!=last){
                stack.push(cur);
                cur=cur.right;
                while (cur!=null){
                    stack.push(cur);
                    cur=cur.left;
                }
            }else {
                System.out.println(cur.data);
                last=cur;
            }
        }
    }

    /**
     * 广度优先遍历
     * @param node
     */
    public void BFS(TreeNode node){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            TreeNode temp =queue.poll();
            System.out.print(temp.data+" ");
            if(temp.left!=null){
                queue.offer(temp.left);
            }
            if(temp.right!=null){
                queue.offer(temp.right);
            }
        }
    }

    /**
     * 打印从根节点到所有叶子节点的路径
     * @param node
     */
    public void findAllPath(TreeNode node){
        if(node==null){
            return;
        }
        list.add(node.data);
        if(node.left==null&&node.right==null){
            printPath();
        }
        if(node.left!=null){
            findAllPath(node.left);
        }
        if(node.right!=null){
            findAllPath(node.right);
        }
        list.remove(node.data);
    }

    public void printPath(){
        for(Integer i:list){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public void print(TreeNode t){
        System.out.println(t.data);
    }

    public static void main(String[] args) {
        int[] arrayNode = new int[]{1,2,3,4,5,6,7,8,9};
        BinaryTree bt = new BinaryTree(arrayNode);
        System.out.println("递归先序遍历:");
        bt.preOrder(bt.root);
        System.out.println("递归中序遍历:");
        bt.midOrder(bt.root);
        System.out.println("递归后序遍历:");
        bt.postOrder(bt.root);
        System.out.println("非递归先序遍历:");
        bt.preOrder();
        System.out.println("非递归后序遍历:");
        bt.postOrder();
        System.out.println("输出从根节点到所有叶子节点的路径:");
        bt.findAllPath(bt.root);
    }
}
