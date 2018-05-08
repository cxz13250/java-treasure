package dataStructure.link;

/**
 * @Author ROKG
 * @Description 单链表
 * @Date: Created in 下午3:49 2018/4/1
 * @Modified By:
 */
public class LinkedList {
    Node head;

    private class Node {
        Integer data;
        Node next;
        Node(Integer item) {
            data=item;
        }
    }

    /**
     * 链表插入元素
     * @param item
     */
    public void insert(Integer item){
        Node node=new Node(item);
        if(head == null){
            head=node;
        }else {
            Node tmp=head;
            while(tmp.next != null){
                tmp=tmp.next;
            }
            tmp.next=node;
        }
    }

    /**
     * 链表删除元素
     * @param index
     * @return
     */
    public Integer delete(int index){
        if(index<1 || index>length()){
            return null;
        }
        if(index==1){
            Integer item=head.data;
            head=head.next;
            return item;
        }
        int i=2;
        Integer item=null;
        Node pre=head;
        Node current=pre.next;
        while (current != null){
            if(i == index){
                item=current.data;
                pre.next=current.next;
                return item;
            }
            pre=current;
            current=current.next;
            i++;
        }
        return item;
    }

    /**
     * 链表删除元素
     * @param node
     * @return
     */
    public boolean delete(Node node){
        if(node==null || node.next==null){
            return false;
        }
        Integer item=node.data;
        node.data=node.next.data;
        node.next.data=item;
        node.next=node.next.next;
        return true;
    }


    /**
     * 从小到大排序
     */
    public void sort(){
        Node node=head;
        int tmp=0;
        while (node.next!=null){
            Node current=node.next;
            while (current!=null){
                if(node.data>current.data){
                    tmp=node.data;
                    node.data=current.data;
                    current.data=tmp;
                }
                current=current.next;
            }
            node=node.next;
        }
    }

    /**
     * 链表反转
     * @return
     */
    public void reverse(){
        Node node=head;
        Node pre=null;
        while (node!=null){
            Node current=node.next;
            if(current==null){
                head=node;
            }
            node.next=pre;
            pre=node;
            node=current;
        }
    }

    /**
     * 链表去重
     */
    public void dereplicate(){
        Node node=head;
        while (node!=null){
            Node current=node;
            while (current.next!=null){
                if(current.next.data.equals(node.data)){
                    current.next=current.next.next;
                }else {
                    current=current.next;
                }
            }
            node=node.next;
        }
    }

    /**
     * 两个有序链表合并
     * @param p
     * @param q
     * @return
     */
    public Node merge(Node p,Node q){
        Node pa=p;
        Node pb=q;
        Node head=null;
        Node pc=null;
        int i=0;
        while (pa!=null&&pb!=null){
            if(i==0){
                if(pa.data<=pb.data){
                    pc=pa;
                    pa=pa.next;
                }else {
                    pc=pb;
                    pb=pb.next;
                }
                head=pc;
                i++;
            }else {
                if(pa.data<=pb.data){
                    pc.next=pa;
                    pc=pa;
                    pa=pa.next;
                }else {
                    pc.next=pb;
                    pc=pb;
                    pb=pb.next;
                }
            }
        }
        pc.next=(pa==null)?pa:pb;
        return head;
    }

    /**
     * 逆序输出链表
     * @param head
     */
    public void reversePrint(Node head){
        if(head!=null){
            reversePrint(head.next);
            System.out.println(head.data);
        }
    }

    /**
     * 获取链表长度
     * @return
     */
    public int length(){
        int length=0;
        Node node=head;
        while(node.next != null){
            length++;
            node=node.next;
        }
        return length;
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
        LinkedList list = new LinkedList();
        list.insert(5);
        list.insert(3);
        list.insert(1);
        list.insert(2);
        list.insert(55);
        list.insert(36);
        list.insert(36);
        System.out.println("单链表长度:" + list.length());
        System.out.println("头结点数据:" + list.head.data);
        list.print();
        list.delete(4);
        System.out.println("delete(4)之后:");
        list.print();
        list.reverse();
        System.out.println("链表反转之后:");
        list.print();
        list.sort();
        System.out.println("链表从小到大排序后:");
        list.print();
        list.dereplicate();
        System.out.println("链表去重后:");
        list.print();
        System.out.println("链表逆序输出:");
        list.reversePrint(list.head);
    }
}
