package algorithms.basic.linkedlist;

//class Node{
//    int data;
//    Node next;
//    public Node(int data) {
//        this.data = data;
//    }
//}

public class LinkedListStackExample {
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        stack.push(5);
        stack.push(15);
        stack.push(25);
        System.out.println("Peek: " + stack.peek()); // 출력: 25
        System.out.println("Pop: " + stack.pop()); // 출력: 25
        System.out.println("Peek: " + stack.peek()); // 출력: 15

        while (!stack.isEmpty()) {
            System.out.println("Pop: " + stack.pop());
        }

        System.out.println("Pop on empty stack: " + stack.pop()); // 스택 비었을 때




    }
}