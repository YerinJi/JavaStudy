package algorithms.basic.bfstree;

import java.util.LinkedList;
import java.util.Queue;

public class BfsBinaryTree {
    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }//NodeClass End
    Node root;
    void bfs(Node node){
        if(node == null){
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node); //루트시작
        while(!queue.isEmpty()){ //empty가 아니면  while돌기
            Node current = queue.poll(); //꺼내기
            System.out.println(current.value + " ");
            if(current.left != null){
                queue.add(current.left);
            }
            if(current.right != null){
                queue.add(current.right);
            }
        }
    }
    public static void main(String[] args) {
        BfsBinaryTree tree = new BfsBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("BEF SEARCH");
        tree.bfs(tree.root);
    }
}
