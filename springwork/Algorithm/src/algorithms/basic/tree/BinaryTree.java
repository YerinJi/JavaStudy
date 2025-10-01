package algorithms.basic.tree;

class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        left = right = null;
    }
}
public class BinaryTree {
    Node root;
    //전위순회 (Preorder)
    void preOrder(Node node){
        if(node == null) return;
        System.out.println(node.value); //value확인
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(); //Node
        tree.root = new Node(1); //value(1)|left|right
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("전위순회");
        tree.preOrder(tree.root);
    }
}
