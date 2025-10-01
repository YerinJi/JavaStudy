package algorithms.basic.linkedlist;

public class DoubleLinkedList {
    class Node{
        int data;
        Node prev, next;

        public Node(int data) {
            this.data = data;
            prev = null;
            next = null;
        }//constructor
    }//innerClass Node
    private Node head;//리스트의 시작노드
    private Node tail;//리스트의 마지막노드

    //생성자
    public DoubleLinkedList() {
        head = null;
        tail = null;
    }
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail= newNode;// head가 null이란 첫번째노드이며 첫번째 노드란 (head|taile)동시발생
        }else{//두번째 노드부터
            tail.next = newNode;//newNode는 tailNode안에 next에 다음 노드로 들어간다
            newNode.prev = tail;
            tail = newNode;

        }//else
    }//addLast

    public void printList(){
        Node current = head;
        System.out.println("LIST");
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println();
    }
    public void delete(int value){
        Node current = head;
        while (current != null) {
            if (current.data == value) {//삭제할 데이터를 찾았을때....
                if(current == head){
                    head =current.next;
                    if(head == null){
                        head.prev = null;
                    }else if(current == tail){
                        tail =current.prev;//
                    }

                }

            }
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.printList();
    }





}