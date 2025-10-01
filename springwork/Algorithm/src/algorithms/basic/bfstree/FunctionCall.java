package algorithms.basic.bfstree;

public class FunctionCall {
    public void inorder(int data){
        if(data==0){
            return;
        }
        inorder(data-1);
        System.out.println(data);
    }

    public static void main(String[] args) {
        FunctionCall f = new FunctionCall();
        f.inorder(5);
    }
}
