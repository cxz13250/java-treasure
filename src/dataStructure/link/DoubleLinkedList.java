package dataStructure.link;

/**
 * @Author ROKG
 * @Description 双链表
 * @Date: Created in 下午3:50 2018/4/1
 * @Modified By:
 */
public class DoubleLinkedList {
    Node head;
    Node last;
    int itemCount=0;
    private class Node{
        Integer data;
        Node pre;
        Node next;
        Node(Integer item) {
            data=item;
        }
    }

    /**
     * 双链表插入元素
     * @param item
     */
    public void insert(Integer item){
        Node node=new Node(item);
        if(last!=null){
            last.next=node;
            node.pre=last;
        }
        last=node;
        if (itemCount == 0) {
            head = last;
        }
        itemCount++;
    }

    /**
     * 双链表删除元素
     * @param index
     * @return
     */
    public Integer delete(int index){
        if(index<1 || index>itemCount){
            return null;
        }
        if(last==null){
            return null;
        }
        if(index==1){
            Integer item=head.data;
            Node node=head.next;
            head=head.next;
            node.next.pre=head;
            return item;
        }
        Node node=head;
        Node current=node.next;
        int i=2;
        while (current!=null){
            if(i==index){
                int item=node.data;
                node.next=current.next;
                current.next.pre=node;
                return item;
            }
            node=current;
            current=current.next;
            i++;
        }
        return null;
    }

    public int getItemCount(){
        return this.itemCount;
    }

    /**
     * 打印链表内容
     */
    public void print(){
        Node tmp=head;
        while(tmp!=null){
            System.out.println(tmp.data);
            tmp=tmp.next;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.insert(5);
        list.insert(3);
        list.insert(1);
        list.insert(2);
        list.insert(55);
        list.insert(36);
        list.insert(36);
        System.out.println("双链表长度:" + list.getItemCount());
        System.out.println("头结点数据:" + list.head.data);
        list.print();
        list.delete(4);
        System.out.println("delete(4)之后:");
        list.print();
    }
}
