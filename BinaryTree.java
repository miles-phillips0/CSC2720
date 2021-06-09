public class BinaryTree {
    Node root;
    public void addNode(int key, String name){
        Node newNode = new Node(key, name);
        if(root == null){
            root = newNode;
        }
        else{
            Node focusNode = root;
            Node parent;
            while(true){
                parent = focusNode;
                if(key < focusNode.key){
                    focusNode = focusNode.leftChild;
                    if(focusNode == null){
                        parent.leftChild = newNode;
                        return;
                    }

                } else{
                    focusNode = focusNode.rightChild;
                    if(focusNode == null){
                     parent.rightChild = newNode;
                     return;
                    }
                }
            }
        }
    }
    
    public void inOrderTraverse(Node focusNode){
        inOrderTraverse(focusNode.leftChild);
        System.out.println(focusNode);
        inOrderTraverse(focusNode.rightChild);
    }
    public void postOrderTraverse(Node focusNode){
        postOrderTraverse(focusNode.leftChild);
        postOrderTraverse(focusNode.rightChild);
        System.out.println(focusNode);
    }
    public void preOrderTraverse(Node focusNode){
        System.out.println(focusNode);
        preOrderTraverse(focusNode.leftChild);
        preOrderTraverse(focusNode.rightChild);
    }
    public static void main(String [] args){

    }
    class Node{
        int key;
        String name;
        Node leftChild;
        Node rightChild;
        Women woman = new Women();

        Node(int key, String name){
            this.key = key;
            this.name = name;
            woman.name = name;

        }

        public String toString(){
            return name + "has key: " + key;
        }

    }
}
