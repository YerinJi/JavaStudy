package algorithms.basic.linkedlist;

class LinkedListStack{
    private Node top;

    public LinkedListStack() {
        top = null;
    }
    //push
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }
    //삭제
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        int value=top.data;
        top = top.next;
        return value;
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("stack is empty");
            return -1;
        }
        return top.data;//현재 top 데이터 반환
    }
    public boolean isEmpty(){
        return (top==null);
    }



}