package dataStructure.queue;

/**
 * @Author ROKG
 * @Description 链队
 * @Date: Created in 下午12:52 2018/4/5
 * @Modified By:
 */
public class LinkedQueue {

    private Node front;
    private Node rear;

    private class Node{
        Integer data;
        Node next;

        Node(Integer data,Node node) {
            this.data=data;
            this.next=node;
        }
    }

    LinkedQueue(){
        Node n=new Node(null,null);
        n.next=null;
        front=rear=n;
    }

    public void enQueue(int data){
        Node node=new Node(data,null);
        rear.next=node;
        rear=node;
        if(front.next==null){
            front.next=node;
        }
    }

    public Integer deQueue(){
        if(rear==front){
            return null;
        }else {
            Node node=front.next;
            int data=node.data;
            front.next=node.next;
            if(node.next==null){
                rear=front;
            }
            node=null;
            return data;
        }
    }
}
